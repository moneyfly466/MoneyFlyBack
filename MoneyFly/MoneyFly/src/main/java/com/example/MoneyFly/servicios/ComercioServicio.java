package com.example.MoneyFly.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MoneyFly.modelos.Comercio;
import com.example.MoneyFly.repositorios.IComerciorepositorio;

@Service
public class ComercioServicio {

    @Autowired
    IComerciorepositorio repositorio;

    public Comercio guardar_comercio(Comercio datos) {
        return repositorio.save(datos);
    }

    public List<Comercio> listar_comercios() {
        return repositorio.findAll();
    }

    public Optional<Comercio> buscar_por_id(Integer id) {
        return repositorio.findById(id);
    }

    public Comercio modificar_comercio(Integer id, Comercio datosNuevos) {
        if (repositorio.existsById(id)) {
            datosNuevos.setId(id);
            return repositorio.save(datosNuevos);
        }
        return null; // O lanzar una excepción personalizada
    }

    public boolean eliminar_comercio(Integer id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}