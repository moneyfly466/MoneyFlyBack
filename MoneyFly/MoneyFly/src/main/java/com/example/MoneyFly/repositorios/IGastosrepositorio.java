package com.example.MoneyFly.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyFly.modelos.Gastos;

@Repository
public interface IGastosrepositorio extends JpaRepository <Gastos,Integer> {


}
