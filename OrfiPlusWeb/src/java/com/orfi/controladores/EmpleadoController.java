/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;

import com.orfi.Facades.PersonaFacade;
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
@Named(value = "empleadoController")
@SessionScoped
public class EmpleadoController implements Serializable {
Integer selectedItemIndex;
    @EJB
    private PersonaFacade personaFacade;
    private Persona persona;

    /**
     * Creates a new instance of EmpleadoController
     */
    @PostConstruct
    public void init() {
        persona = new Persona();

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
     public List<Persona> getAll() {
        List<Persona> li = personaFacade.findAll();
        return li;
    }
    

    public void registrarUsuario() {
        try {

            personaFacade.create(persona);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Error en envio de datos");
        }
    }

}
