package com.wax.wax.Infraestructura.adapters.output.persistence.entidades;

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
@Table(name = "usuarios_residentes")
public class usuarioresidenteEntidad {

    @Id
    @Column(name = "pk_identificacion", nullable = false)
    private Integer id;

    @jakarta.validation.constraints.NotNull
    @Column(name = "id_usr", nullable = false)
    private Integer idUsr;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "apellido_u", nullable = false, length = 100)
    private String apellidoU;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "apellido_d", nullable = false, length = 100)
    private String apellidoD;

    @jakarta.validation.constraints.Size(max = 100)
    @jakarta.validation.constraints.NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @jakarta.validation.constraints.NotNull
    @Column(name = "numero_contacto", nullable = false)
    private Long numeroContacto;

    @jakarta.validation.constraints.Size(max = 255)
    @jakarta.validation.constraints.NotNull
    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_tr", nullable = false)
    private torreEntidad fkTr;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_apt", nullable = false)
    private aptoEntidad fkApt;

    @jakarta.validation.constraints.NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_tusr", nullable = false)
    private tipousuarioEntidad fkTusr;

    @OneToMany(mappedBy = "fkidentificacion")
    private Set<reservazonaEntidad> reservaZonas = new LinkedHashSet<>();

}