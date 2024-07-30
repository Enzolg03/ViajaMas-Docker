package com.viajamas.app_viajamas.service;

import com.viajamas.app_viajamas.model.bd.Rol;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.viajamas.app_viajamas.model.bd.Usuario;
import com.viajamas.app_viajamas.repository.RolRepository;
import com.viajamas.app_viajamas.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("WORKER");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setPassword(passwordEncoder.encode("viajamas"));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Integer idusuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idusuario);
        if(usuario.isEmpty()){
            return usuario;
        }
        return usuario;
    }

    @Override
    public Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

}
