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
@Table(name = "materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByIdMATERIAL", query = "SELECT m FROM Material m WHERE m.idMATERIAL = :idMATERIAL"),
    @NamedQuery(name = "Material.findByMaterial", query = "SELECT m FROM Material m WHERE m.material = :material"),
    @NamedQuery(name = "Material.findByDescripcion", query = "SELECT m FROM Material m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Material.findByEstadoinfo", query = "SELECT m FROM Material m WHERE m.estadoinfo = :estadoinfo"),
    @NamedQuery(name = "Material.findByPrecioxmaterial", query = "SELECT m FROM Material m WHERE m.precioxmaterial = :precioxmaterial"),
    @NamedQuery(name = "Material.findByUrlMaterial", query = "SELECT m FROM Material m WHERE m.urlMaterial = :urlMaterial")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMATERIAL")
    private Integer idMATERIAL;
    @Size(max = 20)
    @Column(name = "material")
    private String material;
    @Size(max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estadoinfo")
    private Boolean estadoinfo;
    @Column(name = "precioxmaterial")
    private Integer precioxmaterial;
    @Size(max = 100)
    @Column(name = "urlMaterial")
    private String urlMaterial;
    @OneToMany(mappedBy = "idMaterial")
    private List<Joya> joyaList;

    public Material() {
    }

    public Material(Integer idMATERIAL) {
        this.idMATERIAL = idMATERIAL;
    }

    public Integer getIdMATERIAL() {
        return idMATERIAL;
    }

    public void setIdMATERIAL(Integer idMATERIAL) {
        this.idMATERIAL = idMATERIAL;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public Integer getPrecioxmaterial() {
        return precioxmaterial;
    }

    public void setPrecioxmaterial(Integer precioxmaterial) {
        this.precioxmaterial = precioxmaterial;
    }

    public String getUrlMaterial() {
        return urlMaterial;
    }

    public void setUrlMaterial(String urlMaterial) {
        this.urlMaterial = urlMaterial;
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
        hash += (idMATERIAL != null ? idMATERIAL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.idMATERIAL == null && other.idMATERIAL != null) || (this.idMATERIAL != null && !this.idMATERIAL.equals(other.idMATERIAL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.Material[ idMATERIAL=" + idMATERIAL + " ]";
    }
    
}
