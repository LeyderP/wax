package wax.wax.Infraestructura.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wax.wax.Infraestructura.output.persistence.entidades.aptoEntidad;
import wax.wax.Infraestructura.output.persistence.entidades.torreEntidad;
import wax.wax.Infraestructura.output.persistence.entidades.VisitanteEntidad;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface VisitanteRepositorio extends JpaRepository<VisitanteEntidad, Long> {

    List<VisitanteEntidad> findByFecha(LocalDate fecha);
    List<VisitanteEntidad> findByFkTrAndFechaBetween(torreEntidad torreEntidad, LocalDate fechaInicio, LocalDate fechaFin);
    List<VisitanteEntidad> findByFkAptAndFechaBetween(aptoEntidad aptoEntidad, LocalDate fechaInicio, LocalDate fechaFin);
}