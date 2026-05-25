package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> e974001 (se crea el controlador se comercio)
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> 45c5092 (se suben cambion en la carpeta configuracion)
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 5274e9e (Se sube todo lo de comercio)
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.servicios.ComercioServicio;

@RestController
<<<<<<< HEAD
@RequestMapping("/apimoneyfly/v1/comercios")
=======
@RequestMapping("/apimoneyfly/v1/comercio")
>>>>>>> e974001 (se crea el controlador se comercio)
public class ControladorComercio {

    @Autowired
    private ComercioServicio servicio;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
    // Guardar un comercio nuevo
>>>>>>> 5274e9e (Se sube todo lo de comercio)
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.guardar_comercio(datos));
    }

    // Listar todos los comercios
    @GetMapping
    public ResponseEntity<?> controladorlistar() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_comercios());
    }

    // Modificar un comercio por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.modificar_Comercio(id, datos));
    }

    // Eliminar un comercio por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controladorEliminar(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_comercio(id));
    }

    // Buscar un comercio específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> controladorBuscarPorId(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_comercio_por_id(id));
    }
<<<<<<< HEAD
}
>>>>>>> e974001 (se crea el controlador se comercio)
=======
}
>>>>>>> 45c5092 (se suben cambion en la carpeta configuracion)
