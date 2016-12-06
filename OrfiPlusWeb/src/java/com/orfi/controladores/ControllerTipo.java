/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.TipoFacade;
import com.orfi.entity.Tipo;
import java.io.Serializable;
import java.util.List;
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
@Named(value = "ControllerTipo")
@RequestScoped
public class ControllerTipo implements Serializable {
     @EJB
    private TipoFacade tipoFacade;
      private Tipo tipo;
      
        private boolean estado;

    public ControllerTipo() {
    }

    public ControllerTipo(TipoFacade tipoFacade, Tipo tipo) {
        this.tipoFacade = tipoFacade;
        this.tipo = tipo;
    }

    public TipoFacade getTipoFacade() {
        return tipoFacade;
    }

    public void setTipoFacade(TipoFacade tipoFacade) {
        this.tipoFacade = tipoFacade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
        
     public List<Tipo> getAll() {
        List<Tipo> li = tipoFacade.findAll();
        return li;
    }
          public Tipo getTipo(java.lang.Integer id) {
       return tipoFacade.find(id);
   }
          
           public void editar(){
        try {
           tipoFacade.edit(tipo);
        } catch (Exception e) {
            
        }
    }
          
           public void eliminar(){
        try {
           tipoFacade.remove(tipo);
        } catch (Exception e) {
            
        }
    }
          
          
          
       @FacesConverter(forClass = Tipo.class)
       
   public static class DisenioConverter implements Converter {

       @Override
       public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
           if (value == null || value.length() == 0) {
               return null;
           }
           ControllerTipo controlador = (ControllerTipo) facesContext.getApplication().getELResolver().
                   getValue(facesContext.getELContext(), null, "ControllerTipo");
           return controlador.getTipo(getKey(value));
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
           if (object instanceof Tipo) {
             Tipo  o = (Tipo) object;
               return getStringKey(o.getIdTIPO());
           } else {
               throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Tipo.class.getName());
           }
       }           

        

   }
    
}
