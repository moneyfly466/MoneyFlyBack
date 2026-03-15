package com.example.MoneyFly.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medio_pago")
public class MedioPago {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombre;
    private String franquicia;
    private String estado;

    public MedioPago() {
    }

    public MedioPago(int id, String nombre, String franquicia, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.franquicia = franquicia;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
