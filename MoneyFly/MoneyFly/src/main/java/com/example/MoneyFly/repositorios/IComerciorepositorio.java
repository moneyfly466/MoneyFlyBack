package com.example.MoneyFly.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyFly.modelos.Comercio;

@Repository
public interface IComerciorepositorio extends JpaRepository<Comercio, Integer> {

    //buscar por nombre 
    List<Comercio> finByNombres(String Nombres);

    List<Comercio> finByActividad (String Actividad);

    // Consultas personalizadas 

}