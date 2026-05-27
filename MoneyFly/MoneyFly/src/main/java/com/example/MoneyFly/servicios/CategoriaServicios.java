package com.example.MoneyFly.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.modelos.Usuario;
import com.example.MoneyFly.repositorios.ICategoriarepositorio;
import com.example.MoneyFly.repositorios.IUsuariorepositorio;

@Service
public class CategoriaServicios {

    @Autowired
    private ICategoriarepositorio repositorio;

    @Autowired
    private IUsuariorepositorio usuarioRepositorio;

    // Guardar categoria vinculada al usuario
    public Categoria guardar_categoria(Categoria datos, Integer usuarioId) {

        Usuario usuario = usuarioRepositorio.findById(usuarioId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario con id " + usuarioId + " no existe"
            ));

        datos.setUsuario(usuario);
        return repositorio.save(datos);
    }

    // Listar categorias filtradas por usuario
    public List<Categoria> listar_categorias(Integer usuarioId) {

        Usuario usuario = usuarioRepositorio.findById(usuarioId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario con id " + usuarioId + " no existe"
            ));

        return repositorio.findByUsuario(usuario);
    }

    // Modificar categoria
    public Categoria modificar_categoria(Integer id, Categoria datos) {

        Categoria categoriaExistente = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoria no encontrada con id: " + id
            ));

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

    // ✅ Eliminar categoria — desvincula gastos antes de borrar
    @Transactional
    public String eliminar_categoria(Integer id) {

        Categoria categoria = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoria no encontrada con id: " + id
            ));

        // Desvincula todos los gastos asociados (pone fk_Categoria en null)
        if (categoria.getGastos() != null) {
            categoria.getGastos().forEach(g -> g.setCategoria(null));
        }

        repositorio.delete(categoria);
        return "Categoria con id " + id + " eliminada correctamente";
    }

    // Buscar categoria por id
    public Categoria buscar_categoria_por_id(Integer id) {

        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Categoria no encontrada con id: " + id
            ));
    }
}