/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.DisenioFacade;
import com.orfi.Facades.JoyaFacade;
import com.orfi.Facades.MaterialFacade;
import com.orfi.Facades.TipoFacade;
import com.orfi.entity.Disenio;
import com.orfi.entity.Joya;
import com.orfi.entity.Material;
import com.orfi.entity.Tipo;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Sergio
 */
@Named(value = "qcalcularValorJoya")
@ViewScoped
public class CalcularValorJoya implements Serializable{

    private int valorJoya,valorMaterial,valorDisenio,valorTipo;
    private Joya joya;
    private Tipo tipo;
    private Material material;
    private Disenio disenio;
    
    @EJB
    private JoyaFacade joyaFacade;
    @EJB
    private TipoFacade tipoFacade;
    @EJB
    private MaterialFacade materialFacade;
    @EJB
    private DisenioFacade disenioFacade;
    
    /**
     * Creates a new instance of CalcularValorJoya
     */
    public CalcularValorJoya() {
    }

    public int getValorJoya() {
        return valorJoya;
    }

    public void setValorJoya(int valorJoya) {
        this.valorJoya = valorJoya;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Disenio getDisenio() {
        return disenio;
    }

    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }

    public Joya getJoya() {
        return joya;
    }

    public void setJoya(Joya joya) {
        this.joya = joya;
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

    
    
    public void calcularjoya(){
        valorDisenio = joya.getIdDisenio().getPrecioxdisenio();
        valorTipo = joya.getIdTipo().getPrecioxtipo();
        valorMaterial = joya.getIdMaterial().getPrecioxmaterial();
        valorJoya = valorDisenio+valorMaterial+valorTipo;
    }
    
}
