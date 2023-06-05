package com.USM.PIB.Controladores;

import com.USM.PIB.Modelos.*;
import com.USM.PIB.Repositorios.PeticionRepositorio;
import com.USM.PIB.Servicios.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class vistaControlador {
    @Autowired
    private InstitucionServicio institucionServicio;
    @Autowired
    private BibliotecaServicio bibliotecaServicio;
    @Autowired
    private PeticionControlador peticionControlador;
    @Autowired
    private PrestatarioControlador prestatarioControlador;
    @Autowired
    private GestorControlador gestorControlador;
    @Autowired
    private GestorServicio gestorServicio;
    @Autowired
    private Tipo_itemServicio tipoItemServicio;
    @Autowired
    private PeticionServicio peticionServicio;
    @Autowired
    private Terminos_EnvioServicio terminosEnvioServicio;
    @Autowired
    private Tipo_envioServicio tipoEnvioServicio;
    @Autowired
    private  PeticionRepositorio peticionRepositorio;
    @Autowired
    private Tipo_envioControlador tipoEnvioControlador;
    @Autowired
    private MensajesControlador mensajesControlador;
    @Autowired
    private PrestatarioServicio prestatarioServicio;
    @Autowired
    private Nivel_GestorControlador nivelGestorControlador;
    @Autowired
    private BibliotecaControlador bibliotecaControlador;
    @Autowired
    private InstitucionControlador institucionControlador;
    @Autowired
    private EstadoControlador estadoControlador;
    @Autowired
    private EmailControlador emailControlador;
    @GetMapping({"/","/peticion/nueva"})
    public ModelAndView nuevaPeticion(){
        ArrayList<InstitucionModelo> institucion = institucionServicio.getInstituciones();
        ArrayList<BibliotecaModelo> bibliotecas = bibliotecaServicio.getBibliotecas();
        ArrayList<Tipo_itemModelo> tipo_item = tipoItemServicio.getTiposItem();
        GestorModelo nivel = new GestorModelo();
        return new ModelAndView("nuevoFormulario")
                .addObject("peticion",new Peticion())
                .addObject("prestatario", new Prestatario())
                .addObject("institucion",institucion)
                .addObject("bibliotecas",bibliotecas)
                .addObject("tipo_item" ,tipo_item)
                .addObject("nivel",nivel)
                .addObject("miObjeto");
    }
    @PostMapping({"/","/peticion/nueva"})
    public ModelAndView nuevaPeticion(Peticion peticion, Prestatario prestatario){
        Peticion pet = peticionControlador.savePeticion(peticion);

        Prestatario data = prestatarioServicio.getByRut(prestatario.getRut_prestatario());
        if(data != null){
            prestatarioServicio.updatePrestatario(prestatario.getRut_prestatario(),prestatario);

        }else{
            prestatarioServicio.savePrestatario(prestatario);
        }
        DetalleEmailModelo email = new DetalleEmailModelo();
        email.setRecipient(prestatario.getEmail());
        email.setSubject("PETICIÓN CREADA");
        email.setMsgBody("Estimado Usuario/a \n" +
                "Su peticion ha sido correctamente creada \n" +
                "su id de peticion es: "+pet.getId_peticion() +" titulo: "+pet.getLibro());
        emailControlador.enviarEmail(email);
        ArrayList<GestorModelo> revisorbibPrestataria = gestorControlador.getRevisorByBib(pet.getId_biblioteca_prestataria());
        for (GestorModelo revisor : revisorbibPrestataria){
            DetalleEmailModelo emailPrestataria = new DetalleEmailModelo();
            emailPrestataria.setRecipient(revisor.getEmail());
            emailPrestataria.setSubject("NUEVA PETICIÓN "+pet.getId_peticion());
            emailPrestataria.setMsgBody("Se ha iniciado una nueva petición ID: "+pet.getId_peticion());
            emailControlador.enviarEmail(emailPrestataria);

        }
        return new ModelAndView("redirect:/peticion/nueva");
    }
    @GetMapping(path = "peticion/{id}")
    public ModelAndView editarPeticion(@PathVariable("id") int id, HttpSession session){
        GestorModelo data = gestorControlador.getDataSession(session);
        var vista = new ModelAndView("EditarPeticion");
        if(data!=null){
            Optional<Peticion> pet = peticionControlador.getPeticionById(id);
            if(data.getId_institucion() == pet.get().getId_institucion_prestadora() || data.getId_institucion() == pet.get().getId_institucion_prestataria()){
                ArrayList<MensajesModelo> mensajes = mensajesControlador.getMensajesById(pet.get().getId_peticion());
                Terminos_envioModelo terms0 = terminosEnvioServicio.getByIdPet0(pet.get().getId_peticion());
                Terminos_envioModelo terms1 = terminosEnvioServicio.getByIdPet1(pet.get().getId_peticion());
                ArrayList<Tipo_envioModelo> tipoEnvio = tipoEnvioControlador.getTipos();
                Tipo_envioModelo TipoEnv0 = new Tipo_envioModelo();
                Tipo_envioModelo TipoEnv1 = new Tipo_envioModelo();
                Prestatario prestatario = prestatarioControlador.getPrestatarioByRut(pet.get().getRut_prestatario());
                if(terms0 != null){
                    TipoEnv0 = tipoEnvioServicio.getByIdTerm(terms0.getTipo_envio());
                        vista.addObject("terminosEnvio",terms0);
                        vista.addObject("tipoEnvioP",TipoEnv0);
                }
                if(terms1 != null){
                    TipoEnv1 = tipoEnvioServicio.getByIdTerm(terms1.getTipo_envio());
                    vista.addObject("tipoEnvioDevolucion",TipoEnv1);
                        vista.addObject("terminosDevolucion",terms1);
                }
                        vista.addObject("peticion",pet)
                        .addObject("terminos_envio",new Terminos_envioModelo())
                        .addObject("tipo_envio",new Tipo_envioModelo())
                        .addObject("mensajes",mensajes)
                        .addObject("mensaje", new MensajesModelo())
                        .addObject("prestatario",prestatario)
                        .addObject("gestor",data)
                        .addObject("tipoEnvio", tipoEnvio);
                return vista;

            }else{
                return new ModelAndView("redirect:/peticiones");
            }
        }else{
            return new ModelAndView("redirect:/login");
        }
    }
    @PostMapping(path = "peticion/{id}")
    public ModelAndView updateEstadoPeticion(@PathVariable("id") int id, Terminos_envioModelo terminos_envio){
        terminos_envio.setId_peticion(id);
        terminosEnvioServicio.saveTerminosEnvio(terminos_envio);
        Tipo_envioModelo nombreEnvio = tipoEnvioControlador.getById(terminos_envio.getTipo_envio());
        String TerminosMensaje = "";
        if(terminos_envio.getEnvio() == 0){
            TerminosMensaje = "Terminos: "+terminos_envio.getTerminos()+" Tipo envio: " + nombreEnvio.getTipo() + " Descripcion tipo de envio: " + terminos_envio.getDescripcion_envio() + " Fecha Vencimiento: " + terminos_envio.getFecha_vencimiento();
        }else{
            TerminosMensaje = "Terminos: "+terminos_envio.getTerminos()+" Tipo envio: " + nombreEnvio.getTipo() + " Descripcion tipo de envio: " + terminos_envio.getDescripcion_envio();
        }
        MensajesModelo terminosM = new MensajesModelo();
        terminosM.setFecha_mensaje(new Date());
        terminosM.setId_peticion(id);
        terminosM.setMensaje(TerminosMensaje);
        terminosM.setRut_gestor("000000001");
        mensajesControlador.saveMensaje(terminosM);
        peticionServicio.updateTerminosPeticion(id);// NO OLVIDAR ACTUALIZAR EL ESTADOOO
        return new ModelAndView("redirect:/peticiones");
    }
    @GetMapping(path = "peticiones")
    public ModelAndView peticiones(HttpSession session){
        GestorModelo data = gestorControlador.getDataSession(session);
        if(data!=null){
            ArrayList<Peticion> PetPrestatarias = peticionControlador.getPeticionByBibliotecasPrestataria(data.getId_biblioteca());
            ArrayList<Peticion> PetPrestadoras = peticionControlador.getPeticionByBibliotecasPrestadora(data.getId_biblioteca());
            ArrayList<EstadoModelo> Estados = estadoControlador.getEstados();
            return new ModelAndView("Peticiones")
                    .addObject("peticionesEntrantes",PetPrestadoras)
                    .addObject("peticionesSalientes",PetPrestatarias)
                    .addObject("estados",Estados);
        }else{
            return new ModelAndView("redirect:/login");
        }

    }
    @GetMapping(path = "login")
    public ModelAndView login(){
        return new ModelAndView("login").addObject("gestor",new GestorModelo());
    }
    @PostMapping(path = "login")
    public ModelAndView login(GestorModelo gestor, HttpSession session){
        GestorModelo response = gestorServicio.login(gestor.getRut_gestor(),gestor.getPassword());
        if (response!=null){
            GestorModelo g = gestorServicio.getData(gestor.getRut_gestor());
            session.setAttribute("gestor",g);
            return new ModelAndView("redirect:/peticiones");
        }else{
            return new ModelAndView("redirect:/login");
        }
    }
    @GetMapping(path = "logout")
    public ModelAndView logout(HttpSession session){
        session.removeAttribute("gestor");
        return new ModelAndView("redirect:/login");
    }
    @GetMapping(path = "/GestionarGestores")
    public ModelAndView GestionarGestores(HttpSession session){
        GestorModelo data = gestorControlador.getDataSession(session);
        ArrayList<InstitucionModelo> institucion = institucionServicio.getInstituciones();
        ArrayList<Nivel_GestorModelo> niveles = nivelGestorControlador.getAll();

        if(data!=null && data.getId_nivel() == 1){
            return new ModelAndView("GestionarGestores")
                    .addObject("nuevoGestor",new GestorModelo())
                    .addObject("institucion",institucion)
                    .addObject("gestorExistente",data)
                    .addObject("niveles",niveles);

        }else{
            return new ModelAndView("redirect:/peticiones");
        }
    }
    @PostMapping(path = "/GestionarGestores")
    public ModelAndView AgregarGestores(GestorModelo gestorModelo, HttpSession session){
        gestorControlador.addGestor(gestorModelo,session);
        return new ModelAndView("redirect:/peticiones");
    }
    @GetMapping(path = "/GestionarRevisores")
    public ModelAndView GestionarRevisores(HttpSession session){
        GestorModelo data = gestorControlador.getDataSession(session);
        if(data!=null && data.getId_nivel() <= 2){
            ArrayList<GestorModelo> gestores = gestorControlador.getGestorByInst(data.getId_institucion(),data.getRut_gestor());
            ArrayList<BibliotecaModelo> bibliotecas = bibliotecaControlador.getBibliotecasByInstitucion(data.getId_institucion());
            return new ModelAndView("GestionarRevisores")
                    .addObject("nuevoGestor",new GestorModelo())
                    .addObject("gestorExistente",data)
                    .addObject("gestores",gestores)
                    .addObject("bibliotecas",bibliotecas);

        }else{
            return new ModelAndView("redirect:/peticiones");
        }
    }
    @PostMapping(path = "/GestionarRevisores")
    public ModelAndView AgregarRevisores(GestorModelo gestor,HttpSession session){
        GestorModelo verificar = gestorControlador.getGestorByrut(gestor.getRut_gestor());
        if (verificar == null){
            gestorControlador.addGestor(gestor,session);
        }
        return new ModelAndView("redirect:/peticiones");
    }
    @GetMapping(path = "/GestionarInstituciones")
    public ModelAndView GestionarInstituciones(HttpSession session){
        GestorModelo data = gestorControlador.getDataSession(session);
        if(data !=null && data.getId_nivel() == 1){
            ArrayList<InstitucionModelo> institucion = institucionServicio.getInstituciones();
            return new ModelAndView("GestionarInstituciones")
                    .addObject("institucion",institucion)
                    .addObject("biblioteca",new BibliotecaModelo())
                    .addObject("institucionNueva",new InstitucionModelo());
        }else{
            return new ModelAndView("redirect:/peticiones");
        }
    }
    @PostMapping(path = "/GestionarInstituciones")
    public ModelAndView AgregarInstituciones(InstitucionModelo institucion, BibliotecaModelo biblioteca, HttpSession session){
        GestorModelo g = gestorControlador.getDataSession(session);
        if(biblioteca != null){ //TRAER DATOS SSION,
            bibliotecaControlador.addBiblioteca(biblioteca,g.getRut_gestor());
        }
        if(institucion != null){
            institucionControlador.addInstitucion(institucion,g.getRut_gestor());
        }
        return new ModelAndView("redirect:/peticiones");
    }
}
