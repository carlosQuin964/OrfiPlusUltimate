/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.MaterialFacade;
import com.orfi.entity.Material;

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
@Named(value = "materialesVController")
@RequestScoped
public class materialesVController implements Serializable {
    @EJB
    private MaterialFacade materialFacate;
    private Material material;
    
      public Material getMaterial() {
        return material;
    }

    public MaterialFacade getMaterialFacate() {
        return materialFacate;
    }

    public void setMaterialFacate(MaterialFacade materialFacate) {
        this.materialFacate = materialFacate;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
     private boolean estado;

 public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
     @PostConstruct
    public void init() {
        material = new Material();

    }
    
     public List<Material> verMaterias() {
        List<Material> per = materialFacate.consultarMaterias();
        return per;
    }
            public void registrarMaterial() {
        try {          
            materialFacate.create(material);
              estado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Error en envio de datos");
        }
    }
            public List<Material> getAll() {
        List<Material> li = materialFacate.findAll();
        return li;
    }
             public void cambiarEstado() {
        estado = false;
    }
         public Material getMaterial(java.lang.Integer id) {
       return materialFacate.find(id);
   }
             
             
                @FacesConverter(forClass = Material.class)
   public static class UsuarioConverter implements Converter {

       @Override
       public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
           if (value == null || value.length() == 0) {
               return null;
           }
           materialesVController controlador = (materialesVController) facesContext.getApplication().getELResolver().
                   getValue(facesContext.getELContext(), null, "materialesVController");
           return controlador.getMaterial(getKey(value));
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
           if (object instanceof Material) {
             Material  o = (Material) object;
               return getStringKey(o.getIdMATERIAL());
           } else {
               throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Material.class.getName());
           }
       }

   }
    
    
}
