package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> e974001 (se crea el controlador se comercio)
=======
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> 45c5092 (se suben cambion en la carpeta configuracion)
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Comercio datos) {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_comercio(datos)
        );
    }

    @GetMapping
    public ResponseEntity<?> controladorListar() {
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_comercios()
        );
    }
<<<<<<< HEAD
}
>>>>>>> e974001 (se crea el controlador se comercio)
=======
}
>>>>>>> 45c5092 (se suben cambion en la carpeta configuracion)
