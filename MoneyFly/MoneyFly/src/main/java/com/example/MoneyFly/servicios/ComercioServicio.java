package com.example.MoneyFly.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.repositorios.IComerciorepositorio;

@Service
public class ComercioServicio {

    @Autowired
    private IComerciorepositorio repositorio;

    // Guardar comercio
    public Comercio guardar_comercio(Comercio datos) {

        if (datos.getNombre() == null || datos.getNombre().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es obligatorio"
            );
        }

        if (datos.getActividad() == null || datos.getActividad().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La actividad del comercio es obligatoria"
            );
        }

        return repositorio.save(datos);
    }

    // Listar todos los comercios
    public List<Comercio> listar_comercios() {
        return repositorio.findAll();
    }

    // Modificar comercio por ID
    public Comercio modificar_Comercio(Integer id, Comercio datos) {

        Comercio comercioExistente = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado con id: " + id
            ));

        comercioExistente.setNit(datos.getNit());
        comercioExistente.setNombre(datos.getNombre());
        comercioExistente.setActividad(datos.getActividad());
        comercioExistente.setContacto(datos.getContacto());
        comercioExistente.setTotalGastado(datos.getTotalGastado());
        comercioExistente.setUbicacion(datos.getUbicacion());
        comercioExistente.setGastoPromedio(datos.getGastoPromedio());
        comercioExistente.setSectorComercial(datos.getSectorComercial());
        comercioExistente.setFechaGasto(datos.getFechaGasto());

        return repositorio.save(comercioExistente);
    }

    // Eliminar comercio por ID
    public String eliminar_comercio(Integer id) {

        repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado con id: " + id
            ));

        repositorio.deleteById(id);
        return "Comercio con id " + id + " eliminado correctamente";
    }

    // Buscar comercio por ID
    public Comercio buscar_comercio_por_id(Integer id) {

        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Comercio no encontrado con id: " + id
            ));
    }
}