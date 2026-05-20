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

import com.example.MoneyFly.modelos.Usuario;
import com.example.MoneyFly.servicios.UsuarioServicios;

@RestController
@RequestMapping("/apimoneyfly/v1/usuarios")
public class ControladorUsuario {

    @Autowired
    UsuarioServicios servicio;

    //funcion controladora para el servicio de guardar usuario 
    @PostMapping
    public ResponseEntity <?> controladorGuardar(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.guardar_usuario(datos));
    }

    //funcion controladora para el servicio de listar todos los usuarios

    @GetMapping
    public ResponseEntity <?> controladorlistar(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.listar_Usuarios());
    }

    //controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> controladorModificar(@PathVariable Integer id, @RequestBody Usuario datos){
        return ResponseEntity.ok(servicio.modificar_Usuario(id, datos));
    }

    //controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> controaldorEliminar(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.eliminar_usuario(id));
    }

    //control para buscar por id 
    @GetMapping("/{id}")
    public ResponseEntity<?> controaldorBuscarPorId(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.buscar_usuario_por_id(id));
    }
}
