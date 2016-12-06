package com.orfi.log2;

import com.orfi.entity.Persona;
import com.orfi.Facades.PersonaFacade;
import com.orfi.entity.Rol;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import util.Emailu;

@ManagedBean
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private Integer user;
    private Persona usuario;
    private Emailu email;
    private String contenido="";
    private String icontenido;
    private String econtenido;
    private String asunto="";
    private boolean estado = true;
    private boolean oestado=false;
    private boolean estadoe=false;

    @Inject
    private PersonaFacade perFacade;
    private Rol rolSeleccionado;
 

    
    
    public Login() {
        usuario = null;
    }

    public Emailu getEmail() {
        return email;
    }

    public void setEmail(Emailu email) {
        this.email = email;
    }

    public Login(Emailu email) {
        this.email = email;
    }
    
     @PostConstruct
    public void init() {
       email = new Emailu();

    }

    public boolean isEstadoe() {
        return estadoe;
    }

    public void setEstadoe(boolean estadoe) {
        this.estadoe = estadoe;
    }

    public String getEcontenido() {
        return econtenido;
    }

    public void setEcontenido(String econtenido) {
        this.econtenido = econtenido;
    }
    
   
    
   
   
   

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Persona getUsuario() {
        return usuario;
    }
    
    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }
    public void cambiarEstado() {
        estado = true;
        estadoe = false;
    }

    public boolean isOestado() {
        return oestado;
    }

    public void setOestado(boolean oestado) {
        this.oestado = oestado;
    }

    public String getIcontenido() {
        return icontenido;
    }

    public void setIcontenido(String icontenido) {
        this.icontenido = icontenido;
    }
    
    
    
    

    //validate login
    public String validateUsernamePassword() {
        String url = "";
        //TAREA: VERIFICAR como instalarle un filtro para que no se totteeee esto cuando no retorne datos

//        //arma el mapa con los valores que se van a incluir como filtos en la consulta ej Carlos y Ramirez
//        Map<String, Object> filtro = new HashMap<>();
//        //SE enlistan el campo y el valor que se quieren a?adir al filtro. Si se desean mas coopie y pegue la linea
//        filtro.put("nombres", "Nelson");
//
//        //a?ade los resultados de la consulta en una lista para que pasos posteriores solo se disponga de estos datos filtrados.
//        List<Persona> personas = perFacade.fitro(filtro);
        //para usar La entidad Facade la cual hace toda la consulta sin aramar mas codigos
        Persona per = perFacade.validate(user, pwd);
        // si retorno un objeto o no
        if (per != null) {
            usuario = per;
            rolSeleccionado = usuario.getRolList().get(0);
            int rolCompare = rolSeleccionado.getIdROL();
            if (rolCompare == 101010) {
                //Ni ideaa porque cargo eso asi.
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", per);
                //retorna un valor, esto es del login original
                url = "protegido/admin/inicio?faces-redirect=true";
            } else if (rolCompare == 101011) {
//Ni ideaa porque cargo eso asi.
                usuario = per;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", per);
                //retorna un valor, esto es del login original
                rolSeleccionado = usuario.getRolList().get(0);
                url = "protegido/client/index?faces-redirect=true";
            } else if (rolCompare == 101012) {
//Ni ideaa porque cargo eso asi.
                usuario = per;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", per);
                //retorna un valor, esto es del login original
                rolSeleccionado = usuario.getRolList().get(0);
                url = "protegido/employer/index?faces-redirect=true";
            } else if (rolCompare == 101013) {
//Ni ideaa porque cargo eso asi.
                usuario = per;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", per);
                //retorna un valor, esto es del login original
                rolSeleccionado = usuario.getRolList().get(0);
                url = "protegido/root/index?faces-redirect=true";
            } else {
                usuario = per;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", per);
                //retorna un valor, esto es del login original
                rolSeleccionado = usuario.getRolList().get(0);
                url = "protegido/client/index?faces-redirect=true";
            }

        } else {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correo o Contraseña incorrectos. Por favor verifique"));
            estado=false;
            url = "login";
            
        }
        return url;
    }

    //Para cerrar la sesion efectivamente necesita eliminar todo dato cargado en las variables
    public String logout() {
        String url="/faces/login.xhtml?faces-redirect=true";
        user = 0;
        pwd = "";
        rolSeleccionado = null;
        msg = "";
        usuario = null;
        
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return url;
    }
      public void editar(){
        try {
           
           perFacade.edit(usuario);
          email.setEmailRemitente("orfiplus@gmail.com");
         email.setPassRemitente("Cl4v3123");
         email.setEmailDestinatario(usuario.getCorreoe());
         email.setEmailAsunto(asunto="Actualizacion de datos");
         email.setContenido(contenido="se le informa que usted acaba de actualizar los datos en nuestro"
        + " sistema de información OrfiPlus"
                 + " Nombres : "+usuario.getNombres()+ ""
                 + " Apellidos : "+usuario.getApellidos()+""
                 + " correo :"+usuario.getCorreoe()+""
                 + " telefono : "+usuario.getTelefonos()+"");
 
         email.setRemitente("orfiplus@gmail.com");
         email.setDestinatario(usuario.getCorreoe());
          if(email.enviar(asunto, contenido)){
            
          estado = true;
            
        
        } else{
           
           estado = false;
        }
           
           FacesContext.getCurrentInstance().addMessage(null, new
         FacesMessage(FacesMessage.SEVERITY_INFO,
          "Actualizacion", "Se ha Actualizado correctamente"));
           oestado = true;
        } catch (Exception e) {
            
        }
    }
      public void ccambiarEstado() {
        oestado = false;
    }
      
      public String enviarMensaje(){
         email.setEmailRemitente("orfiplus@gmail.com");
         email.setPassRemitente("Cl4v3123");
         email.setEmailDestinatario("aminorfiplus@gmail.com");
         email.setAsunto(asunto="Mensaje de : "+usuario.getNombres()+"");
         email.setContenido(icontenido = econtenido+" -----------------------------"
                 + " : este mensaje fue enviado por el usuario :    "
                 + ""+usuario.getNombres()+" "+usuario.getApellidos()+" con el correo registrado  : "+usuario.getCorreoe()+"");
         email.setRemitente("orfiplus@gmail.com");
         email.setDestinatario("aminorfiplus@gmail.com");
         
         
        if(email.enviar(asunto, icontenido)){
            
          estadoe = true;
            
        
        } else{
           
           estadoe = false;
        }
        return "";
    }
}