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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "joyas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Joya.findAll", query = "SELECT j FROM Joya j"),
    @NamedQuery(name = "Joya.findByIdJoya", query = "SELECT j FROM Joya j WHERE j.idJoya = :idJoya"),
    @NamedQuery(name = "Joya.findByGramaje", query = "SELECT j FROM Joya j WHERE j.gramaje = :gramaje"),
    @NamedQuery(name = "Joya.findByTalla", query = "SELECT j FROM Joya j WHERE j.talla = :talla"),
    @NamedQuery(name = "Joya.findByInscripcion", query = "SELECT j FROM Joya j WHERE j.inscripcion = :inscripcion"),
    @NamedQuery(name = "Joya.findByCantidad", query = "SELECT j FROM Joya j WHERE j.cantidad = :cantidad"),
    @NamedQuery(name = "Joya.findByValorUnitario", query = "SELECT j FROM Joya j WHERE j.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Joya.findByValorTotal", query = "SELECT j FROM Joya j WHERE j.valorTotal = :valorTotal"),
    @NamedQuery(name = "Joya.findByEstadoinfo", query = "SELECT j FROM Joya j WHERE j.estadoinfo = :estadoinfo"),
    @NamedQuery(name = "Joya.findByUrlJoya", query = "SELECT j FROM Joya j WHERE j.urlJoya = :urlJoya")})
   
public class Joya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdJoya")
    private Integer idJoya;
    @Column(name = "gramaje")
    private Integer gramaje;
    @Size(max = 10)
    @Column(name = "talla")
    private String talla;
    @Size(max = 70)
    @Column(name = "inscripcion")
    private String inscripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "valorUnitario")
    private Integer valorUnitario;
    @Column(name = "valorTotal")
    private Integer valorTotal;
    @Column(name = "estadoinfo")
    private Boolean estadoinfo;
    @Size(max = 500)
    @Column(name = "urlJoya")
    private String urlJoya;
    @JoinColumn(name = "idDisenio", referencedColumnName = "idDISENIO")
    @ManyToOne
    private Disenio idDisenio;
    @JoinColumn(name = "IdEstado", referencedColumnName = "idESTADO")
    @ManyToOne
    private Estado idEstado;
    @JoinColumn(name = "idMaterial", referencedColumnName = "idMATERIAL")
    @ManyToOne
    private Material idMaterial;
    @JoinColumn(name = "idOrden", referencedColumnName = "idORDEN")
    @ManyToOne
    private Orden idOrden;
    @JoinColumn(name = "idTipo", referencedColumnName = "idTIPO")
    @ManyToOne
    private Tipo idTipo;

    public Joya() {
    }

    public Joya(Integer idJoya) {
        this.idJoya = idJoya;
    }

    public Integer getIdJoya() {
        return idJoya;
    }

    public void setIdJoya(Integer idJoya) {
        this.idJoya = idJoya;
    }

    public Integer getGramaje() {
        return gramaje;
    }

    public void setGramaje(Integer gramaje) {
        this.gramaje = gramaje;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(String inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getEstadoinfo() {
        return estadoinfo;
    }

    public void setEstadoinfo(Boolean estadoinfo) {
        this.estadoinfo = estadoinfo;
    }

    public String getUrlJoya() {
        return urlJoya;
    }

    public void setUrlJoya(String urlJoya) {
        this.urlJoya = urlJoya;
    }

    public Disenio getIdDisenio() {
        return idDisenio;
    }

    public void setIdDisenio(Disenio idDisenio) {
        this.idDisenio = idDisenio;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Orden idOrden) {
        this.idOrden = idOrden;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJoya != null ? idJoya.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joya)) {
            return false;
        }
        Joya other = (Joya) object;
        if ((this.idJoya == null && other.idJoya != null) || (this.idJoya != null && !this.idJoya.equals(other.idJoya))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orfi.entity.Joya[ idJoya=" + idJoya + " ]";
    }
    
}
