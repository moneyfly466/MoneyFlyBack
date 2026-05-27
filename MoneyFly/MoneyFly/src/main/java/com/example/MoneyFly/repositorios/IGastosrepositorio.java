package com.example.MoneyFly.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.modelos.Gastos;
import com.example.MoneyFly.modelos.Usuario;

public interface IGastosrepositorio extends JpaRepository<Gastos, Integer> {

    // Buscar gastos por usuario
    List<Gastos> findByUsuario(Usuario usuario);

    // ✅ Buscar gastos por categoria — necesario para desvincular al eliminar categoria
    List<Gastos> findByCategoria(Categoria categoria);
}