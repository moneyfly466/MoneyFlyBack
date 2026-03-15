package com.example.MoneyFly.modelos;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nit;
    private String nombre;
    private String actividad;
    private String contacto;
    
    private int  totalGastado;
    private String ubicacion;
    private int gastoPromedio;
    private String sectorComercial;
    private LocalDate fechaGasto; 
   
    public Comercio() {
    }

    public Comercio(int id, String nit, String nombre, String actividad, String contacto, int totalGastado,
            String ubicacion, int gastoPromedio, String sectorComercial, LocalDate fechaGasto) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.actividad = actividad;
        this.contacto = contacto;
        this.totalGastado = totalGastado;
        this.ubicacion = ubicacion;
        this.gastoPromedio = gastoPromedio;
        this.sectorComercial = sectorComercial;
        this.fechaGasto = fechaGasto;
    }

    public int getId() {
        return id;
    }

    public String getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public String getContacto() {
        return contacto;
    }

    public int getTotalGastado() {
        return totalGastado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getGastoPromedio() {
        return gastoPromedio;
    }

    public String getSectorComercial() {
        return sectorComercial;
    }

    public LocalDate getFechaGasto() {
        return fechaGasto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setTotalGastado(int totalGastado) {
        this.totalGastado = totalGastado;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setGastoPromedio(int gastoPromedio) {
        this.gastoPromedio = gastoPromedio;
    }

    public void setSectorComercial(String sectorComercial) {
        this.sectorComercial = sectorComercial;
    }

    public void setFechaGasto(LocalDate fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    



}
