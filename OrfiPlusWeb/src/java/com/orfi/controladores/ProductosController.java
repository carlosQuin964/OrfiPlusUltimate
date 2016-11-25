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

    private int valorJoya, valorMaterial, valorDisenio, valorTipo, valorTootal, idtipo, idmaterial, iddisenio;
    private String rutaImagen="000.jpg" ;
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

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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
        valorTipo = joya.getIdTipo().getPrecioxtipo();
        valorMaterial = joya.getIdMaterial().getPrecioxmaterial();
        valorJoya = valorDisenio + valorMaterial + valorTipo;
        valorTootal = valorJoya;

        idtipo = joya.getIdTipo().getIdTIPO();
        idmaterial = joya.getIdMaterial().getIdMATERIAL();
        iddisenio = joya.getIdDisenio().getIdDISENIO();

        switch (idtipo) {
            case 401010:
                rutaImagen = "1";
                switch (idmaterial) {
                    case 201010:
                        rutaImagen += "1";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.jpg";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                    case 201011:
                        rutaImagen += "2";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.jpg";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                    case 201012:
                        rutaImagen += "3";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.jpg";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                }
                break;
            case 401012:
                rutaImagen = "2";
                switch (idmaterial) {
                    case 201010:
                        rutaImagen += "1";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.jpg";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                    case 201011:
                        rutaImagen += "2";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.jpg";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                    case 201012:
                        rutaImagen += "3";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.jpg";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                }
                break;
            case 401013:
                rutaImagen = "3";
                switch (idmaterial) {
                    case 201010:
                        rutaImagen += "1";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.JPG";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                    case 201011:
                        rutaImagen += "2";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.jpg";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                    case 201012:
                        rutaImagen += "3";
                        switch (iddisenio) {
                            case 30101:
                                rutaImagen += "1.jpg";
                                break;
                            case 30102:
                                rutaImagen += "2.jpg";
                                break;
                            case 30104:
                                rutaImagen += "3.jpg";
                                break;
                        }
                        break;
                }
                break;
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
