/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.entity.Persona;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import util.Email;

/**
 *
 * @author USUARIO
 */
@Named(value = "controladorEmail")
@RequestScoped
public class ControladorEmail {
    private Email email;
       
    
    
   
    
   
    private Persona user;
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
         email.setEmailRemitente("orfiplus@gmail.com");
         email.setPassRemitente("Cl4v3123");
         email.setEmailDestinatario(user.getCorreoe());
         email.setAsunto(asunto);
         email.setContenido(contenido);
         email.setRemitente("orfiplus@gmail.com");
         email.setDestinatario(user.getCorreoe());        
         
         
         
        if(email.enviar(asunto, contenido)){
            return "inicio";
          
        } else{
            return "inicio";
           
        }
    }
   

    public Persona getUser() {
        return user;
    }

    public void setUser(Persona user) {
        this.user = user;
    }
    
}
