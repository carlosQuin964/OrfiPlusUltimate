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
import com.orfi.entity.Persona;
import com.orfi.log2.Login;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import util.Emailu;

/**
 *
 * @author USUARIO
 */
@Named(value = "ProductosController")
@RequestScoped
public class ProductosController implements Serializable {

    private int valorJoya,cantidad, valorMaterial, valorDisenio, valorTipo, valorTootal, idtipo, idmaterial, iddisenio;
    private String rutaImagen="000.jpg" ;
    private Joya joya;
    private Orden orden;
    private Integer prueba=0;
    private String nuevo="";
    private boolean estado;
     private boolean estadoe;
     private String asunto="";
    private String contenido = "";
     private Emailu email;

    @EJB
    private JoyaFacade joyaFacade;
   
    @EJB
    private TipoFacade tipoFacade;
    @EJB
    private OrdenFacade OrdenFacade;
    @EJB
    private MaterialFacade materialFacade;
    @EJB
    private DisenioFacade disenioFacade;

    @PostConstruct
    public void init() {
        joya = new Joya();
        orden = new Orden();
         email = new Emailu();

    }
     public void ProductosController() {
        orden = new Orden();

    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getValorTootal() {
        return valorTootal;
    }

    public void setValorTootal(int valorTootal) {
        this.valorTootal = valorTootal;
    }
     

    public ProductosController(Orden orden) {
        this.orden = orden;
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

    public ProductosController(Emailu email) {
        this.email = email;
    }

    public Emailu getEmail() {
        return email;
    }

    public void setEmail(Emailu email) {
        this.email = email;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Joya getJoya() {
        return joya;
    }

    public void setJoya(Joya joya) {
        this.joya = joya;
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

 

    public void calcularjoya() {
        joya.setIdJoya(100003);
        valorDisenio = joya.getIdDisenio().getPrecioxdisenio();
        valorTipo = joya.getIdTipo().getPrecioxtipo();
        valorMaterial = joya.getIdMaterial().getPrecioxmaterial();
        cantidad = joya.getCantidad();
        valorJoya = valorDisenio + valorMaterial + valorTipo;
        valorTootal = valorJoya*cantidad;
       

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
                        case 201013:
                        rutaImagen += "4";
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
                        
                        case 201013:
                        rutaImagen += "4";
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
                        case 201013:
                        rutaImagen += "4";
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
    
       public void clienteregistrarJoya() {
        try {
            List<Joya> joyas =  new ArrayList<>();
            List<Persona> personas = new ArrayList<>();
             Persona persona = new Persona();    
            orden.setFechaOrden(new Date());
            orden.setValorTotal(valorTootal);
            
            OrdenFacade.create(orden);
            joya.setValorTotal(valorTootal);
            joya.setValorUnitario(valorJoya);
            joya.setIdOrden(OrdenFacade.buscarOrden());
            joyas.add(joya);          
            Persona login = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            persona.setIdPERSONAS(login.getIdPERSONAS());
            personas.add(persona);
            orden.setJoyaList(joyas);         
            /*orden.setPersonaList(personas); */                 
            joyaFacade.create(joya);
           
            
         email.setEmailRemitente("orfiplus@gmail.com");
         email.setPassRemitente("Cl4v3123");
         email.setEmailDestinatario("aminorfiplus@gmail.com");
         email.setEmailAsunto(asunto="Solicitud de : "+login.getNombres()+" "+login.getApellidos()+"" );
         email.setContenido(contenido=" se ha registrado una nueva solicitud de   : "+login.getNombres() +"  "+login.getApellidos()+" con el correo registrado  : "+login.getCorreoe()+"   y el telefono "+login.getTelefonos()+""
         + " el valor de la solicitud fue de   "+valorTootal+ "$ el producto solicitado es "+joya.getIdTipo().getTipo()+" de material "+joya.getIdMaterial().getMaterial()+
         "   con un diseño de :"+joya.getIdDisenio().getDisenio()+" y un gramaje de "
        +joya.getGramaje()+" con la inscripcion de -- "+joya.getInscripcion()+" "+" -- la cantidad es de   "+joya.getCantidad()+"  unidades");
         email.setRemitente("orfiplus@gmail.com");
         email.setDestinatario("aminorfiplus@gmail.com");
          if(email.enviar(asunto, contenido)){
            
          estadoe = true;
            
        
        } else{
           
           estadoe = false;
        }
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
