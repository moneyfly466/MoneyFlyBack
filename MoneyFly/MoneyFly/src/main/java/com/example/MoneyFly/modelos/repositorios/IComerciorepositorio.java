package com.example.MoneyFly.modelos.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyFly.modelos.Comercio;

@Repository
public interface IComerciorepositorio extends JpaRepository<Comercio, Integer> {

    // Consultas personalizadas basadas en los atributos del modelo Comercio

    // Buscar por nombre
    List<Comercio> findByNombre(String nombre);

    // Buscar por actividad
    List<Comercio> findByActividad(String actividad);

    // Buscar por sector comercial
    List<Comercio> findBySectorComercial(String sectorComercial);

    // Buscar por NIT
    Optional<Comercio> findByNit(String nit);

    // Buscar por ubicación
    List<Comercio> findByUbicacion(String ubicacion);

}