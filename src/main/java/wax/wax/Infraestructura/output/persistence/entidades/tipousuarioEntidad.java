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
@Table(name = "tipo_usuario")
public class tipousuarioEntidad {
    @Id
    @Column(name = "pk_tusr", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "n_t_usuario", nullable = false, length = 100)
    private String nTUsuario;

    @OneToMany(mappedBy = "fkTusr")
    private Set<usuarioresidenteEntidad> usuariosResidentes = new LinkedHashSet<>();

}