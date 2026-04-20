package com.example.MoneyFly.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyFly.modelos.Categoria;

@Repository
public interface ICategoriarepositorio extends JpaRepository<Categoria, Integer> {

    // buscar por nombre
    List<Categoria> findByNombre(String nombre);

    // buscar por responsable
    List<Categoria> findByResponsable(String responsable);

    // buscar por frecuencia
    List<Categoria> findByFrecuencia(String frecuencia);

}