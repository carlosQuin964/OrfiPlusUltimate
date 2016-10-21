/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.Facades;

import com.orfi.entity.Persona;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author seanv
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "OrfiPlusWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public List<Persona> consultarPersonas() {
        List<Persona> persona = null;
        try {
            TypedQuery<Persona> query = em.createNamedQuery("Persona.findAll", Persona.class);
            persona = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return persona;
    }

    public Persona validate(String user, String password) {
        Persona persona = null;
        try {
            TypedQuery<Persona> query = em.createNamedQuery("Persona.login", Persona.class);
            query.setParameter("correo", user);
            query.setParameter("psw", password);
            persona = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return persona;
    }

    public List<Persona> fitro(Map<String, Object> filtros) {
        //Arma la estructura basica de la consulta y lo carga en un objeto String
        String jpql = "SELECT p FROM Persona p WHERE ";
        //para controlar el While mendiante el tam?ano del MAP
        Iterator it = filtros.keySet().iterator();
        //Completa la estructura segun el numero y la forma de criterios
        while (it.hasNext()) {
            //la variable que va a ser reemplada segun el criterio, por ej Nombre = carlos
            String atributo = it.next().toString();
            //esqueleto de la segunda parte de la consulta que pfue guardada primeramente en jpql
            //Adicional se valida si hay mas filtros ((it.hasNext()) ? " AND " : ""
            jpql += "p." + atributo + " = :" + atributo + ((it.hasNext()) ? " AND " : "");
            //Object valor = filtros.get(key);
        }
        //Lista donde inserta en la consulta prearmada JPQL los datos que se quieren adicionar ej Carlos como nombre y Ramirez como apellido
        TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
        //reinicar el iterador
        it = filtros.keySet().iterator();
        //while a ver?
        while (it.hasNext()) {
            //a?ade en un string los datos que se trajeron de afuera como nombres o apellidos
            String atributo = it.next().toString();
            //aca si se carga el valor especifico por el cul se quier filtrar ej carlos y ramirez
            Object valor = filtros.get(atributo);
            //los inserta dentro del texto de la consulta que se venia armando en el anterior WHILE
            query.setParameter(atributo, valor);
        }
        //AHORA SI SE EJECUTA LA CONSULTA A LA BASE DE DATOS
        return query.getResultList();
    }

}
