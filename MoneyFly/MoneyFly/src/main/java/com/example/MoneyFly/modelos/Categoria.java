package com.example.MoneyFly.modelos;
import jakarta.persistence.*;
import java.time.LocalDate;

public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private LocalDate fechaCreacion;
    private String responsable;
    private String justificacion;

    private int limiteGastos;
    private int gastosActuales;
    private String frecuencia ;
    private String alertGastos;
    private String metodoPagoPreferido;

    public Categoria() {
    }

    public Categoria(String alertGastos, LocalDate fechaCreacion, String frecuencia, int gastosActuales, int id, String justificacion, int limiteGastos, String metodoPagoPreferido, String nombre, String responsable) {
        this.alertGastos = alertGastos;
        this.fechaCreacion = fechaCreacion;
        this.frecuencia = frecuencia;
        this.gastosActuales = gastosActuales;
        this.id = id;
        this.justificacion = justificacion;
        this.limiteGastos = limiteGastos;
        this.metodoPagoPreferido = metodoPagoPreferido;
        this.nombre = nombre;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public int getLimiteGastos() {
        return limiteGastos;
    }

    public int getGastosActuales() {
        return gastosActuales;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getAlertGastos() {
        return alertGastos;
    }

    public String getMetodoPagoPreferido() {
        return metodoPagoPreferido;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public void setLimiteGastos(int limiteGastos) {
        this.limiteGastos = limiteGastos;
    }

    public void setGastosActuales(int gastosActuales) {
        this.gastosActuales = gastosActuales;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setAlertGastos(String alertGastos) {
        this.alertGastos = alertGastos;
    }

    public void setMetodoPagoPreferido(String metodoPagoPreferido) {
        this.metodoPagoPreferido = metodoPagoPreferido;
    }

    


}
