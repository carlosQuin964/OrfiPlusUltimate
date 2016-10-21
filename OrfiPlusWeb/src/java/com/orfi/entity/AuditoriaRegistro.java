/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orfi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author seanv
 */
@Entity
@Table(name = "auditoria_registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaRegistro.findAll", query = "SELECT a FROM AuditoriaRegistro a"),
    @NamedQuery(name = "AuditoriaRegistro.findByIdauditoriaReg", query = "SELECT a FROM AuditoriaRegistro a WHERE a.idauditoriaReg = :idauditoriaReg"),
    @NamedQuery(name = "AuditoriaRegistro.findByUsuario", query = "SELECT a FROM AuditoriaRegistro a WHERE a.usuario = :usuario"),
    @NamedQuery(name = "AuditoriaRegistro.findByFechaCreacion", query = "SELECT a FROM AuditoriaRegistro a WHERE a.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "AuditoriaRegistro.findByDescripcion", query = "SELECT a FROM AuditoriaRegistro a WHERE a.descripcion = :descripcion")})
public class AuditoriaRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauditoriaReg")
    private Integer idauditoriaReg;
    @Size(max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Size(max = 120)
    @Column(name = "descripcion")
    private String descripcion;

    public AuditoriaRegistro() {
    }

    public AuditoriaRegistro(Integer idauditoriaReg) {
        this.idauditoriaReg = idauditoriaReg;
    }

    public Integer getIdauditoriaReg() {
        return idauditoriaReg;
    }

    public void setIdauditoriaReg(Integer idauditoriaReg) {
        this.idauditoriaReg = idauditoriaReg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
        hash += (idauditoriaReg != null ? idauditoriaReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditoriaRegistro)) {
            return false;
        }
        AuditoriaRegistro other = (AuditoriaRegistro) object;
        if ((this.idauditoriaReg == null && other.idauditoriaReg != null) || (this.idauditoriaReg != null && !this.idauditoriaReg.equals(other.idauditoriaReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.AuditoriaRegistro[ idauditoriaReg=" + idauditoriaReg + " ]";
    }
    
}
