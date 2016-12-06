/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.entity.Persona;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import util.Email;
import util.Emailu;

/**
 *
 * @author USUARIO
 */

@Named(value = "ControllerEmailDeUno")
@RequestScoped
public class ControllerEmailDeUno {
        private Emailu email;
       
    
    
   
    
   
    private Persona user;
    private String asunto;
    private String contenido;
    private boolean estado;
    
    public ControllerEmailDeUno() {
         email = new Emailu();
    }
   
    public Emailu getEmailu() {
        return email;
    }

    public void setEmailu(Emailu emailu) {
        this.email = emailu;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
            
          estado = true;
            
        
        } else{
           
           estado = false;
        }
        return "";
    }
   

    public Persona getUser() {
        return user;
    }

    public void setUser(Persona user) {
        this.user = user;
    }
}
