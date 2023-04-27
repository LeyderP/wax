package wax.wax.Dominio.modelo;


import lombok.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class usuarioresidenteModel {

    private Integer id;

    private Integer identificacion;

    private String apellidoU;

    private String apellidoD;

    private String nombre;

    private Integer numeroContacto;

    private String correoElectronico;

    private torreModel fkTr;

    private aptoModel fkApt;

    private tipousuarioModel fkTusr;

    private Set<reservazonaModel> reservaZonas = new LinkedHashSet<>();
}
