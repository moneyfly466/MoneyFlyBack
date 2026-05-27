package com.example.MoneyFly.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.MoneyFly.modelos.Usuario;
import com.example.MoneyFly.repositorios.IUsuariorepositorio;

@Service
public class UsuarioServicios {

    @Autowired
    private IUsuariorepositorio repositorio;

    // Guardar usuario
    public Usuario guardar_usuario(Usuario datosUsuario){

        if (datosUsuario.getNombres() == null || datosUsuario.getNombres().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El nombre de usuario es obligatorio"
            );
        }

        if (datosUsuario.getContraseña() == null || datosUsuario.getContraseña().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "La contraseña es obligatoria"
            );
        }

        if (datosUsuario.getDocumento() == null || datosUsuario.getDocumento().length() < 6) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El documento debe tener al menos 6 caracteres"
            );
        }

        return repositorio.save(datosUsuario);
    }

    // Listar usuarios
    public List<Usuario> listar_Usuarios(){
        return repositorio.findAll();
    }

    // Modificar usuario
    public Usuario modificar_Usuario(Integer id, Usuario datosNuevos){

        Usuario usuario_encontrado = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Usuario no encontrado"
            ));

        usuario_encontrado.setNombres(datosNuevos.getNombres());
        usuario_encontrado.setTipoDocumento(datosNuevos.getTipoDocumento());
        usuario_encontrado.setDocumento(datosNuevos.getDocumento());
        usuario_encontrado.setCorreo(datosNuevos.getCorreo());
        usuario_encontrado.setTelefono(datosNuevos.getTelefono());
        usuario_encontrado.setGenero(datosNuevos.getGenero());
        usuario_encontrado.setOcupacion(datosNuevos.getOcupacion());
        // ✅ CORRECCIÓN: edad faltaba en el modificar
        usuario_encontrado.setEdad(datosNuevos.getEdad());

        return repositorio.save(usuario_encontrado);
    }

    // Eliminar usuario
    public boolean eliminar_usuario(Integer id){

        Usuario usuario = repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Usuario no encontrado"
            ));

        repositorio.delete(usuario);
        return true;
    }

    // Buscar usuario por id
    public Usuario buscar_usuario_por_id(Integer id){

        return repositorio.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Usuario no encontrado"
            ));
    }
}