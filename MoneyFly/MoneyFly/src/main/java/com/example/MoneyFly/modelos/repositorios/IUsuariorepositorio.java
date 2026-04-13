package com.example.MoneyFly.modelos.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MoneyFly.modelos.Usuario;
import com.example.MoneyFly.modelos.utils.TipoDocumento;

@Repository
public interface IUsuariorepositorio extends JpaRepository <Usuario,Integer> {

    //considero una consulta personalizada como una busqueda
    //1. defino que atributos tiene mi modelo y solo sobre esos atributos puedo implementar las busquedas

    //buscar por nombre
List <Usuario> findByNombres (String nombres);
    //tipo de documento 
List<Usuario > findByTipoDocumento(TipoDocumento tipodocumento); 
    //buscar por documento 
Optional <Usuario> findByDocumento (String documento);
    //buscar por edad
List<Usuario> findByEdad (int edad); 

}
