package com.example.MoneyFly.configuracion;

import com.example.MoneyFly.modelos.Usuario;
import com.example.MoneyFly.modelos.utils.Genero;
import com.example.MoneyFly.modelos.utils.TipoDocumento;
import com.example.MoneyFly.repositorios.IUsuariorepositorio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CargaDatosUsuario implements CommandLineRunner {

    private final IUsuariorepositorio usuarioRepositorio;

    public CargaDatosUsuario(IUsuariorepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public void run(String... args) {

        String[] nombre = {
                "Juan Perez", "Maria Gomez", "Carlos Ramirez", "Ana Torres", "Luis Martinez",
                "Sofia Herrera", "Pedro Castillo", "Valentina Diaz", "Jorge Suarez", "Laura Beltran"
        };

        String[] ocupaciones = {
                "Ingeniero", "Profesor", "Estudiante", "Medico", "Abogado",
                "Comerciante", "Administrador", "Diseñador", "Programador", "Contador"
        };

        TipoDocumento[] tiposDocumento = TipoDocumento.values();
        Genero[] generos = Genero.values();

        Random random = new Random();
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            String nombres = nombre[random.nextInt(10)];
            String ocupacion = ocupaciones[random.nextInt(ocupaciones.length)];
            TipoDocumento tipoDoc = tiposDocumento[random.nextInt(tiposDocumento.length)];
            Genero genero = generos[random.nextInt(generos.length)];
            int edad = 18 + random.nextInt(40); // entre 18 y 58

            String documento = String.valueOf(10000000 + random.nextInt(90000000));
            String correo = "usuario" + i + "@correo.com";
            String telefono = "300" + (1000000 + random.nextInt(8999999));
            String contraseña = "pass" + i;

            Usuario u = new Usuario(
                    contraseña,
                    correo,
                    documento,
                    edad,
                    genero,
                    0, // el ID se autogenera
                    nombres,
                    ocupacion,
                    telefono,
                    tipoDoc
            );

            usuarios.add(u);
        }

        usuarioRepositorio.saveAll(usuarios);
        System.out.println(">>> Usuarios precargados correctamente");
    }
}