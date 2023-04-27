package wax.wax.Infraestructura.output.persistence.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "zonas_comunes")
public class zonacomunEntidad {
    @Id
    @Column(name = "pk_zc", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "zona_comun", nullable = false, length = 100)
    private String zonaComun;

    @OneToMany(mappedBy = "fkZc")
    private Set<reservazonaEntidad> reservaZonas = new LinkedHashSet<>();

}