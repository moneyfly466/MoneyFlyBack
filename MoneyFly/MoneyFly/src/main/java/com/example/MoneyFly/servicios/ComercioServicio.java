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

    // Crear un comercio
    public Comercio guardar_comercio(Comercio datos) {
        return repositorio.save(datos);
    }

    // Listar todos los comercios
    public List<Comercio> listar_comercios() {
        return repositorio.findAll();
    }

    // Actualizar un comercio existente
    public Comercio modificar_Comercio(Integer id, Comercio datos) {
        Comercio existente = repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "❌ Comercio con ID " + id + " no encontrado"
                ));

        // Actualizar campos
        existente.setNit(datos.getNit());
        existente.setNombre(datos.getNombre());
        existente.setActividad(datos.getActividad());
        existente.setContacto(datos.getContacto());
        existente.setTotalGastado(datos.getTotalGastado());
        existente.setUbicacion(datos.getUbicacion());
        existente.setGastoPromedio(datos.getGastoPromedio());
        existente.setSectorComercial(datos.getSectorComercial());
        existente.setFechaGasto(datos.getFechaGasto());

        return repositorio.save(existente);
    }

    // Eliminar un comercio por ID
    public String eliminar_comercio(Integer id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "❌ No se puede eliminar. Comercio con ID " + id + " no existe"
            );
        }

        repositorio.deleteById(id);
        return "✅ Comercio eliminado correctamente";
    }

    // Buscar comercio por ID
    public Comercio buscar_comercio_por_id(Integer id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "❌ Comercio con ID " + id + " no encontrado"
                ));
    }
}