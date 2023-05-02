package com.wax.wax.Dominio.modelos;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class aptoModel {

    private Integer id;
    private Integer apartamento;
    private Set<VisitanteModel> visitantes = new LinkedHashSet<>();
    private Set<correspondenciaModel> correspondencias = new LinkedHashSet<>();
    private Set<usuarioresidenteModel> usuariosResidentes = new LinkedHashSet<>();
}
