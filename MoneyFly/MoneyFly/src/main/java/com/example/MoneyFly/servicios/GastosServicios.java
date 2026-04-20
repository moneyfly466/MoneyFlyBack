package com.example.MoneyFly.modelos.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.MoneyFly.modelos.Gastos;
import com.example.MoneyFly.modelos.repositorios.IGastosrepositorio;


@Service
public class GastosServicios {

    @Autowired
    private IGastosrepositorio repositorio;

    //funcion para guardar un gasto
    public Gastos guardar_gasto(Gastos datosGasto){
        //validar los campos del modelo segun la logica del negocio

        //validar que el gasto tenga un valor mayor a 0
        if (datosGasto.getValor()<=0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario el valor del gasto tiene que ser mayor a 0"
            );
        }

        // validar si el usuario agrego un descripción del gasto
        if (datosGasto.getDescripcion()==null || datosGasto.getDescripcion().isEmpty() || datosGasto.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario la descripción del gasto es obligatoria"
            );
        }

        //si paso todas las validaciones
        //intentare activar el guardado de los datos
        return repositorio.save(datosGasto);
    }

    //funcion para listar todos los gastos
    public List<Gastos> listar_gastos(){
        return repositorio.findAll();

    }

}
    





