package wax.wax.Infraestructura.output.persistence.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reserva_zona")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class reservazonaEntidad {
    @Id
    @Column(name = "pk_reserva", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identificacion", nullable = false)
    private usuarioresidenteEntidad identificacion;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_tr", nullable = false)
    private torreEntidad fkTr;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_zc", nullable = false)
    private zonacomunEntidad fkZc;

    @jakarta.validation.constraints.NotNull
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @jakarta.validation.constraints.NotNull
    @Column(name = "tiempo_reserva", nullable = false)
    private Integer tiempoReserva;

}