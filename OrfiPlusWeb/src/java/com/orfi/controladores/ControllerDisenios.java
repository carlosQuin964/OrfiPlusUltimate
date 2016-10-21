/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.DisenioFacade;
import com.orfi.entity.Disenio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author USUARIO
 */
@Named(value = "ControllerDisenios")
@RequestScoped
public class ControllerDisenios implements Serializable {
      @EJB
    private DisenioFacade disenioFacade;
      private Disenio disenio;
      
        private boolean estado;

    public Disenio getDisenio() {
        return disenio;
    }

    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }

 public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
      @PostConstruct
    public void init() {
        disenio = new Disenio();

    }
    
     public List<Disenio> verDisenios() {
        List<Disenio> per = disenioFacade.consultarDiseno();
        return per;
    }
       public void registrarDisenio() {
        try {          
            disenioFacade.create(disenio);
              estado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Error en envio de datos");
        }
    }
             public void cambiarEstado() {
        estado = false;
    }
             
              public List<Disenio> getAll() {
        List<Disenio> li = disenioFacade.findAll();
        return li;
    }
                   public Disenio getDisenio(java.lang.Integer id) {
       return disenioFacade.find(id);
   }
              
              
              
      @FacesConverter(forClass = Disenio.class)
   public static class DisenioConverter implements Converter {

       @Override
       public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
           if (value == null || value.length() == 0) {
               return null;
           }
           ControllerDisenios controlador = (ControllerDisenios) facesContext.getApplication().getELResolver().
                   getValue(facesContext.getELContext(), null, "ControllerDisenios");
           return controlador.getDisenio(getKey(value));
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
           if (object instanceof Disenio) {
             Disenio  o = (Disenio) object;
               return getStringKey(o.getIdDISENIO());
           } else {
               throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Disenio.class.getName());
           }
       }           

   }         
              
              
}
