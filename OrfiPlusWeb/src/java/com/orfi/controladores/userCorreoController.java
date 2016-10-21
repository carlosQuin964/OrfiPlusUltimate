/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.PersonaFacade;
import com.orfi.entity.Persona;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import util.Email;
import util.JsfUtil;

/**
 *
 * @author USUARIO
 */
@Named(value = "userCorreoController")
@SessionScoped
public class userCorreoController implements Serializable {
    public userCorreoController() {
    }
    Integer selectedItemIndex;
    
    private Persona user;
    private Email email;
    private String asunto;
    private String contenido;
    @EJB
    private PersonaFacade facadeUsuario;
    private Integer estado=0;
    @PostConstruct
    public void init(){
        user = new Persona();
        email = new Email();
    }
     public void estado(){
        this.estado=0;
    } 
    
    public void borrarEstado(){
        estado=0;
    }
    
    public void registrar(){
        try {
            facadeUsuario.create(user);
        } catch (Exception e) {
            
        }
    }
     public List<Persona> getAll() {
        List<Persona> li = facadeUsuario.findAll();
        return li;
    }
     public void editar(){
        try {
           facadeUsuario.edit(user);
        } catch (Exception e) {
            
        }
    }
      public void eliminar(){
        try {
           facadeUsuario.remove(user);
        } catch (Exception e) {
            
        }
    }
    public Persona getUser() {
        return user;
    }

    public void setUser(Persona user) {
        this.user = user;
    }

    public PersonaFacade getFacadeUsuario() {
        return facadeUsuario;
    }

    public void setFacadeUsuario(PersonaFacade facadeUsuario) {
        this.facadeUsuario = facadeUsuario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
     public Persona getSelected() {
       if (user == null) {
           user = new Persona();
           selectedItemIndex =-1;
       }
       return user;
   }
   public SelectItem[] getItemsAvailableSelectOne() {
       return JsfUtil.getSelectItems(facadeUsuario.findAll(),false);
   }
   
    public Persona getUsuario(java.lang.Integer id) {
       return facadeUsuario.find(id);
   }
   
    @FacesConverter(forClass = Persona.class)
   public static class UsuarioConverter implements Converter {

       @Override
       public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
           if (value == null || value.length() == 0) {
               return null;
           }
           userCorreoController controlador = (userCorreoController) facesContext.getApplication().getELResolver().
                   getValue(facesContext.getELContext(), null, "userCorreoController");
           return controlador.getUsuario(getKey(value));
       }

       java.lang.Integer getKey(String value) {
           java.lang.Integer key;
           key = Integer.valueOf(value);
           return key;
       }

       String getStringKey(java.lang.Integer value) {
           StringBuilder sb = new StringBuilder();
           sb.append(value);
           return sb.toString();
       }

       @Override
       public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
           if (object == null) {
               return null;
           }
           if (object instanceof Persona) {
             Persona  o = (Persona) object;
               return getStringKey(o.getIdPERSONAS());
           } else {
               throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Persona.class.getName());
           }
       }

   }
     
}
