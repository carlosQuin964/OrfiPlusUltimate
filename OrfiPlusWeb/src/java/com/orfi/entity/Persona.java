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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author seanv
 */
@Entity
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPERSONAS", query = "SELECT p FROM Persona p WHERE p.idPERSONAS = :idPERSONAS"),
    @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Persona.findByApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Persona.findByCorreoe", query = "SELECT p FROM Persona p WHERE p.correoe = :correoe"),
    @NamedQuery(name = "Persona.findByPassword", query = "SELECT p FROM Persona p WHERE p.password = :password"),
    @NamedQuery(name = "Persona.findByTelefonos", query = "SELECT p FROM Persona p WHERE p.telefonos = :telefonos"),
    @NamedQuery(name = "Persona.findByEstadoinfo", query = "SELECT p FROM Persona p WHERE p.estadoinfo = :estadoinfo"),
    @NamedQuery(name = "Persona.findByFechaCreacion", query = "SELECT p FROM Persona p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Persona.login", query = "SELECT p FROM Persona p WHERE p.idPERSONAS = :correo AND p.password = :psw")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPERSONAS")
    private Integer idPERSONAS;
    @Size(max = 30)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 30)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 200)
    @Column(name = "correoe")
    private String correoe;
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    @Column(name = "telefonos")
    private String telefonos;
    @Column(name = "estadoinfo")
    private Boolean estadoinfo;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinTable(name = "rol_x_per", joinColumns = {
        @JoinColumn(name = "idpersonas", referencedColumnName = "idPERSONAS")}, inverseJoinColumns = {
        @JoinColumn(name = "idrol", referencedColumnName = "idROL")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> rolList;
    @ManyToMany(mappedBy = "personaList")
    private List<Orden> ordenList;

    public Persona() {
    }

    public Persona(Integer idPERSONAS) {
        this.idPERSONAS = idPERSONAS;
    }

    public Integer getIdPERSONAS() {
        return idPERSONAS;
    }

    public void setIdPERSONAS(Integer idPERSONAS) {
        this.idPERSONAS = idPERSONAS;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public Boolean getEstadoinfo() {
        return estadoinfo;
    }

    public void setEstadoinfo(Boolean estadoinfo) {
        this.estadoinfo = estadoinfo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Orden> getOrdenList() {
        return ordenList;
    }

    public void setOrdenList(List<Orden> ordenList) {
        this.ordenList = ordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPERSONAS != null ? idPERSONAS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPERSONAS == null && other.idPERSONAS != null) || (this.idPERSONAS != null && !this.idPERSONAS.equals(other.idPERSONAS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.Persona[ idPERSONAS=" + idPERSONAS + " ]";
    }

}
