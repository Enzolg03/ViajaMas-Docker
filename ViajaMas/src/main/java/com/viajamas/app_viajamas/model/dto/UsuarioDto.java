package com.viajamas.app_viajamas.model.dto;

import lombok.Data;

@Data
public class UsuarioDto implements DtoEntity{
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private String email;
}
