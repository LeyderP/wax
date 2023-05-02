package com.wax.wax.Dominio.modelos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class correspondenciaModel {
   private Integer id;
   private Integer numGuia;
   private String nomResidente;
   private String destino;
   private String empresa;
   private torreModel torre;
   private aptoModel apto;
}