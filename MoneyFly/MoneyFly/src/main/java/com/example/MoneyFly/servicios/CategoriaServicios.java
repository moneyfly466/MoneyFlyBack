package com.example.MoneyFly.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.repositorios.ICategoriarepositorio;

@Service
public class CategoriaServicios {

    @Autowired
    ICategoriarepositorio repositorio;

    // Guardar categoria
    public Categoria guardar_categoria(Categoria datos) {
        return repositorio.save(datos);
    }

    // Listar todas las categorias
    public List<Categoria> listar_categorias() {
        return repositorio.findAll();
    }

    // Modificar categoria
    public Categoria modificar_categoria(Integer id, Categoria datos) {
        Categoria categoriaExistente = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + id));

        categoriaExistente.setNombre(datos.getNombre());
        categoriaExistente.setFechaCreacion(datos.getFechaCreacion());
        categoriaExistente.setResponsable(datos.getResponsable());
        categoriaExistente.setJustificacion(datos.getJustificacion());
        categoriaExistente.setLimiteGastos(datos.getLimiteGastos());
        categoriaExistente.setGastosActuales(datos.getGastosActuales());
        categoriaExistente.setFrecuencia(datos.getFrecuencia());
        categoriaExistente.setAlertGastos(datos.getAlertGastos());
        categoriaExistente.setMetodoPagoPreferido(datos.getMetodoPagoPreferido());

        return repositorio.save(categoriaExistente);
    }

    // Eliminar categoria
    public String eliminar_categoria(Integer id) {
        repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + id));

        repositorio.deleteById(id);
        return "Categoria con id " + id + " eliminada correctamente";
    }

    // Buscar categoria por id
    public Categoria buscar_categoria_por_id(Integer id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada con id: " + id));
    }
}