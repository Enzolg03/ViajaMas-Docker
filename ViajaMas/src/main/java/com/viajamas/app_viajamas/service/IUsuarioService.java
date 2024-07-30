package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Usuario;
import com.viajamas.app_viajamas.model.dto.UsuarioDto;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    Usuario guardarUsuario(Usuario usuario);
    Optional<Usuario> obtenerUsuarioPorId(Integer idusuario);
    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);
}
