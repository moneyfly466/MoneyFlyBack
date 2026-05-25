package com.example.MoneyFly.configuracion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.MoneyFly.modelos.Gastos;
import com.example.MoneyFly.repositorios.IGastosrepositorio;

@Component
@Order(2)
public class CargaDatosGastos implements CommandLineRunner {

    private final IGastosrepositorio gastosRepositorio;

    public CargaDatosGastos(IGastosrepositorio gastosRepositorio) {
        this.gastosRepositorio = gastosRepositorio;
    }

    @Override
    public void run(String... args) {

        String[] descripciones = {
                "Café mañanero", "Almuerzo rápido", "Transporte urbano", "Snack tarde",
                "Recarga celular", "Parqueadero", "Propina", "Periódico", "Agua botella",
                "Empanada"
        };

        String[] comercios = {
                "Tienda Don Luis", "Cafetería Central", "Supermercado Express", "Panadería La Mejor",
                "Droguería Salud", "Papelería Escolar", "Restaurante El Sabor", "Mini Market",
                "Carnicería El Rey", "Fruver Natural"
        };

        String[] mediosPago = {
                "Efectivo", "Tarjeta Débito", "Tarjeta Crédito", "Nequi", "Daviplata", "PSE"
        };

        String[] ubicaciones = {
                "Bogotá", "Medellín", "Cali", "Barranquilla", "Bucaramanga",
                "Cartagena", "Pereira", "Manizales", "Cúcuta", "Ibagué"
        };

        Random random = new Random();
        List<Gastos> gastosList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            String descripcion = descripciones[random.nextInt(descripciones.length)];
            String comercio    = comercios[random.nextInt(comercios.length)];
            String medioPago   = mediosPago[random.nextInt(mediosPago.length)];
            String ubicacion   = ubicaciones[random.nextInt(ubicaciones.length)];

            LocalDate fecha = LocalDate.now().minusDays(random.nextInt(365));

            int valor   = (random.nextInt(39) + 1) * 500;
            int maximo  = valor + random.nextInt(5000);
            String minimo = String.valueOf(random.nextInt(500));

            String imagen = (random.nextInt(2) == 0) ? "imagen" + i + ".jpg" : null;

            Gastos g = new Gastos(
                    comercio,
                    descripcion,
                    fecha,
                    0,
                    imagen,
                    maximo,
                    medioPago,
                    minimo,
                    ubicacion,
                    valor
            );

            gastosList.add(g);
        }

        gastosRepositorio.saveAll(gastosList);
        System.out.println(">>> Gastos precargados correctamente");
    }
}