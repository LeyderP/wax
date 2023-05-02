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
@Table(name = "correspondencia")
public class correspondenciaEntidad {
    @Id
    @Column(name = "pk_pedido", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.NotNull
    @Column(name = "num_guia", nullable = false)
    private Integer numGuia;

    @jakarta.validation.constraints.Size(max = 255)
    @jakarta.validation.constraints.NotNull
    @Column(name = "nom_residente", nullable = false)
    private String nomResidente;

    @jakarta.validation.constraints.Size(max = 255)
    @jakarta.validation.constraints.NotNull
    @Column(name = "destino", nullable = false)
    private String destino;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "empresa", nullable = false, length = 100)
    private String empresa;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_tr", nullable = false)
    private torreEntidad fkTr;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_apt", nullable = false)
    private aptoEntidad fkApt;

    @jakarta.validation.constraints.NotNull
    @Column(name = "fecha_recibido", nullable = false)
    private LocalDate fecha;

}