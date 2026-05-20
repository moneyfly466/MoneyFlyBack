package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.servicios.ComercioServicio;


@RestController
@RequestMapping("/apimoneyfly/v1/comercios")
public class ControladorComercio {

    @Autowired
    ComercioServicio servicio;

    // Guardar un comercio
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Comercio datos) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardar_comercio(datos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al guardar: " + e.getMessage());
        }
    }

    // Listar todos los comercios
    @GetMapping
    public ResponseEntity<?> controladorListar() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_comercios());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_por_id(id));
    }

    // Modificar comercio
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_comercio(id, datos));
    }

    // Eliminar comercio
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        if (servicio.eliminar_comercio(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el comercio");
        }
    }
}