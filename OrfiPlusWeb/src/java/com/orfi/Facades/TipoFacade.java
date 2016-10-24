/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.Facades;

import com.orfi.entity.Tipo;
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
public class TipoFacade extends AbstractFacade<Tipo> {

    @PersistenceContext(unitName = "OrfiPlusWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoFacade() {
        super(Tipo.class);
    }
    
    public List<Tipo> getTipos() {
        List<Tipo> tipo = null;
        try {
            TypedQuery<Tipo> query = em.createNamedQuery("Tipo.findByTipo", Tipo.class);
            tipo = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return tipo;
    }
    
}
