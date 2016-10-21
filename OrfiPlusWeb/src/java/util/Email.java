/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Ismael
 */
public class Email {
    
    public final static String HOST_EMAIL_GMAIL = "smtp.gmail.com";
    
    private String emailRemitente;
    private String passRemitente;
    private String emailDestinatario;
    private String emailAsunto;
    private String emailContenido;
   
    
    private Session session;
    private MimeMessage mimeMessage;
    
       private Integer idEmail;
   
    private String remitente;
 
    private String destinatario;
  
    private String asunto;
   
    private String contenido;
    
   
  
 

 

    public Integer getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public void setContenido(String asunto) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }
    

    public Email() {
    }

    public Email(String emailRemitente, String passRemitente, String emailDestinatario, String emailAsunto, String emailContenido) {
        this.emailRemitente = emailRemitente;
        this.passRemitente = passRemitente;
        this.emailDestinatario = emailDestinatario;
        this.emailAsunto= emailAsunto;
        this.emailContenido= emailContenido;
    }
    
    private void init(){
        try {
            Properties propiedades = new Properties();
            
            propiedades.setProperty("mail.smtp.host", HOST_EMAIL_GMAIL);
            propiedades.setProperty("mail.smtp.starttls.enable", "true");
            propiedades.setProperty("mail.smtp.port", "25");//587
            propiedades.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            propiedades.setProperty("mail.smtp.user", this.emailRemitente);
            propiedades.setProperty("mail.smtp.auth", "true");
            
            session = Session.getDefaultInstance(propiedades);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(emailRemitente));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean enviar(String asunto, String contenido){
        try {
            init();
            mimeMessage.setSubject(asunto);
            mimeMessage.setText(contenido);
           
            Transport transport = session.getTransport("smtp");
            transport.connect(emailRemitente, passRemitente);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
            return true;
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
    
    
    public String getEmailRemitente() {
        return emailRemitente;
    }

    public void setEmailRemitente(String emailRemitente) {
        this.emailRemitente = emailRemitente;
    }

    public String getPassRemitente() {
        return passRemitente;
    }

    public void setPassRemitente(String passRemitente) {
        this.passRemitente = passRemitente;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public void setEmailAsunto(String emailAsunto) {
       this.emailAsunto = emailAsunto;
    }
      public String getEmailAsunto() {
        return emailAsunto;
    }

    
      public String getEmailContenido() {
        return emailContenido;
    }

    public void setEmailContenido(String emailContenido) {
         this.emailContenido = emailContenido;
    }
    
    
    
    
    
    
    
}
