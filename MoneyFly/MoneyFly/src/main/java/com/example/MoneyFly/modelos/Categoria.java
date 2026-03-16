package com.example.MoneyFly.modelos;
import jakarta.persistence.*;
import java.time.LocalDate;

public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, unique = false, length = 30)
    private String nombre;

    @Column(name = "fecha", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "responsable", nullable = false, unique = false, length = 30)//pendiente enum
    private String responsable;

    @Column(name = "justificacion", nullable = true, unique = false, length = 30)
    private String justificacion;

    @Column(name = "limite_gastos", nullable = false, unique = false, length = 20)//pndiente
    private int limiteGastos;

    @Column(name = "gastos_actuales", nullable = false, unique = false, length = 30)//pendiente
    private int gastosActuales;

    @Column(name = "frecuencia", nullable = false, unique = false, length = 30)
    private String frecuencia ;

    @Column(name = "alerta_gastos", nullable = false, unique = false, length = 30)//pendiente
    private String alertGastos;

    @Column(name = "medio_de_pago", nullable = false, unique = false, length = 30)//pendiente
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
