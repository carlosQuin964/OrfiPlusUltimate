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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author seanv
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByIdPERMISOS", query = "SELECT p FROM Permiso p WHERE p.idPERMISOS = :idPERMISOS"),
    @NamedQuery(name = "Permiso.findByPermiso", query = "SELECT p FROM Permiso p WHERE p.permiso = :permiso"),
    @NamedQuery(name = "Permiso.findByDescripcion", query = "SELECT p FROM Permiso p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Permiso.findByUrlPermisos", query = "SELECT p FROM Permiso p WHERE p.urlPermisos = :urlPermisos")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPERMISOS")
    private Integer idPERMISOS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "permiso")
    private String permiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 90)
    @Column(name = "urlPermisos")
    private String urlPermisos;
    @JoinTable(name = "rolpermisos", joinColumns = {
        @JoinColumn(name = "PERMISOS_idPERMISOS", referencedColumnName = "idPERMISOS")}, inverseJoinColumns = {
        @JoinColumn(name = "ROLES_idROL", referencedColumnName = "idROL")})
    @ManyToMany
    private List<Rol> rolList;
    @OneToMany(mappedBy = "pERMISOSidPERMISOS")
    private List<Permiso> permisoList;
    @JoinColumn(name = "PERMISOS_idPERMISOS", referencedColumnName = "idPERMISOS")
    @ManyToOne
    private Permiso pERMISOSidPERMISOS;

    public Permiso() {
    }

    public Permiso(Integer idPERMISOS) {
        this.idPERMISOS = idPERMISOS;
    }

    public Permiso(Integer idPERMISOS, String permiso, String descripcion) {
        this.idPERMISOS = idPERMISOS;
        this.permiso = permiso;
        this.descripcion = descripcion;
    }

    public Integer getIdPERMISOS() {
        return idPERMISOS;
    }

    public void setIdPERMISOS(Integer idPERMISOS) {
        this.idPERMISOS = idPERMISOS;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlPermisos() {
        return urlPermisos;
    }

    public void setUrlPermisos(String urlPermisos) {
        this.urlPermisos = urlPermisos;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    public Permiso getPERMISOSidPERMISOS() {
        return pERMISOSidPERMISOS;
    }

    public void setPERMISOSidPERMISOS(Permiso pERMISOSidPERMISOS) {
        this.pERMISOSidPERMISOS = pERMISOSidPERMISOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPERMISOS != null ? idPERMISOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPERMISOS == null && other.idPERMISOS != null) || (this.idPERMISOS != null && !this.idPERMISOS.equals(other.idPERMISOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.Permiso[ idPERMISOS=" + idPERMISOS + " ]";
    }
    
}
