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
@Table(name = "apto")
public class aptoEntidad {
    @Id
    @Column(name = "pk_apt", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.NotNull
    @Column(name = "apartamento", nullable = false)
    private Integer apartamento;

    @OneToMany(mappedBy = "fkApt")
    private Set<VisitanteEntidad> visitantes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fkApt")
    private Set<correspondenciaEntidad> correspondencias = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fkApt")
    private Set<usuarioresidenteEntidad> usuariosResidentes = new LinkedHashSet<>();

}