package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.servicios.ComercioServicios;

@RestController
@RequestMapping("/apimoneyfly/v1/comercio")
public class ControladorComercio {

    @Autowired
    private ComercioServicios servicio;

    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Comercio datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_comercio(datos)
        );
    }

    public ResponseEntity <?> controladorlistar(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_comercios()
        );
    }
}
