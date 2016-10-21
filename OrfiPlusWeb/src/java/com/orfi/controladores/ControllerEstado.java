/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.EstadoFacade;
import com.orfi.entity.Estado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import util.JsfUtil;

/**
 *
 * @author USUARIO
 */
@Named(value = "ControllerEstado")
@RequestScoped
public class ControllerEstado implements Serializable {
     @EJB
    private EstadoFacade estadoFacade;
      private Estado estados;
       Integer selectedItemIndex;
        private boolean estado;

    public ControllerEstado() {
    }

    public ControllerEstado(EstadoFacade estadoFacade, Estado estados) {
        this.estadoFacade = estadoFacade;
        this.estados = estados;
    }

    public EstadoFacade getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(EstadoFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public Estado getEstados() {
        return estados;
    }

    public void setEstados(Estado estados) {
        this.estados = estados;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
        
    
  
    
  
    
         public List<Estado> getAll() {
        List<Estado> li = estadoFacade.findAll();
        return li;
    } 
         
          public Estado getEstado(java.lang.Integer id) {
       return estadoFacade.find(id);
   }
    
    
 @FacesConverter(forClass = Estado.class)
   public static class UsuarioConverter implements Converter {

       @Override
       public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
           if (value == null || value.length() == 0) {
               return null;
           }
           ControllerEstado controlador = (ControllerEstado) facesContext.getApplication().getELResolver().
                   getValue(facesContext.getELContext(), null, "ControllerEstado");
           return controlador.getEstado(getKey(value));
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
           if (object instanceof Estado) {
             Estado  o = (Estado) object;
               return getStringKey(o.getIdESTADO());
           } else {
               throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Estado.class.getName());
           }
       }

   }
    
}
