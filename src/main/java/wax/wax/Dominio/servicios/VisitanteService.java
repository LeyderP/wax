package wax.wax.Dominio.servicios;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wax.wax.Dominio.excepciones.FechaInvalida;
import wax.wax.Dominio.excepciones.VisitanteExistenteException;
import wax.wax.Dominio.excepciones.VisitatableNoEncontradoException;

import wax.wax.Infraestructura.output.persistence.entidades.VisitanteEntidad;
import wax.wax.Infraestructura.output.persistence.repositorio.VisitanteRepositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VisitanteService {

    @Autowired
    private VisitanteRepositorio visitanteRepositorio;

    public List<VisitanteEntidad> findAll() {
        return visitanteRepositorio.findAll();
    }

    public VisitanteEntidad findById(Integer id) {
        return visitanteRepositorio.findById(Long.valueOf(id))
                .orElseThrow(() -> new VisitatableNoEncontradoException("Visitante no encontrado con id " + id));
    }


//    public Visitatable findById(Integer id) {
//        return visitatableRepository.findById(Long.valueOf(id))
//                .orElseThrow(() -> new RuntimeException("Visitatable not found"));
//    }

    public VisitanteEntidad create(VisitanteEntidad visitante) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fecha = visitante.getFecha();

        if (fecha.isBefore(fechaActual)) {
            throw new FechaInvalida("No se puede registrar un visitante en una fecha anterior a la fecha actual");
        }

        // Verificar si ya existe un visitante registrado para la misma fecha y cédula
        Optional<VisitanteEntidad> visitanteExistente = visitanteRepositorio.findByIdentificacionAndFecha(visitante.getIdentificacion(), fecha);
        if (visitanteExistente.isPresent()) {
            throw new VisitanteExistenteException("Ya existe un visitante registrado con la misma cédula para la fecha dada");
        }

        // Establecer el estado como "en visita"
        visitante.setEstado("en visita");

        return visitanteRepositorio.save(visitante);
    }

    public VisitanteEntidad actualizarVisitante(Integer id, VisitanteEntidad visitante) {
        Optional<VisitanteEntidad> visitanteExistente = visitanteRepositorio.findById(Long.valueOf(id));
        if (visitanteExistente.isPresent()) {
            VisitanteEntidad visitanteActualizado = visitanteExistente.get();
            visitanteActualizado.setApellidoD(visitante.getApellidoD());
            visitanteActualizado.setApellidoU(visitante.getApellidoU());
            visitanteActualizado.setNombre(visitante.getNombre());
            visitanteActualizado.setFkTr(visitante.getFkTr());
            visitanteActualizado.setFkApt(visitante.getFkApt());
            visitanteActualizado.setFecha(visitante.getFecha());
            visitanteActualizado.setEstado(visitante.getEstado());
            visitanteActualizado.setIdentificacion(visitante.getIdentificacion());
            return visitanteRepositorio.save(visitanteActualizado);
        } else {
            throw new RuntimeException("Visitante no encontrado");
        }
    }


    public void delete(Integer id) {
        visitanteRepositorio.deleteById(Long.valueOf(id));
    }
}
