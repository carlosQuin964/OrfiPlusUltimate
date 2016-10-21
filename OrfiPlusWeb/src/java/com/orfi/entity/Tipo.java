/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author seanv
 */
@Entity
@Table(name = "tipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t"),
    @NamedQuery(name = "Tipo.findByIdTIPO", query = "SELECT t FROM Tipo t WHERE t.idTIPO = :idTIPO"),
    @NamedQuery(name = "Tipo.findByTipo", query = "SELECT t FROM Tipo t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tipo.findByDescripcion", query = "SELECT t FROM Tipo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tipo.findByEstadoinfo", query = "SELECT t FROM Tipo t WHERE t.estadoinfo = :estadoinfo"),
    @NamedQuery(name = "Tipo.findByPrecioxtipo", query = "SELECT t FROM Tipo t WHERE t.precioxtipo = :precioxtipo"),
    @NamedQuery(name = "Tipo.findByUrlTipo", query = "SELECT t FROM Tipo t WHERE t.urlTipo = :urlTipo")})
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTIPO")
    private Integer idTIPO;
    @Size(max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estadoinfo")
    private Boolean estadoinfo;
    @Column(name = "precioxtipo")
    private Integer precioxtipo;
    @Size(max = 100)
    @Column(name = "urlTipo")
    private String urlTipo;
    @OneToMany(mappedBy = "idTipo")
    private List<Joya> joyaList;

    public Tipo() {
    }

    public Tipo(Integer idTIPO) {
        this.idTIPO = idTIPO;
    }

    public Integer getIdTIPO() {
        return idTIPO;
    }

    public void setIdTIPO(Integer idTIPO) {
        this.idTIPO = idTIPO;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstadoinfo() {
        return estadoinfo;
    }

    public void setEstadoinfo(Boolean estadoinfo) {
        this.estadoinfo = estadoinfo;
    }

    public Integer getPrecioxtipo() {
        return precioxtipo;
    }

    public void setPrecioxtipo(Integer precioxtipo) {
        this.precioxtipo = precioxtipo;
    }

    public String getUrlTipo() {
        return urlTipo;
    }

    public void setUrlTipo(String urlTipo) {
        this.urlTipo = urlTipo;
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
        hash += (idTIPO != null ? idTIPO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.idTIPO == null && other.idTIPO != null) || (this.idTIPO != null && !this.idTIPO.equals(other.idTIPO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.Tipo[ idTIPO=" + idTIPO + " ]";
    }
    
}
