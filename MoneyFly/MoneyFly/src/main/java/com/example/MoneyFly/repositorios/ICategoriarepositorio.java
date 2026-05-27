package com.example.MoneyFly.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.modelos.Usuario;

public interface ICategoriarepositorio
extends JpaRepository<Categoria, Integer> {

    List<Categoria> findByUsuario(Usuario usuario);

}