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
import javax.inject.Named;

/**
 *
 * @author USUARIO
 */
@Named(value = "estadovController")
@RequestScoped
public class estadovController implements Serializable {
     @EJB
    private EstadoFacade estadoFacade;
    private Estado estado;

    public EstadoFacade getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(EstadoFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public estadovController() {
    }
    
     public List<Estado> verEstado() {
        List<Estado> per = estadoFacade.consultarEstado();
        return per;
    }
}
