package com.wax.wax.Infraestructura.adapters.output.persistence.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "reserva_zona")
public class reservazonaEntidad {
    @Id
    @Column(name = "pk_reserva", nullable = false)
    private Integer id;

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

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_identificacion", nullable = false)
    private usuarioresidenteEntidad fkidentificacion;

}