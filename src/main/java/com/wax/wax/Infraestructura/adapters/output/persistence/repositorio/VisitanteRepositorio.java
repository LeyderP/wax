package com.wax.wax.Infraestructura.adapters.output.persistence.repositorio;

import com.wax.wax.Infraestructura.adapters.output.persistence.entidades.VisitanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepositorio extends JpaRepository<VisitanteEntidad, Long> {

}
