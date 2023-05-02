package wax.wax.Infraestructura.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wax.wax.Infraestructura.output.persistence.entidades.aptoEntidad;
import wax.wax.Infraestructura.output.persistence.entidades.torreEntidad;
import wax.wax.Infraestructura.output.persistence.entidades.VisitanteEntidad;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface VisitanteRepositorio extends JpaRepository<VisitanteEntidad, Long> {
    Optional<VisitanteEntidad> findByIdentificacionAndFecha(Integer identificacion, LocalDate fecha);

//    List<VisitanteEntidad> findByFecha(LocalDate fecha);
//    List<VisitanteEntidad> findByFkTrAndFechaBetween(torreEntidad torreEntidad, LocalDate fechaInicio, LocalDate fechaFin);
//    List<VisitanteEntidad> findByFkAptAndFechaBetween(aptoEntidad aptoEntidad, LocalDate fechaInicio, LocalDate fechaFin);
}