package wax.wax.Dominio.servicios;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wax.wax.Dominio.excepciones.FechaInvalida;
import wax.wax.Dominio.excepciones.VisitAlreadyExistsException;
import wax.wax.Dominio.excepciones.VisitatableNotFoundException;

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
                .orElseThrow(() -> new VisitatableNotFoundException("Visitatable not found with id " + id));
    }


//    public Visitatable findById(Integer id) {
//        return visitatableRepository.findById(Long.valueOf(id))
//                .orElseThrow(() -> new RuntimeException("Visitatable not found"));
//    }

    public VisitanteEntidad create(VisitanteEntidad visitatable) {
        LocalDate currentDate = LocalDate.now();
        if (visitatable.getFecha().isBefore(currentDate)) {
            throw new FechaInvalida("La fecha no puede ser menor que la fecha actual");
        }
        if (visitanteRepositorio.findById(Long.valueOf(String.valueOf(visitatable.getIdentificacion()))) != null)  {
            throw new VisitAlreadyExistsException("Ya existe una visita registrada con esta identificación");
        }
        return visitanteRepositorio.save(visitatable);
    }


//    public Visitatable create(Visitatable visitatable) {
//        return visitatableRepository.save(visitatable);
//    }

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
