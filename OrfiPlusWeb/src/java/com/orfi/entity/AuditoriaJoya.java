/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author seanv
 */
@Entity
@Table(name = "auditoria_joya")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaJoya.findAll", query = "SELECT a FROM AuditoriaJoya a"),
    @NamedQuery(name = "AuditoriaJoya.findByIdAuditoriaJoya", query = "SELECT a FROM AuditoriaJoya a WHERE a.idAuditoriaJoya = :idAuditoriaJoya"),
    @NamedQuery(name = "AuditoriaJoya.findByIdUsuario", query = "SELECT a FROM AuditoriaJoya a WHERE a.idUsuario = :idUsuario"),
    @NamedQuery(name = "AuditoriaJoya.findByUsuario", query = "SELECT a FROM AuditoriaJoya a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AuditoriaJoya.findByDescripcion", query = "SELECT a FROM AuditoriaJoya a WHERE a.descripcion = :descripcion")})
public class AuditoriaJoya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAuditoriaJoya")
    private Integer idAuditoriaJoya;
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 100)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 120)
    @Column(name = "descripcion")
    private String descripcion;

    public AuditoriaJoya() {
    }

    public AuditoriaJoya(Integer idAuditoriaJoya) {
        this.idAuditoriaJoya = idAuditoriaJoya;
    }

    public Integer getIdAuditoriaJoya() {
        return idAuditoriaJoya;
    }

    public void setIdAuditoriaJoya(Integer idAuditoriaJoya) {
        this.idAuditoriaJoya = idAuditoriaJoya;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoriaJoya != null ? idAuditoriaJoya.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditoriaJoya)) {
            return false;
        }
        AuditoriaJoya other = (AuditoriaJoya) object;
        if ((this.idAuditoriaJoya == null && other.idAuditoriaJoya != null) || (this.idAuditoriaJoya != null && !this.idAuditoriaJoya.equals(other.idAuditoriaJoya))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.AuditoriaJoya[ idAuditoriaJoya=" + idAuditoriaJoya + " ]";
    }
    
}
