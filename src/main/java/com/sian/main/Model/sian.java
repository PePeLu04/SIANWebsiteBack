package com.sian.main.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "sian")
public class sian {

    private String codigo;
    private String articulo;
    private String familia;

    @Column(name = "Nombre Familia")
    private String nombreFamilia;

    @Column(name = "Familia de Ventas")
    private String familiaVentas;

    @Column(name = "Nombre Familia de Ventas")
    private String nombreFamiliaVentas;

    private String stock;

    @Column(name = "Part Number")
    private String partNumber;

    private String ean;
    private String imagen;
    private String peso;

    @Column(name = "Codigo Grupo Familia Ventas")
    private String codigoGrupoFamiliaVentas;

    @Column(name = "Nombre Grupo Familia Ventas")
    private String nombreGrupoFamiliaVentas;

    @Column(name = "PVP PuntoD con canon (IVA Incluido)")
    private String pvpPuntoDConCanon;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID Articulo")
    private String idArticulo;

    private String estado;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public String getFamiliaVentas() {
        return familiaVentas;
    }

    public void setFamiliaVentas(String familiaVentas) {
        this.familiaVentas = familiaVentas;
    }

    public String getNombreFamiliaVentas() {
        return nombreFamiliaVentas;
    }

    public void setNombreFamiliaVentas(String nombreFamiliaVentas) {
        this.nombreFamiliaVentas = nombreFamiliaVentas;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCodigoGrupoFamiliaVentas() {
        return codigoGrupoFamiliaVentas;
    }

    public void setCodigoGrupoFamiliaVentas(String codigoGrupoFamiliaVentas) {
        this.codigoGrupoFamiliaVentas = codigoGrupoFamiliaVentas;
    }

    public String getNombreGrupoFamiliaVentas() {
        return nombreGrupoFamiliaVentas;
    }

    public void setNombreGrupoFamiliaVentas(String nombreGrupoFamiliaVentas) {
        this.nombreGrupoFamiliaVentas = nombreGrupoFamiliaVentas;
    }

    public String getPvpPuntoDConCanon() {
        return pvpPuntoDConCanon;
    }

    public void setPvpPuntoDConCanon(String pvpPuntoDConCanon) {
        this.pvpPuntoDConCanon = pvpPuntoDConCanon;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}