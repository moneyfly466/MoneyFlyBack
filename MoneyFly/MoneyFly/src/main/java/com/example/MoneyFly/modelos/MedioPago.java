package com.example.MoneyFly.modelos;

import org.hibernate.annotations.ManyToAny;

import com.example.MoneyFly.modelos.utils.Estado;
import com.example.MoneyFly.modelos.utils.Franquicia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private Franquicia franquicia;

    @Column(name = "estado", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;  

    @ManyToAny
    @JoinColumn(name = "fk_usuario" , referencedColumnName = "id") 
    private Usuario usuario;

 

    public MedioPago() {
    }



    public MedioPago(int id, String nombre, Franquicia franquicia, Estado estado, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.franquicia = franquicia;
        this.estado = estado;
        this.usuario = usuario;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public Franquicia getFranquicia() {
        return franquicia;
    }



    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }



    public Estado getEstado() {
        return estado;
    }



    public void setEstado(Estado estado) {
        this.estado = estado;
    }



    public Usuario getUsuario() {
        return usuario;
    }



    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }




}
