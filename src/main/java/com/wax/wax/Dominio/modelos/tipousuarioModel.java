package com.wax.wax.Dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class tipousuarioModel {
    private Integer id;
    private String nTUsuario;
    private Set<usuarioresidenteModel> usuariosResidentes = new LinkedHashSet<>();
}