package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyFly.modelos.Gastos;
import com.example.MoneyFly.servicios.GastosServicios;

@RestController
@RequestMapping("/apimoneyfly/v1/gastos")
public class ControladorGasto {

    @Autowired
    private GastosServicios servicio;

    // Guardar gasto para un usuario específico
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorGuardar(
            @PathVariable Integer usuarioId,
            @RequestBody Gastos datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_gasto(datos, usuarioId)
        );
    }

    // Listar gastos de un usuario específico
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorListarTodo(@PathVariable Integer usuarioId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_gastos(usuarioId)
        );
    }

    // Modificar gasto por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(
            @PathVariable Integer id,
            @RequestBody Gastos datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.modificar_gasto(id, datos)
        );
    }

    // Eliminar gasto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.eliminar_gasto(id)
        );
    }

    // Buscar gasto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.buscar_gasto_por_id(id)
        );
    }
}
