package wax.wax.Dominio.modelo;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitanteModel {


    private Integer id;


    private Integer identificacion;

    private String apellidoD;


    private String apellidoU;


    private String nombre;

    private LocalDate fecha;

    private torreModel fkTr;

    private aptoModel fkApt;

    private String estado;

    private usuarioresidenteModel fkIdentificacion;
}
