package com.example.MoneyFly.configuracion;

import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.repositorios.IComerciorepositorio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CargaDatosComercio implements CommandLineRunner {

    private final IComerciorepositorio comercioRepositorio;

    public CargaDatosComercio(IComerciorepositorio comercioRepositorio) {
        this.comercioRepositorio = comercioRepositorio;
    }

    @Override
    public void run(String... args) {

        String[] nombresComercios = {
                "Supermercado La Economía", "Panadería El Trigal", "Tienda Don Pepe", "Farmacia Vida Sana",
                "Restaurante Buen Sabor", "Cafetería La Esquina", "Zapatería El Paso Firme",
                "Papelería Mundo Útil", "Centro Tecnológico Byte", "Heladería Dulce Nieve"
        };

        String[] actividades = {
                "Venta de alimentos", "Repostería", "Venta minorista", "Farmacia", "Restaurante",
                "Cafetería", "Calzado", "Papelería", "Tecnología", "Heladería"
        };

        String[] sectores = {
                "Comida", "Salud", "Retail", "Tecnología", "Servicios", "Moda"
        };

        String[] ubicaciones = {
                "Medellín", "Bello", "Envigado", "Itagüí", "Sabaneta"
        };

        Random random = new Random();
        List<Comercio> comercios = new ArrayList<>();

        for (int i = 0; i < 40; i++) {

            String nombre = nombresComercios[random.nextInt(nombresComercios.length)];
            String actividad = actividades[random.nextInt(actividades.length)];
            String sector = sectores[random.nextInt(sectores.length)];
            String ubicacion = ubicaciones[random.nextInt(ubicaciones.length)];

            String nit = String.valueOf(900000000 + random.nextInt(99999999));
            String contacto = "300" + (1000000 + random.nextInt(8999999));

            int totalGastado = 10000 + random.nextInt(900000); // entre 10 mil y 900 mil
            int gastoPromedio = totalGastado / (5 + random.nextInt(15)); // basado en consumos aleatorios

            LocalDate fechaGasto = LocalDate.now().minusDays(random.nextInt(365));

            Comercio c = new Comercio(
                    0, // ID autogenerado
                    nit,
                    nombre,
                    actividad,
                    contacto,
                    totalGastado,
                    ubicacion,
                    gastoPromedio,
                    sector,
                    fechaGasto
            );

            comercios.add(c);
        }

        comercioRepositorio.saveAll(comercios);
        System.out.println(">>> Comercios precargados correctamente");
    }
}