package com.example.MoneyFly.modelos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion_gasto", nullable = false, length = 30)
    private String descripcion;

    @Column(name = "fecha_gasto", nullable = false)
    private LocalDate fecha;

    @Column(name = "valor", nullable = false)
    private Integer valor;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "comercio", nullable = false, length = 30)
    private String comercio;

    @Column(name = "medio_de_pago", nullable = false, length = 30)
    private String medioPago;

    @Column(name = "ubicacion", nullable = false, length = 30)
    private String ubicacion;

    @Column(name = "maximo")
    private Integer maximo;

    @Column(name = "minimo")
    private String minimo;

   
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_Categoria")
    private Categoria categoria;

    public Gastos() {
    }

   
    public Gastos(
            int id,
            String descripcion,
            LocalDate fecha,
            Integer valor,
            String imagen,
            String comercio,
            String medioPago,
            String ubicacion,
            Integer maximo,
            String minimo) {

        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.valor = valor;
        this.imagen = imagen;
        this.comercio = comercio;
        this.medioPago = medioPago;
        this.ubicacion = ubicacion;
        this.maximo = maximo;
        this.minimo = minimo;
    }

   
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Integer getValor() {
        return valor;
    }

    public String getImagen() {
        return imagen;
    }

    public String getComercio() {
    return comercio;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Integer getMaximo() {
        return maximo;
    }

    public String getMinimo() {
        return minimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

  
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setComercio(String comercio) {
    this.comercio = comercio;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}