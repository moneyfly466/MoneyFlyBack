package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.servicios.CategoriaServicios;

@RestController
@RequestMapping("/apimoneyfly/v1/categorias")
public class ControladorCategoria {

    @Autowired
    private CategoriaServicios servicio;

    // Crear categoría para un usuario
    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorGuardar(
            @PathVariable Integer usuarioId,
            @RequestBody Categoria datos) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicio.guardar_categoria(datos, usuarioId));
    }

    // Listar categorías de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> controladorListar(
            @PathVariable Integer usuarioId) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicio.listar_categorias(usuarioId));
    }

    // Modificar categoría por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(
            @PathVariable Integer id,
            @RequestBody Categoria datos) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicio.modificar_categoria(id, datos));
    }

    // Eliminar categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(
            @PathVariable Integer id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicio.eliminar_categoria(id));
    }

    // Buscar categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(
            @PathVariable Integer id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(servicio.buscar_categoria_por_id(id));
    }
}