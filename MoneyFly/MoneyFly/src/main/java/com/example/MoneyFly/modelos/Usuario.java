package com.example.MoneyFly.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")


public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombres_completos", nullable = false, unique = false, length = 50)
    private String nombres; 

    @Column(name = "tipo_documento", nullable = false, unique = false, length = 20) // hay que hacerle un enum
    @Enumerated(EnumType.STRING)
    private String tipoDocumento;

    @Column(name = "", nullable = false, unique = true, length = 15)
    private String documento;

    @Column(name = "", nullable = false, unique = false)
    private int edad;

    @Column(name = "", nullable = false, unique = true, length = 30)
    private String correo;

    @Column(name = "", nullable = false, unique = true, length = 15)
    private String telefono;

    @Column(name = "", nullable = false, unique = false, length = 50)
    private String contrasena;

    @Column(name = "", nullable = false, unique = false, length = 20) // hay que hacerle un enum
    @Enumerated(EnumType.STRING)
    private String genero;

    @Column(name = "", nullable = false, unique = true, length = 50)
    private String ocupacion;

    
    public Usuario() {
    }

    public Usuario(String contrasena, String correo, String documento, int edad, String genero, int id, String nombres, String ocupacion, String telefono, String tipoDocumento) {
        this.contrasena = contrasena;
        this.correo = correo;
        this.documento = documento;
        this.edad = edad;
        this.genero = genero;
        this.id = id;
        this.nombres = nombres;
        this.ocupacion = ocupacion;
        this.telefono = telefono;
        this.tipoDocumento = tipoDocumento;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getGenero() {
        return genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    
    

}
