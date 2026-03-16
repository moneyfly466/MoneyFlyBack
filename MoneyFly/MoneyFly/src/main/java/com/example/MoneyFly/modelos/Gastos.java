package com.example.MoneyFly.modelos;
import jakarta.persistence.*;

import java.time.LocalDate;

public class Gastos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "descripcion_gasto", nullable = false, unique = false, length = 30)
    private String descripcion;

    @Column (name = "fecha_gasto", nullable = false)
    private LocalDate fecha;

    @Column (name = "valor", nullable = false, unique = false, length = 10)//al ser gasto hormiga tiene digitos menores
    private int valor;

    @Column(name = "imagen", nullable = true)//campo opcional
    private String imagen;
    
    @Column(name = "Comercio", nullable = false, unique = false, length = 30)
    private String comercio;

    @Column(name = "medio_de_pago", nullable = false, unique = false, length = 30)
    private String medioPago;

    @Column(name = "ubicacion", nullable = false, unique = false, length = 30)
    private String ubicacion;

   
    private int maximo;//pendiente
    private String minimo;//pendiente

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColunmName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_comercio")
    private Comercio comercio;




    public Gastos() {
    }

    public Gastos(String comercio, String descripcion, LocalDate fecha, int id, String imagen, int maximo, String medioPago, String minimo, String ubicacion, int valor) {
        this.comercio = comercio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id = id;
        this.imagen = imagen;
        this.maximo = maximo;
        this.medioPago = medioPago;
        this.minimo = minimo;
        this.ubicacion = ubicacion;
        this.valor = valor;
    }

    

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getValor() {
        return valor;
    }

    public String getImagen() {
        return imagen;
    }

    public String getComercio() {
        return comercio;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getMaximo() {
        return maximo;
    }

    public String getMinimo() {
        return minimo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }


    
}
