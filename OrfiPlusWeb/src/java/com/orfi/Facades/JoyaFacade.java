/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.Facades;

import com.orfi.entity.Joya;
import com.orfi.entity.Persona;
import com.orfi.entity.Tipo;
import java.util.ArrayList;
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
public class JoyaFacade extends AbstractFacade<Joya> {

    @PersistenceContext(unitName = "OrfiPlusWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JoyaFacade() {
        super(Joya.class);
    }
    
    public List<Joya> consultarJoya() {
        List<Joya> joya = null;
        try {
            TypedQuery<Joya> query = em.createNamedQuery("Joya.findAll", Joya.class);
            joya = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return joya;
    }
    
  /*  public String consultarTiposJoya(){
        Map<List<Tipo>,List<Joya>> joya = null;
        List<String> listaString = null;
        try {
            TypedQuery<Tipo> query = em.createNamedQuery("Joya.todosTipos", Tipo.class);
            TypedQuery<Joya> query1 = em.createNamedQuery("Joya.todosTipos", Joya.class);
            listaString = new ArrayList<String>(query.getResultList());
            joya.put(, query1.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("Error en envio de datos");
        }

        return joya;
    }
    
    */
    
}
