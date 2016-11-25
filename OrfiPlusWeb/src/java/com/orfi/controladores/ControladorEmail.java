/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.PersonaFacade;
import com.orfi.entity.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import util.Email;

/**
 *
 * @author USUARIO
 */
@Named(value = "controladorEmail")
@RequestScoped
public class ControladorEmail {
    @EJB
    private PersonaFacade personaFacade;
    private Email email;
    private String user;
    private String asunto;
    private String contenido;
    
    public ControladorEmail() {
         email = new Email();
    }
   
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
     public String enviarMensaje(){
         List<String>correos=new ArrayList<>();
        int i=0;
         for (Persona persona : personaFacade.findAll()) {
             correos.add(i,persona.getCorreoe());
             i++;
         }
        
         email.setEmailRemitente("orfiplus@gmail.com");
         email.setPassRemitente("Cl4v3123");
         email.setAsunto(asunto);
         email.setContenido(contenido);
         email.setRemitente("orfiplus@gmail.com");
                
         
       
         
        if( email.envioCorreosMasivos(correos, asunto, contenido)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Envio Correo","Se ha enviado exitosamente el mensaje"));
          
        } else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Envio Correo","No se ha enviado exitosamente el mensaje"));
           
        }
         return "";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
   

    
    
}
