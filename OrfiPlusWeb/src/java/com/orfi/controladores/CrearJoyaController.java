/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.DisenioFacade;
import com.orfi.Facades.JoyaFacade;
import com.orfi.entity.Disenio;
import com.orfi.entity.Joya;
import com.orfi.entity.Orden;
import com.orfi.entity.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author seanv
 */
@Named(value = "crearJoyaController")
@SessionScoped
public class CrearJoyaController implements Serializable {
    
    private Joya joya;
    private Disenio disenio;
    private List<Disenio> disenios;
    
    @EJB
    private JoyaFacade joyaFacade;
    private DisenioFacade facadeDisenio;
    private Orden orden;

    private List<Joya> joyas = joyaFacade.consultarJoya();
    /**
     * Creates a new instance of CrearJoyaController
     */
    
    @PostConstruct
    public void init() {
        joyas = joyaFacade.findAll();

    }

    public Joya getJoya() {
        return joya;
    }

    public void setJoya(Joya joya) {
        this.joya = joya;
    }

    public Disenio getDisenio() {
        return disenio;
    }

    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }

    public List<Disenio> getDisenios() {
        return disenios;
    }

    public void setDisenios(List<Disenio> disenios) {
        this.disenios = disenios;
    }

    public JoyaFacade getJoyaFacade() {
        return joyaFacade;
    }

    public void setJoyaFacade(JoyaFacade joyaFacade) {
        this.joyaFacade = joyaFacade;
    }

    public DisenioFacade getFacadeDisenio() {
        return facadeDisenio;
    }

    public void setFacadeDisenio(DisenioFacade facadeDisenio) {
        this.facadeDisenio = facadeDisenio;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public List<Joya> getJoyas() {
        return joyas;
    }

    public void setJoyas(List<Joya> joyas) {
        this.joyas = joyas;
    }

    
    
    
    public void registrarJoya(){
        try {
            joyaFacade.create(joya);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Error en envio de datos");
        }
    }
    
    public List<Joya> verJoyasSolicitadas() {
        List<Joya> joyaObj = joyaFacade.findAll();
        return joyaObj;
    }
    

    
    
}
