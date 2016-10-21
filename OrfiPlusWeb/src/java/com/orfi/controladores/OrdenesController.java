/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.OrdenFacade;
import com.orfi.entity.Orden;
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
@Named(value = "OrdenesController")
@RequestScoped
public class OrdenesController {
    @EJB
    private OrdenFacade ordenfacade;
     private Orden orden;

    public OrdenesController() {
    }

    public OrdenesController(OrdenFacade ordenfacade, Orden orden) {
        this.ordenfacade = ordenfacade;
        this.orden = orden;
    }

     
    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public OrdenFacade getOrdenfacade() {
        return ordenfacade;
    }

    public void setOrdenfacade(OrdenFacade ordenfacade) {
        this.ordenfacade = ordenfacade;
    }
     
    
    
     public List<Orden> getAll() {
        List<Orden> li = ordenfacade.findAll();
        return li;
    }
     
          public Orden getOrden(java.lang.Integer id) {
       return ordenfacade.find(id);
   }
     @FacesConverter(forClass = Orden.class)
   public static class UsuarioConverter implements Converter {

       @Override
       public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
           if (value == null || value.length() == 0) {
               return null;
           }
           OrdenesController controlador = (OrdenesController) facesContext.getApplication().getELResolver().
                   getValue(facesContext.getELContext(), null, "OrdenesController");
           return controlador.getOrden(getKey(value));
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
           if (object instanceof Orden) {
             Orden  o = (Orden) object;
               return getStringKey(o.getIdORDEN());
           } else {
               throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Orden.class.getName());
           }
       }

            

   }
     
   
}
