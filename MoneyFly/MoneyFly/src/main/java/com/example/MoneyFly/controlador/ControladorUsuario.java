package com.example.MoneyFly.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MoneyFly.modelos.Usuario;
import com.example.MoneyFly.servicios.UsuarioServicios;

@RestController
@RequestMapping("/apimoneyfly/v1/usuarios")
public class ControladorUsuario {

    @Autowired
    UsuarioServicios servicio;

    //funcion controladora para el servicio de guardar usuario 
    public ResponseEntity <?> controladorGuardar(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.guardar_usuario(datos)
        );
    }

    //funcion controladora para el servicio de listar todos los usuarios

    public ResponseEntity <?> controladorlistar(){
        return ResponseEntity.status(HttpStatus.OK).body(
            servicio.listar_Usuarios()
        );
    }
}
