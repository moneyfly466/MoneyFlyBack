package com.example.MoneyFly.servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.MoneyFly.modelos.Gastos;
import com.example.MoneyFly.repositorios.IGastosrepositorio;


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

      //funcion para modificar un gasto 
        public List<Gastos> modificar_gasto(Integer id , Gastos datosGasto){
            Optional<Gastos> gasto_existente = repositorio.findById(id);
            if (gasto_existente.isEmpty()) {
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "apreciado usuario el gasto con id "+id+" no existe"
                );
            }else{
                Gastos gasto_modificado = gasto_existente.get();
                gasto_modificado.setDescripcion(datosGasto.getDescripcion());
                gasto_modificado.setFecha(datosGasto.getFecha());
                gasto_modificado.setValor(datosGasto.getValor());
                gasto_modificado.setImagen(datosGasto.getImagen());
                gasto_modificado.setComercio(datosGasto.getComercio());
                gasto_modificado.setMedioPago(datosGasto.getMedioPago());
                gasto_modificado.setUbicacion(datosGasto.getUbicacion());
                repositorio.save(gasto_modificado);
                return repositorio.findAll();
            }
        }

    //funcion para eliminar un gasto 
    public boolean eliminar_gasto(Integer id){
        
        Optional<Gastos> gasto_existente = repositorio.findById(id);
        if (gasto_existente.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario el gasto con id "+id+" no existe"
            );
        }else{
            repositorio.deleteById(id);
            return true;
        }
    
    
        
    }


    //funcion para buscar un gasto por id 
    public Gastos buscar_gasto_por_id(Integer id){
        
        Optional<Gastos> gasto_existente = repositorio.findById(id);
        if (gasto_existente.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "apreciado usuario el gasto con id "+id+" no existe"
            );
        }else{
            return gasto_existente.get();
        }
    }



}
    





