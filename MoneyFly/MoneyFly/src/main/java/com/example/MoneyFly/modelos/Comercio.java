package com.example.MoneyFly.modelos;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @Column (name = "nit", nullable = true, unique = false, length = 30)
    private String nit;

    @Column (name = "nombre", nullable = false, unique = false, length = 30)
    private String nombre;

    @Column (name = "actividad", nullable = false, unique = false, length = 30)
    private String actividad;

    @Column (name = "contacto", nullable = true, unique = false, length = 30)
    private String contacto;
    
    @Column (name = "total_gastado", nullable = false, unique = false, length = 10)
    private int  totalGastado;

    @Column (name = "ubicacion", nullable = true, unique = false, length = 30)
    private String ubicacion;

    @Column(name = "gasto_promedio", nullable = false, unique = false, length = 20)//pendiente
    private int gastoPromedio;

    @Column(name = "sector_comercial", nullable = false, unique = false, length = 30)     
    private String sectorComercial;

    @Column(name = "fecha_gasto", nullable = false, unique = false, length = 30)//pendiente
    private LocalDate fechaGasto; 

    @OneToMany(mappedBy = "comercio")
    private List<Gastos> gastos; 

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
