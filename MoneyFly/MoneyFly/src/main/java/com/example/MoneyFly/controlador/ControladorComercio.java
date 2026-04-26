package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.servicios.ComercioServicios;

@RestController
@RequestMapping("/apimoneyfly/v1/comercios")
public class ControladorComercio {

    @Autowired
    private ComercioServicios servicio;

    // Función controladora para el servicio de guardar comercio
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardarComercio(datos)
        );
    }

    // Función controladora para el servicio de listar todos los comercios
    @GetMapping
    public ResponseEntity<?> controladorListarTodo() {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listarComercios()
        );
    }
}