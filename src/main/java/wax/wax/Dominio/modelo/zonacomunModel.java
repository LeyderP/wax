package wax.wax.Dominio.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "zonas_comunes")
public class zonacomunModel {


    private Integer id;

    private String zonaComun;

    private Set<reservazonaModel> reservaZonas = new LinkedHashSet<>();
}
