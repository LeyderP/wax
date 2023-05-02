package wax.wax.Dominio.modelo;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class zonacomunModel {


    private Integer id;

    private String zonaComun;

    private Set<reservazonaModel> reservaZonas = new LinkedHashSet<>();
}
