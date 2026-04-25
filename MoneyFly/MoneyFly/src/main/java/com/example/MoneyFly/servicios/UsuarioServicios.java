package com.example.MoneyFly.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.MoneyFly.modelos.Usuario;
import com.example.MoneyFly.modelos.repositorios.IUsuariorepositorio;

@Service
public class UsuarioServicios {

    //inyeccion de dependecias al repositorio usuario 

    @Autowired
    private IUsuariorepositorio repositorio;

    //se programa una funcion por cada servicio que voy a ofecer

    //funcion para guardar un usuario 
    public Usuario guardar_usuario(Usuario datosUsuario){
        //validar los campos del modelo segun la logica del negocio

        //validar que el usuario me mande sus nombres 
        if (datosUsuario.getNombres()==null || datosUsuario.getNombres().isEmpty() || datosUsuario.getNombres().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario,el nombre de usuario es obligatorio"
            );
        }
        //validar documento tenga al menos 6 caracteres 
        if (datosUsuario.getDocumento().length()<6) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario el documento tiene que al menos 6 carateres"
            );
        }
        //si paso todas las validaciones
        //intentare activar el guardado de los datos
        return repositorio.save(datosUsuario);
    }
    

    //funcion para listar todos los usuarios 
    public List<Usuario> listar_Usuarios(){
        return repositorio.findAll();
    }

    //funcion para modificar un usuario 

    //funcion para eliminar un usuario 

    //funcion para buscar un usuario por id 

    //funcion para buscar por edad 


}
