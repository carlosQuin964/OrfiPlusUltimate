/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.Facades;

import com.orfi.entity.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author seanv
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {

    @PersistenceContext(unitName = "OrfiPlusWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
     public List<Estado> consultarEstado() {
        List<Estado> material = null;
        try {
            TypedQuery<Estado> query = em.createNamedQuery("Estado.findAll", Estado.class);
            material = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return material;
    }
    
}
