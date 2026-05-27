package com.example.MoneyFly.modelos;

import java.util.List;

import com.example.MoneyFly.modelos.utils.Genero;
import com.example.MoneyFly.modelos.utils.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "tipo_documento", nullable = false, unique = false, length = 20)
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

    @Column(name = "Contraseña", nullable = false, unique = false, length = 50)
    private String contraseña;

    @Column(name = "Genero", nullable = false, unique = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "Ocupacion", nullable = false, length = 50)
    private String ocupacion;

    // @JsonIgnore evita el bucle infinito al serializar a JSON
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<MedioPago> medioPago;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Gastos> Gastos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Categoria> categorias;

    public Usuario() {
    }

    public Usuario(String contraseña, String correo, String documento, int edad, Genero genero, int id, String nombres, String ocupacion, String telefono, TipoDocumento tipoDocumento) {
        this.contraseña = contraseña;
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

    public String getContraseña() {
        return contraseña;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public List<MedioPago> getMedioPago() {
        return medioPago;
    }

    public List<Gastos> getGastos() {
        return Gastos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
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

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setMedioPago(List<MedioPago> medioPago) {
        this.medioPago = medioPago;
    }

    public void setGastos(List<Gastos> gastos) {
        Gastos = gastos;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}