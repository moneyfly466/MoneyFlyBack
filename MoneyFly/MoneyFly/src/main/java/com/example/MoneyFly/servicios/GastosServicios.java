package com.example.MoneyFly.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.MoneyFly.modelos.Categoria;
import com.example.MoneyFly.modelos.Gastos;
import com.example.MoneyFly.modelos.Usuario;
import com.example.MoneyFly.repositorios.ICategoriarepositorio;
import com.example.MoneyFly.repositorios.IGastosrepositorio;
import com.example.MoneyFly.repositorios.IUsuariorepositorio;

@Service
public class GastosServicios {

    @Autowired
    private IGastosrepositorio repositorio;

    @Autowired
    private IUsuariorepositorio usuarioRepositorio;

    // ✅ NUEVO: necesario para actualizar gastosActuales
    @Autowired
    private ICategoriarepositorio categoriaRepositorio;

    // =========================
    // GUARDAR GASTO
    // =========================
    public Gastos guardar_gasto(Gastos datosGasto, Integer usuarioId) {

        if (datosGasto.getValor() == null || datosGasto.getValor() <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El valor del gasto tiene que ser mayor a 0"
            );
        }

        if (datosGasto.getDescripcion() == null || datosGasto.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La descripcion del gasto es obligatoria"
            );
        }

        if (datosGasto.getComercio() == null || datosGasto.getComercio().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es obligatorio"
            );
        }

        // Buscar y asociar usuario
        Usuario usuario = usuarioRepositorio.findById(usuarioId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario con id " + usuarioId + " no existe"
            ));
        datosGasto.setUsuario(usuario);

        // ✅ Si viene categoriaId, asociar la categoria y sumar el valor
        if (datosGasto.getCategoria() != null && datosGasto.getCategoria().getId() > 0) {
            Categoria categoria = categoriaRepositorio
                .findById(datosGasto.getCategoria().getId())
                .orElse(null);

            if (categoria != null) {
                // Sumar el valor del gasto a gastosActuales de la categoria
                categoria.setGastosActuales(
                    categoria.getGastosActuales() + datosGasto.getValor()
                );
                categoriaRepositorio.save(categoria);
                datosGasto.setCategoria(categoria);
            }
        }

        return repositorio.save(datosGasto);
    }

    // =========================
    // LISTAR GASTOS
    // =========================
    public List<Gastos> listar_gastos(Integer usuarioId) {

        Usuario usuario = usuarioRepositorio.findById(usuarioId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El usuario con id " + usuarioId + " no existe"
            ));

        return repositorio.findByUsuario(usuario);
    }

    // =========================
    // MODIFICAR GASTO
    // =========================
    public Gastos modificar_gasto(Integer id, Gastos datosGasto) {

        Gastos gastoExistente = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El gasto con id " + id + " no existe"
            ));

        if (datosGasto.getValor() == null || datosGasto.getValor() <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El valor del gasto tiene que ser mayor a 0"
            );
        }

        if (datosGasto.getDescripcion() == null || datosGasto.getDescripcion().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La descripcion del gasto es obligatoria"
            );
        }

        if (datosGasto.getComercio() == null || datosGasto.getComercio().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre del comercio es obligatorio"
            );
        }

        // ✅ Si cambia la categoria o el valor, actualizar gastosActuales
        Categoria categoriaAnterior = gastoExistente.getCategoria();
        int valorAnterior           = gastoExistente.getValor();

        // Restar el valor anterior de la categoria anterior
        if (categoriaAnterior != null) {
            int nuevoActual = categoriaAnterior.getGastosActuales() - valorAnterior;
            categoriaAnterior.setGastosActuales(Math.max(nuevoActual, 0));
            categoriaRepositorio.save(categoriaAnterior);
        }

        // Actualizar campos del gasto
        gastoExistente.setDescripcion(datosGasto.getDescripcion());
        gastoExistente.setFecha(datosGasto.getFecha());
        gastoExistente.setValor(datosGasto.getValor());
        gastoExistente.setImagen(datosGasto.getImagen());
        gastoExistente.setComercio(datosGasto.getComercio());
        gastoExistente.setMedioPago(datosGasto.getMedioPago());
        gastoExistente.setUbicacion(datosGasto.getUbicacion());
        gastoExistente.setMaximo(datosGasto.getMaximo());
        gastoExistente.setMinimo(datosGasto.getMinimo());

        // ✅ Asociar nueva categoria y sumar el nuevo valor
        if (datosGasto.getCategoria() != null && datosGasto.getCategoria().getId() > 0) {
            Categoria categoriaNueva = categoriaRepositorio
                .findById(datosGasto.getCategoria().getId())
                .orElse(null);

            if (categoriaNueva != null) {
                categoriaNueva.setGastosActuales(
                    categoriaNueva.getGastosActuales() + datosGasto.getValor()
                );
                categoriaRepositorio.save(categoriaNueva);
                gastoExistente.setCategoria(categoriaNueva);
            }
        } else {
            // Si no viene categoria, limpiar la asociacion
            gastoExistente.setCategoria(null);
        }

        return repositorio.save(gastoExistente);
    }

    // =========================
    // ELIMINAR GASTO
    // =========================
    public boolean eliminar_gasto(Integer id) {

        Gastos gasto = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El gasto con id " + id + " no existe"
            ));

        // ✅ Al eliminar, restar el valor del gastosActuales de la categoria
        if (gasto.getCategoria() != null) {
            Categoria categoria = gasto.getCategoria();
            int nuevoActual = categoria.getGastosActuales() - gasto.getValor();
            categoria.setGastosActuales(Math.max(nuevoActual, 0));
            categoriaRepositorio.save(categoria);
        }

        repositorio.deleteById(id);
        return true;
    }

    // =========================
    // BUSCAR GASTO POR ID
    // =========================
    public Gastos buscar_gasto_por_id(Integer id) {

        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El gasto con id " + id + " no existe"
            ));
    }
}