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
    private com.USM.PIB.Servicios.institucionServicio institucionServicio;
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

    @GetMapping(path = "peticion/nueva")
    public ModelAndView nuevaPeticion(){
        ArrayList<institucionModelo> institucion = institucionServicio.getInstituciones();
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
        prestatarioControlador.savePrestatario(prestatario);
        return new ModelAndView("redirect:/peticiones");
    }
    @GetMapping(path = "peticion/{id}")
    public ModelAndView editarPeticion(@PathVariable("id") int id, HttpSession session){
        Optional<Peticion> pet = peticionControlador.getPeticionById(id);
        ArrayList<MensajesModelo> mensajes = mensajesControlador.getMensajesById(pet.get().getId_peticion());
        Terminos_envioModelo terms = terminosEnvioServicio.getByIdPet(pet.get().getId_terminos_envio());
        Tipo_envioModelo TipoEnv = new Tipo_envioModelo();
        GestorModelo g = gestorControlador.getDataSession(session);
        if(terms != null){
            TipoEnv = tipoEnvioServicio.getByIdTerm(terms.getTipo_envio());
        }
        return new ModelAndView("EditarPeticion")
                .addObject("peticion",pet)
                .addObject("terminos_envio",new Terminos_envioModelo())
                .addObject("tipo_envio",new Tipo_envioModelo())
                .addObject("mensajes",mensajes)
                .addObject("mensaje", new MensajesModelo())
                .addObject("terminosRes",terms)
                .addObject("tipoRes",TipoEnv)
                .addObject("rut",g.getRut_gestor());
    }
    @PostMapping(path = "peticion/{id}")
    public ModelAndView updateEstadoPeticion(@PathVariable("id") int id,
         Tipo_envioModelo tipo_envio,
         Terminos_envioModelo terminos_envio){
        Tipo_envioModelo tipoE = tipoEnvioControlador.saveTipoEnvio(tipo_envio);
        terminos_envio.setTipo_envio(tipoE.getTipo_envio());
        Terminos_envioModelo terminosE = terminosEnvioServicio.saveTerminosEnvio(terminos_envio);
        peticionServicio.updateTerminosPeticion(id,terminosE.getId_envio());
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
}
