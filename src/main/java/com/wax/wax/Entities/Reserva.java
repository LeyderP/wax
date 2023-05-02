package com.wax.wax.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "reserva_zona")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "id_tr")
    private Long idTr;

    @Column(name = "id_zc")
    private Long idZc;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "tiempo_reserva")
    private Long tiempoReserva;

    // constructors, getters, and setters

    public Reserva() {

    }

    public Reserva(Long idReserva, String identificacion, Long idTr, Long idZc, LocalDate fecha, Long tiempoReserva) {
        this.idReserva = idReserva;
        this.identificacion = identificacion;
        this.idTr = idTr;
        this.idZc = idZc;
        this.fecha = fecha;
        this.tiempoReserva = tiempoReserva;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Long getIdTr() {
        return idTr;
    }

    public void setIdTr(Long idTr) {
        this.idTr = idTr;
    }

    public Long getIdZc() {
        return idZc;
    }

    public void setIdZc(Long idZc) {
        this.idZc = idZc;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getTiempoReserva() {
        return tiempoReserva;
    }

    public void setTiempoReserva(Long tiempoReserva) {
        this.tiempoReserva = tiempoReserva;
    }

    @Override
    public String toString() {
        return "Reserva [idReserva=" + idReserva + ", identificacion=" + identificacion + ", idTr=" + idTr + ", idZc=" + idZc
                + ", fecha=" + fecha + ", tiempoReserva=" + tiempoReserva + "]";
    }
}
