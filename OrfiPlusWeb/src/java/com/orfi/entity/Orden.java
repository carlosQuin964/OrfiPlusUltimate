/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author seanv
 */
@Entity
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o"),
    @NamedQuery(name = "Orden.findByIdORDEN", query = "SELECT o FROM Orden o WHERE o.idORDEN = :idORDEN"),
    @NamedQuery(name = "Orden.findByFechaEntrega", query = "SELECT o FROM Orden o WHERE o.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Orden.findByFechaOrden", query = "SELECT o FROM Orden o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "Orden.findByEstadoinfo", query = "SELECT o FROM Orden o WHERE o.estadoinfo = :estadoinfo"),
    @NamedQuery(name = "Orden.findByValorTotal", query = "SELECT o FROM Orden o WHERE o.valorTotal = :valorTotal")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idORDEN")
    private Integer idORDEN;
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Column(name = "fechaOrden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @Column(name = "estadoinfo")
    private Boolean estadoinfo;
    @Column(name = "valorTotal")
    private Integer valorTotal;
    @JoinTable(name = "personasorden", joinColumns = {
        @JoinColumn(name = "ORDEN_idORDEN", referencedColumnName = "idORDEN")}, inverseJoinColumns = {
        @JoinColumn(name = "PERSONAS_idPERSONAS", referencedColumnName = "idPERSONAS")})
    @ManyToMany
    private List<Persona> personaList;
    @OneToMany(mappedBy = "idOrden")
    private List<Joya> joyaList;

    public Orden() {
    }

    public Orden(Integer idORDEN) {
        this.idORDEN = idORDEN;
    }

    public Integer getIdORDEN() {
        return idORDEN;
    }

    public void setIdORDEN(Integer idORDEN) {
        this.idORDEN = idORDEN;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Boolean getEstadoinfo() {
        return estadoinfo;
    }

    public void setEstadoinfo(Boolean estadoinfo) {
        this.estadoinfo = estadoinfo;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Joya> getJoyaList() {
        return joyaList;
    }

    public void setJoyaList(List<Joya> joyaList) {
        this.joyaList = joyaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idORDEN != null ? idORDEN.hashCode() : 0);
        return hash;
    }
    

  
     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idORDEN == null && other.idORDEN != null) || (this.idORDEN != null && !this.idORDEN.equals(other.idORDEN))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.Orden[ idORDEN=" + idORDEN + " ]";
    }
    
}
