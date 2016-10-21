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
import javax.persistence.TypedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author seanv
 */
@Entity
@Table(name = "disenios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disenio.findAll", query = "SELECT d FROM Disenio d"),
    @NamedQuery(name = "Disenio.findByIdDISENIO", query = "SELECT d FROM Disenio d WHERE d.idDISENIO = :idDISENIO"),
    @NamedQuery(name = "Disenio.findByDisenio", query = "SELECT d FROM Disenio d WHERE d.disenio = :disenio"),
    @NamedQuery(name = "Disenio.findByDescripcion", query = "SELECT d FROM Disenio d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Disenio.findByEstadoinfo", query = "SELECT d FROM Disenio d WHERE d.estadoinfo = :estadoinfo"),
    @NamedQuery(name = "Disenio.findByPrecioxdisenio", query = "SELECT d FROM Disenio d WHERE d.precioxdisenio = :precioxdisenio"),
    @NamedQuery(name = "Disenio.findByUrlDisenio", query = "SELECT d FROM Disenio d WHERE d.urlDisenio = :urlDisenio")})
public class Disenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDISENIO")
    private Integer idDISENIO;
    @Size(max = 20)
    @Column(name = "disenio")
    private String disenio;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estadoinfo")
    private Boolean estadoinfo;
    @Column(name = "precioxdisenio")
    private Integer precioxdisenio;
    @Size(max = 100)
    @Column(name = "urlDisenio")
    private String urlDisenio;
    @OneToMany(mappedBy = "idDisenio")
    private List<Joya> joyaList;

    public Disenio() {
    }

    public Disenio(Integer idDISENIO) {
        this.idDISENIO = idDISENIO;
    }

    public Integer getIdDISENIO() {
        return idDISENIO;
    }

    public void setIdDISENIO(Integer idDISENIO) {
        this.idDISENIO = idDISENIO;
    }

    public String getDisenio() {
        return disenio;
    }

    public void setDisenio(String disenio) {
        this.disenio = disenio;
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

    public Integer getPrecioxdisenio() {
        return precioxdisenio;
    }

    public void setPrecioxdisenio(Integer precioxdisenio) {
        this.precioxdisenio = precioxdisenio;
    }

    public String getUrlDisenio() {
        return urlDisenio;
    }

    public void setUrlDisenio(String urlDisenio) {
        this.urlDisenio = urlDisenio;
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
        hash += (idDISENIO != null ? idDISENIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disenio)) {
            return false;
        }
        Disenio other = (Disenio) object;
        if ((this.idDISENIO == null && other.idDISENIO != null) || (this.idDISENIO != null && !this.idDISENIO.equals(other.idDISENIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.Disenio[ idDISENIO=" + idDISENIO + " ]";
    }
    
}
