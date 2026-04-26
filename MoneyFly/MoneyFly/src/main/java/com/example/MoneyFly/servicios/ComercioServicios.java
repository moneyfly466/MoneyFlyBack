package com.example.MoneyFly.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.repositorios.IComerciorepositorio;

@Service
public class ComercioServicios {

    // Inyección de dependencias al repositorio comercio
    @Autowired
    private IComerciorepositorio repositorio;

    // Función para guardar un comercio
    public Comercio guardarComercio(Comercio datosComercio) {
        // Validar los campos del modelo según la lógica del negocio

        // Validar que el comercio tenga nombre
        if (datosComercio.getNombre() == null || datosComercio.getNombre().isEmpty() || datosComercio.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es obligatorio"
            );
        }

        // Validar que la actividad no esté vacía
        if (datosComercio.getActividad() == null || datosComercio.getActividad().isEmpty() || datosComercio.getActividad().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La actividad del comercio es obligatoria"
            );
        }

        // Validar que el sector comercial no esté vacío
        if (datosComercio.getSectorComercial() == null || datosComercio.getSectorComercial().isEmpty() || datosComercio.getSectorComercial().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El sector comercial es obligatorio"
            );
        }

        // Si pasa todas las validaciones, guardar los datos
        return repositorio.save(datosComercio);
    }

    // Función para listar todos los comercios
    public List<Comercio> listarComercios() {
        return repositorio.findAll();
    }

    // Función para buscar un comercio por ID
    public Optional<Comercio> buscarComercioPorId(int id) {
        return repositorio.findById(id);
    }

    // Función para buscar comercios por nombre
    public List<Comercio> buscarComerciosPorNombre(String nombre) {
        return repositorio.finByNombres(nombre);
    }

    // Función para buscar comercios por actividad
    public List<Comercio> buscarComerciosPorActividad(String actividad) {
        return repositorio.finByActividad(actividad);
    }

    // Función para modificar un comercio
    public Comercio modificarComercio(int id, Comercio datosComercio) {
        Optional<Comercio> comercioExistente = repositorio.findById(id);
        if (comercioExistente.isPresent()) {
            Comercio comercio = comercioExistente.get();
            // Actualizar campos
            comercio.setNombre(datosComercio.getNombre());
            comercio.setActividad(datosComercio.getActividad());
            comercio.setContacto(datosComercio.getContacto());
            comercio.setTotalGastado(datosComercio.getTotalGastado());
            comercio.setUbicacion(datosComercio.getUbicacion());
            comercio.setGastoPromedio(datosComercio.getGastoPromedio());
            comercio.setSectorComercial(datosComercio.getSectorComercial());
            comercio.setFechaGasto(datosComercio.getFechaGasto());
            return repositorio.save(comercio);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Comercio no encontrado"
            );
        }
    }

    // Función para eliminar un comercio
    public void eliminarComercio(int id) {
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Comercio no encontrado"
            );
        }
    }

}