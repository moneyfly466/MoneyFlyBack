package com.example.MoneyFly.configuracion;

import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.repositorios.IComerciorepositorio;
import org.springframework.boot.CommandLineRunner;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Order(2)
public class CargaDatosComercio implements CommandLineRunner {

    private final IComerciorepositorio comercioRepositorio;

    public CargaDatosComercio(IComerciorepositorio comercioRepositorio) {
        this.comercioRepositorio = comercioRepositorio;
    }

    @Override
    public void run(String... args) {

        String[] nombres = {
            "Tienda ABC", "Supermercado XYZ", "Tech Store",
            "Farmacia Vida", "Ropa Express", "Restaurante El Buen Sabor",
            "Librería Central", "Ferretería El Tornillo", "Gym FitLife", "Café Aroma"
        };

        String[] actividades = {
            "venta", "servicios", "tecnologia", "salud", "retail"
        };

        String[] ubicaciones = {
            "Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena"
        };

        String[] sectores = {
            "comercial", "industrial", "tecnologico", "salud", "retail"
        };

        String[] nits = {
            "900123456", "901234567", "902345678", "903456789", "904567890"
        };

        Random random = new Random();
        List<Comercio> comercios = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            int totalGastado  = 5000  + random.nextInt(45000);
            int gastoPromedio = 1000  + random.nextInt(totalGastado);
            LocalDate fecha   = LocalDate.of(2026, 1, 1)
                                         .plusDays(random.nextInt(60));

            Comercio c = new Comercio(
                0,
                nits[random.nextInt(nits.length)],
                nombres[random.nextInt(nombres.length)],
                actividades[random.nextInt(actividades.length)],
                "contacto" + i + "@correo.com",
                totalGastado,
                ubicaciones[random.nextInt(ubicaciones.length)],
                gastoPromedio,
                sectores[random.nextInt(sectores.length)],
                fecha
            );

            comercios.add(c);
        }

        comercioRepositorio.saveAll(comercios);
        System.out.println(">>> Comercios precargados correctamente");
    }
}