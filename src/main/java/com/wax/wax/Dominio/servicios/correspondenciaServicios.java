package com.wax.wax.Dominio.servicios;

import com.wax.wax.Dominio.excepciones.fechaInvalidaExcepcion;
import com.wax.wax.Infraestructura.adapters.output.persistence.entidades.correspondenciaEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class correspondenciaServicios {


    @Autowired
    private com.wax.wax.Infraestructura.adapters.output.persistence.repositorio.correspondenciaRepositorio correspondenciaRepositorio;

    public List<correspondenciaEntidad> obtenerTodaLaCorrespondencia() { return correspondenciaRepositorio.findAll();
    }

    public correspondenciaEntidad crearCorrespondencia(correspondenciaEntidad correspondencia) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaReserva = correspondencia.getFecha();

        if (fechaReserva.isBefore(fechaActual)) {
            throw new fechaInvalidaExcepcion("No se puede crear la correspondencia en una fecha anterior a la fecha actual");
        }

        return correspondenciaRepositorio.save(correspondencia);
    }
    public List<correspondenciaEntidad> obtenerCorrespondenciaPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return correspondenciaRepositorio.findByFechaBetween(fechaInicio, fechaFin);
    }

    public List<correspondenciaEntidad> obtenerCorrespondenciaPorNombreResidente(String nombre) {
        return correspondenciaRepositorio.findByNomResidenteContainingIgnoreCase(nombre);
    }


    public Optional<correspondenciaEntidad> obtenerCorrespondenciaPorId(Long id) { return correspondenciaRepositorio.findById(id);
    }

    public correspondenciaEntidad actualizarCorrespondencia(Long id, correspondenciaEntidad correspondencia) {
        Optional<correspondenciaEntidad> correspondenciaExistente = correspondenciaRepositorio.findById(id);

        if (correspondenciaExistente.isPresent()) {
            correspondenciaEntidad correspondenciaActualizada = correspondenciaExistente.get();
            correspondenciaActualizada.setNumGuia(correspondencia.getNumGuia());
            correspondenciaActualizada.setNomResidente(correspondencia.getNomResidente());
            correspondenciaActualizada.setDestino(correspondencia.getDestino());
            correspondenciaActualizada.setEmpresa(correspondencia.getEmpresa());
            correspondenciaActualizada.setFkTr(correspondencia.getFkTr());
            correspondenciaActualizada.setFkApt(correspondencia.getFkApt());
            correspondenciaActualizada.setFecha(correspondencia.getFecha());

            return correspondenciaRepositorio.save(correspondenciaActualizada);
        } else {
            return null;
        }
    }


//    public void eliminarCorrespondencia(Long id) { correspondenciaRepositorio.deleteById(id);
public void eliminarCorrespondencia(Long id) {
    Optional<correspondenciaEntidad> correspondenciaExistente = correspondenciaRepositorio.findById(id);
    if (correspondenciaExistente.isPresent()) {
        correspondenciaRepositorio.deleteById(id);
    } else {
        throw new fechaInvalidaExcepcion("Correspondencia no encontrada con el id: " + id);
    }
}


}
