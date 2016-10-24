/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.controladores;
import com.orfi.Facades.JoyaFacade;
import com.orfi.Facades.TipoFacade;
import com.orfi.entity.Joya;
import com.orfi.entity.Tipo;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

 
@ManagedBean(name="joyasFilterView")
@ViewScoped
public class JoyaFilterView implements Serializable {
     
    private List<Joya> joya;
    private List<Joya> joyaFiltrada;
    private Tipo tipo;
    @ManagedProperty("#{joyafacade}")
    private JoyaFacade joyaFacade;
    @EJB
    private TipoFacade tipoFacade;
     
   
 
    @PostConstruct
    public void init() {
        joya = joyaFacade.consultarJoya();

    }
     
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }
     
    public List<Joya> getJoyas() {
        return joya;
    }
 
    public List<Joya> getJoyasFiltradas() {
        return joyaFiltrada;
    }
 
    public void setJoyasFiltradas(List<Joya> joyaFiltrada) {
        this.joyaFiltrada = joyaFiltrada;
    }
 
    public void setjoyaFacade(JoyaFacade joyaFacade) {
        this.joyaFacade = joyaFacade;
    }
    
    public List<Tipo> getTipo() {
        return tipoFacade.getTipos();
    }
    
}