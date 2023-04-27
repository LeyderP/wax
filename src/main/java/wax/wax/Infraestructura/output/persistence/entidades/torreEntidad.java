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
@Table(name = "torre")
public class torreEntidad {
    @Id
    @Column(name = "pk_tr", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.NotNull
    @Column(name = "torre", nullable = false)
    private Integer torre;

    @OneToMany(mappedBy = "fkTr")
    private Set<VisitanteEntidad> visitantes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fkTr")
    private Set<correspondenciaEntidad> correspondencias = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fkTr")
    private Set<reservazonaEntidad> reservaZonas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fkTr")
    private Set<usuarioresidenteEntidad> usuariosResidentes = new LinkedHashSet<>();

}