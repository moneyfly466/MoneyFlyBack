package com.example.MoneyFly.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyFly.modelos.Gastos;
import com.example.MoneyFly.servicios.GastosServicios;

@RestController
@RequestMapping("/moneyflyapi/v1/gastos")
public class GastoControlador {

    //Inyectar el servicio correspondiente
    @Autowired
    private GastosServicios servicio;

    //Para cada servicio ofrecido se debe progarmar una funcion
    //esa funcion recibira las peticiones del pedido y respondera

    //funcion controladora del servicio de guardar gastos
    @PostMapping
    public ResponseEntity<?> controladorGuardar(@RequestBody Gastos datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_gasto(datos)
        );
    }

    //funcion controladora del servicio de listar todos los gastos
    @GetMapping
    public ResponseEntity<?>controladorListarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_gastos()
        );
    }


}