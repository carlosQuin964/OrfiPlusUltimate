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
@Table(name = "estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByIdESTADO", query = "SELECT e FROM Estado e WHERE e.idESTADO = :idESTADO"),
    @NamedQuery(name = "Estado.findByEstadoJoya", query = "SELECT e FROM Estado e WHERE e.estadoJoya = :estadoJoya"),
    @NamedQuery(name = "Estado.findByDescripcion", query = "SELECT e FROM Estado e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Estado.findByEstadoinfo", query = "SELECT e FROM Estado e WHERE e.estadoinfo = :estadoinfo")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idESTADO")
    private Integer idESTADO;
    @Size(max = 15)
    @Column(name = "estadoJoya")
    private String estadoJoya;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estadoinfo")
    private Boolean estadoinfo;
    @OneToMany(mappedBy = "idEstado")
    private List<Joya> joyaList;

    public Estado() {
    }

    public Estado(Integer idESTADO) {
        this.idESTADO = idESTADO;
    }

    public Integer getIdESTADO() {
        return idESTADO;
    }

    public void setIdESTADO(Integer idESTADO) {
        this.idESTADO = idESTADO;
    }

    public String getEstadoJoya() {
        return estadoJoya;
    }

    public void setEstadoJoya(String estadoJoya) {
        this.estadoJoya = estadoJoya;
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
        hash += (idESTADO != null ? idESTADO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idESTADO == null && other.idESTADO != null) || (this.idESTADO != null && !this.idESTADO.equals(other.idESTADO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.Estado[ idESTADO=" + idESTADO + " ]";
    }
    
}
