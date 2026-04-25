package com.example.MoneyFly.modelos.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyFly.modelos.Comercio;

@Repository
public interface IComerciorepositorio extends JpaRepository<Comercio, Integer> {

    // Consultas personalizadas 

}