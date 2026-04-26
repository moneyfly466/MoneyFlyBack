package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.servicios.CategoriaServicios;

@RestController
@RequestMapping("/apimoneyfly/v1/categorias")
public class ControladorCategoria {

    @Autowired
    private CategoriaServicios servicio;

    // Funcion controladora del servicio de guardar categoria
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Categoria datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_categoria(datos)
        );
    }

    // Funcion controladora del servicio de listar todas las categorias
    @GetMapping
    public ResponseEntity<?> controladorListarTodo() {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_categorias()
        );
    }
}