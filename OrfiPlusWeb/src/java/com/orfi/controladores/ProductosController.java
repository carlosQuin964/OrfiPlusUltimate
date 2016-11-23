/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.DisenioFacade;
import com.orfi.Facades.JoyaFacade;
import com.orfi.Facades.MaterialFacade;
import com.orfi.Facades.OrdenFacade;
import com.orfi.Facades.TipoFacade;
import com.orfi.entity.Joya;
import com.orfi.entity.Orden;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
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

    
    private int valorJoya, valorMaterial, valorDisenio, valorTipo,valorTootal;
    private Joya joya;
    private boolean estado;

    @EJB
    private JoyaFacade joyaFacade;
    @EJB
    private TipoFacade tipoFacade;
     private OrdenFacade OrdenFacade;
    @EJB
    private MaterialFacade materialFacade;
    @EJB
    private DisenioFacade disenioFacade;

    @PostConstruct
    public void init() {
        joya = new Joya();

    }

    public ProductosController() {
    }

    public int getValorJoya() {
        return valorJoya;
    }

    public void setValorJoya(int valorJoya) {
        this.valorJoya = valorJoya;
    }

    public int getValorMaterial() {
        return valorMaterial;
    }

    public void setValorMaterial(int valorMaterial) {
        this.valorMaterial = valorMaterial;
    }

    public int getValorDisenio() {
        return valorDisenio;
    }

    public void setValorDisenio(int valorDisenio) {
        this.valorDisenio = valorDisenio;
    }

    public int getValorTipo() {
        return valorTipo;
    }

    public void setValorTipo(int valorTipo) {
        this.valorTipo = valorTipo;
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
    
    public void clienteregistrarJoya() {
        try {
            
            joya.setValorTotal(valorTootal);
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

    public void calcularjoya() {
        joya.setIdJoya(100003);
        valorDisenio = joya.getIdDisenio().getPrecioxdisenio();
        System.out.println(valorDisenio);
        valorTipo = joya.getIdTipo().getPrecioxtipo();
        valorMaterial = joya.getIdMaterial().getPrecioxmaterial();
        valorJoya = valorDisenio + valorMaterial + valorTipo;
        valorTootal = valorJoya;
       
        
    }

    public void cambiarEstado() {
        estado = false;
    }

    public List<Joya> getAll() {
        List<Joya> li = joyaFacade.findAll();
        return li;
    }


}
