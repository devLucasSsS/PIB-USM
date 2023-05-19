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

    @GetMapping(path = "peticion/nueva")
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
    @PostMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(Peticion peticion, Prestatario prestatario){
        peticionControlador.savePeticion(peticion);
        Prestatario data = prestatarioServicio.getByRut(prestatario.getRut_prestatario());
        if(data != null){
            prestatarioServicio.updatePrestatario(prestatario.getRut_prestatario(),prestatario);

        }else{
            prestatarioServicio.savePrestatario(prestatario);
        }
        return new ModelAndView("redirect:/peticiones");
    }
    @GetMapping(path = "peticion/{id}")
    public ModelAndView editarPeticion(@PathVariable("id") int id, HttpSession session){
        GestorModelo data = gestorControlador.getDataSession(session);
        var vista = new ModelAndView("EditarPeticion");
        if(data!=null){
            Optional<Peticion> pet = peticionControlador.getPeticionById(id);
            ArrayList<MensajesModelo> mensajes = mensajesControlador.getMensajesById(pet.get().getId_peticion());
            Terminos_envioModelo terms0 = terminosEnvioServicio.getByIdPet0(pet.get().getId_peticion());
            Terminos_envioModelo terms1 = terminosEnvioServicio.getByIdPet1(pet.get().getId_peticion());
            Tipo_envioModelo TipoEnv0 = new Tipo_envioModelo();
            Tipo_envioModelo TipoEnv1 = new Tipo_envioModelo();
            Prestatario prestatario = prestatarioControlador.getPrestatarioByRut(pet.get().getRut_prestatario());
            if(terms0 != null){
                TipoEnv0 = tipoEnvioServicio.getByIdTerm(terms0.getTipo_envio());
                    vista.addObject("terminosEnvio",terms0);
                    vista.addObject("tipoEnvio",TipoEnv0);
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
                    .addObject("gestor",data);
            return vista;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }
    @PostMapping(path = "peticion/{id}")
    public ModelAndView updateEstadoPeticion(@PathVariable("id") int id,
         Tipo_envioModelo tipo_envio,
         Terminos_envioModelo terminos_envio){
        Tipo_envioModelo tipoE = tipoEnvioControlador.saveTipoEnvio(tipo_envio);
        terminos_envio.setTipo_envio(tipoE.getTipo_envio());
        terminos_envio.setId_peticion(id);
        terminosEnvioServicio.saveTerminosEnvio(terminos_envio);
        peticionServicio.updateTerminosPeticion(id);// NO OLVIDAR ACTUALIZAR EL ESTADOOO
        return new ModelAndView("redirect:/peticiones");
//        return peticionServicio.savePeticion(peticion);

    }
    @GetMapping(path = "peticiones")
    public ModelAndView peticiones(HttpSession session){
        GestorModelo data = gestorControlador.getDataSession(session);
        if(data!=null){
            ArrayList<Peticion> PetPrestatarias = peticionControlador.getPeticionByBibliotecasPrestataria(data.getId_biblioteca());
            ArrayList<Peticion> PetPrestadoras = peticionControlador.getPeticionByBibliotecasPrestadora(data.getId_biblioteca());
            return new ModelAndView("Peticiones").addObject("peticionesEntrantes",PetPrestadoras).addObject("peticionesSalientes",PetPrestatarias);
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
    @GetMapping(path = "/GestionarUsuarios")
    public ModelAndView GestionarUsuarios(){
        return new ModelAndView("GestionarUsuarios");
    }
    @GetMapping(path = "/GestionarBibliotecas")
    public ModelAndView GestionarBibliotecas(){
        return new ModelAndView("GestionarBibliotecas");
    }
    @GetMapping(path = "/GestionarInstituciones")
    public ModelAndView GestionarInstituciones(){
        return new ModelAndView("GestionarInstituciones");
}   }
