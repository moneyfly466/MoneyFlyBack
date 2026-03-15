package com.example.MoneyFly.modelos;

import com.example.MoneyFly.modelos.utils.Franquicia;
import com.example.MoneyFly.modelos.utils.estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Column(name =  "nombre_metodo", nullable = false, unique = false, length = 20)
    private String nombre;

    @Column (name = "franquicia", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Franquicia franquicia;//enum

    @Column(name = "estado", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private estado estado;
    

    public MedioPago() {
    }

    public MedioPago(int id, String nombre, Franquicia franquicia, estado estado) {
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

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public estado getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

    

}
