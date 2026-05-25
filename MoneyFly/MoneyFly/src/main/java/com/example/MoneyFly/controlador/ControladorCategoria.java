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

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.servicios.CategoriaServicios;

@RestController
@RequestMapping("/apimoneyfly/v1/categorias")
public class ControladorCategoria {

    @Autowired
    CategoriaServicios servicio;

    // Guardar categoria
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Categoria datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.guardar_categoria(datos));
    }

    // Listar todas las categorias
    @GetMapping
    public ResponseEntity<?> controladorListar() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_categorias());
    }

    // Modificar categoria
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Categoria datos) {
        return ResponseEntity.ok(servicio.modificar_categoria(id, datos));
    }

    // Eliminar categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_categoria(id));
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_categoria_por_id(id));
    }
}