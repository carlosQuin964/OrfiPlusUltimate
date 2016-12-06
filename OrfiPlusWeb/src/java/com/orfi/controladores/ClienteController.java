/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.PersonaFacade;
import com.orfi.Facades.RolFacade;
import com.orfi.entity.Persona;
import com.orfi.entity.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static sun.security.jgss.GSSUtil.login;
import util.Emailu;

/**
 *
 * @author seanv
 */
@Named(value = "clienteController")
@RequestScoped
public class ClienteController implements Serializable {

    private String confirmarPsw;
    
    @EJB
    private PersonaFacade personaFacade;
    @EJB
    private RolFacade rolFacade;
    private Persona persona;
    private Emailu email;
    private String asunto="Registro OrfiPlus";
    private String contenido = "Bienvenido a la familia orfi usted se registro a nuestro sistema de información OrfiPlus con el correo  y la contraseña";

    /**
     * Creates a new instance of EmpleadoController
     */
    @PostConstruct
    public void init() {
        persona = new Persona();

    }
    
     public ClienteController() {
         email = new Emailu();
    }
    
    
    private boolean estado;

    public ClienteController(Emailu email) {
        this.email = email;
    }

   
 public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Emailu getEmail() {
        return email;
    }

    public void setEmail(Emailu email) {
        this.email = email;
    }
    

    public void registrarCliente() {
        try {
            
            Rol rol = rolFacade.find(101011);
            persona.setRolList(new ArrayList<>());
            persona.getRolList().add(rol);
            persona.setFechaCreacion(new Date());
            personaFacade.create(persona);
          email.setEmailRemitente("orfiplus@gmail.com");
         email.setPassRemitente("Cl4v3123");
         email.setEmailDestinatario(persona.getCorreoe());
         email.setEmailAsunto(asunto);
         email.setContenido(contenido="Bienvenido "+persona.getNombres()+" "+persona.getApellidos()+" a la familia orfi usted se registro a nuestro sistema de información OrfiPlus con el correo :"+
                 persona.getCorreoe()+" y la contraseña  :"+persona.getPassword()+"apartir de haora usted puede ingresar "
                 + "con el usuario"+persona.getIdPERSONAS()+" y su contraseña ");
         email.setRemitente("orfiplus@gmail.com");
         email.setDestinatario(persona.getCorreoe());
          if(email.enviar(asunto, contenido)){
            
          estado = true;
            
        
        } else{
           
           estado = false;
        }
             FacesContext.getCurrentInstance().addMessage(null, new
         FacesMessage(FacesMessage.SEVERITY_INFO,
          "Creaciòn", "Se ha registrado corectamente"));
              estado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Error en envio de datos");
        }
    }
    
    public void registrarEmpleado() {
        try {
            
            Rol rol = rolFacade.find(101012);
            persona.setRolList(new ArrayList<>());
            persona.getRolList().add(rol);
            persona.setFechaCreacion(new Date());
            personaFacade.create(persona);
        
             FacesContext.getCurrentInstance().addMessage(null, new
         FacesMessage(FacesMessage.SEVERITY_INFO,
          "Creaciòn", "Se ha registrado corectamente"));
              estado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Error en envio de datos");
        }
    }
    
    
  
     public void editar(){
        try {
            
           personaFacade.edit(persona);
           
           FacesContext.getCurrentInstance().addMessage(null, new
         FacesMessage(FacesMessage.SEVERITY_INFO,
          "Actualizacion", "Se ha Actualizado correctamente"));
           estado = true;
        } catch (Exception e) {
            
        }
    }
    
    
     public void cambiarEstado() {
        estado = false;
    }
    
    public String cancelar(){
        return "principal";
    }
    
    public List<Persona> verClientesController() {
        List<Persona> per = personaFacade.consultarPersonas();
        return per;
    }
    
      public List<Persona> getAll() {
        List<Persona> per = personaFacade.findAll();
        return per;
    }

    public String getConfirmarPsw() {
        return confirmarPsw;
    }

    public void setConfirmarPsw(String confirmarPsw) {
        this.confirmarPsw = confirmarPsw;
    }

    
    
}
