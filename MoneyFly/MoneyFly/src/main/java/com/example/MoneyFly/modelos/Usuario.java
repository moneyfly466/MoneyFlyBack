package com.example.MoneyFly.modelos;

import java.util.List;

import com.example.MoneyFly.modelos.utils.Genero;
import com.example.MoneyFly.modelos.utils.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private TipoDocumento tipoDocumento;

    @Column(name = "Documento", nullable = false, unique = true, length = 15)
    private String documento;

    @Column(name = "Edad", nullable = false, unique = false)
    private int edad;

    @Column(name = "Correo", nullable = false, unique = true, length = 30)
    private String correo;

    @Column(name = "Telefono", nullable = false, unique = true, length = 15)
    private String telefono;

    @Column(name = "Contrasena", nullable = false, unique = false, length = 50)
    private String contrasena;

    @Column(name = "Genero", nullable = false, unique = false, length = 20) // hay que hacerle un enum
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "Ocupacion", nullable = false, unique = true, length = 50)
    private String ocupacion;

    @OneToMany (mappedBy = "usuario")
    private List <MedioPago> medioPago;

    @OneToMany (mappedBy = "usuario")
     private List<Gastos> Gastos;


    
    public Usuario() {
    }

    public Usuario(String contrasena, String correo, String documento, int edad, Genero genero, int id, String nombres, String ocupacion, String telefono, TipoDocumento tipoDocumento) {
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

    public TipoDocumento getTipoDocumento() {
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

    public Genero getGenero() {
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

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
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

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    
    

}
