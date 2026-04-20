package com.example.MoneyFly.modelos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.modelos.repositorios.ICategoriarepositorio;

@Service
public class CategoriaServicios {

    //inyeccion de dependencias al repositorio categoria

    @Autowired
    private ICategoriarepositorio repositorio;

    //se programa una funcion por cada servicio que voy a ofrecer

    //funcion para guardar una categoria
    public Categoria guardar_categoria(Categoria datosCategoria){
        //validar los campos del modelo segun la logica del negocio

        //validar que el nombre no este vacio
        if (datosCategoria.getNombre()==null || datosCategoria.getNombre().isEmpty() || datosCategoria.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario, el nombre de la categoria es obligatorio"
            );
        }
        //validar que el responsable no este vacio
        if (datosCategoria.getResponsable()==null || datosCategoria.getResponsable().isEmpty() || datosCategoria.getResponsable().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario, el responsable de la categoria es obligatorio"
            );
        }
        //validar que el limite de gastos sea mayor a 0
        if (datosCategoria.getLimiteGastos()<=0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario, el limite de gastos debe ser mayor a 0"
            );
        }
        //si paso todas las validaciones
        //intentare activar el guardado de los datos
        return repositorio.save(datosCategoria);
    }

    //funcion para listar todas las categorias
    public List<Categoria> listar_categorias(){
        return repositorio.findAll();
    }

}