/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.JoyaFacade;
import com.orfi.entity.Joya;
import java.io.Serializable;
import java.util.List;
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
@Named(value = "ProductosController")
@RequestScoped
public class ProductosController implements Serializable {

    @EJB
    private JoyaFacade joyaFacade;
    private Joya joya;

    private boolean estado;

    @PostConstruct
    public void init() {
        joya = new Joya();

    }

    public ProductosController() {
    }

    public JoyaFacade getJoyaFacade() {
        return joyaFacade;
    }

    public void setJoyaFacade(JoyaFacade joyaFacade) {
        this.joyaFacade = joyaFacade;
    }

    public Joya getJoya() {
        return joya;
    }

    public void setJoya(Joya joya) {
        this.joya = joya;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Joya> verProductos() {
        List<Joya> per = joyaFacade.consultarJoya();
        return per;
    }

    public void registrarJoya() {
        try {

            joyaFacade.create(joya);
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

    public List<Joya> getAll() {
        List<Joya> li = joyaFacade.findAll();
        return li;
    }

}
