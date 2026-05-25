package com.example.MoneyFly.configuracion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.repositorios.ICategoriarepositorio;

@Component
public class CargarDatosCategoria implements CommandLineRunner {

    private final ICategoriarepositorio categoriaRepositorio;

    public CargarDatosCategoria(ICategoriarepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public void run(String... args) {

        String[] nombres = {
            "Alimentación", "Transporte", "Salud", "Educación", "Entretenimiento",
            "Ropa", "Servicios", "Vivienda", "Tecnología", "Deporte"
        };

        String[] responsables = {
            "Juan Perez", "Maria Gomez", "Carlos Ramirez", "Ana Torres", "Luis Martinez",
            "Sofia Herrera", "Pedro Castillo", "Valentina Diaz", "Jorge Suarez", "Laura Beltran"
        };

        String[] justificaciones = {
            "Gasto necesario", "Inversión personal", "Gasto recurrente", "Emergencia",
            "Ocio y bienestar", "Mantenimiento", "Ahorro planificado", null, null, null
        };

        String[] frecuencias = {
            "Diaria", "Semanal", "Quincenal", "Mensual", "Anual"
        };

        String[] alertas = {
            "50%", "70%", "80%", "90%", "100%"
        };

        String[] metodosPago = {
            "Efectivo", "Tarjeta débito", "Tarjeta crédito", "Transferencia", "PSE"
        };

        Random random = new Random();
        List<Categoria> categorias = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            String nombre        = nombres[random.nextInt(nombres.length)];
            String responsable   = responsables[random.nextInt(responsables.length)];
            String justificacion = justificaciones[random.nextInt(justificaciones.length)];
            String frecuencia    = frecuencias[random.nextInt(frecuencias.length)];
            String alerta        = alertas[random.nextInt(alertas.length)];
            String metodoPago    = metodosPago[random.nextInt(metodosPago.length)];

            int limiteGastos   = 100000 + random.nextInt(900000); // entre 100.000 y 1.000.000
            int gastosActuales = random.nextInt(limiteGastos);    // siempre menor al límite

            LocalDate fecha = LocalDate.now().minusDays(random.nextInt(365)); // último año

            Categoria c = new Categoria(
                alerta,
                fecha,
                frecuencia,
                gastosActuales,
                0, // ID se autogenera
                justificacion,
                limiteGastos,
                metodoPago,
                nombre,
                responsable
            );

            categorias.add(c);
        }

        categoriaRepositorio.saveAll(categorias);
        System.out.println(">>> Categorias precargadas correctamente");
    }
}