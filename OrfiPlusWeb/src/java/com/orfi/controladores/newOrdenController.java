/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.OrdenFacade;
import com.orfi.entity.Orden;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author USUARIO
 */
@Named(value = "newOrdenController")
@RequestScoped
public class newOrdenController implements Serializable {
     @EJB
    private OrdenFacade ordenFacade;
    private Orden orden;
     private boolean estado;

    public OrdenFacade getOrdenFacade() {
        return ordenFacade;
    }

    public void setOrdenFacade(OrdenFacade ordenFacade) {
        this.ordenFacade = ordenFacade;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public newOrdenController() {
    }

 @PostConstruct
    public void init() {
        orden = new Orden();

    }
    
    
      public void CrearOrden() {
        try {

            ordenFacade.create(orden);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Creaciòn", "Se ha registrado corectamente la joya"));
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
     
    
}
