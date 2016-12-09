/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.Facades;

import com.orfi.entity.Orden;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author seanv
 */
@Stateless
public class OrdenFacade extends AbstractFacade<Orden> {

    @PersistenceContext(unitName = "OrfiPlusWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }
    public List<Orden> consultarOrden() {
        List<Orden> orden = null;
        try {
            TypedQuery<Orden> query = em.createNamedQuery("Orden.findAll", Orden.class);
            orden = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return orden;
    }
    
    public Orden buscarOrden(){
        Orden orden = new Orden ();
        
        Query query=em.createQuery("SELECT MAX(o.idORDEN) FROM Orden o");
        orden.setIdORDEN((Integer) query.getSingleResult());
        
        return orden;
            
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
}

