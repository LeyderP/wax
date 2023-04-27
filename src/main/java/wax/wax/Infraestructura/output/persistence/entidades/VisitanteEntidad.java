package wax.wax.Infraestructura.output.persistence.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "visitante")
public class VisitanteEntidad {
    @Id
    @Column(name = "pk_visita", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.NotNull
    @Column(name = "identificacion", nullable = false)
    private Integer identificacion;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "apellido_d", nullable = false, length = 100)
    private String apellidoD;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "apellido_u", nullable = false, length = 100)
    private String apellidoU;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @jakarta.validation.constraints.NotNull
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_tr", nullable = false)
    private torreEntidad fkTr;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_apt", nullable = false)
    private aptoEntidad fkApt;

    @jakarta.validation.constraints.Size(max = 100)
    @Column(name = "estado", length = 100)
    private String estado;

}