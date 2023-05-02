package com.wax.wax.Infraestructura.adapters.output.persistence.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wax.wax.Infraestructura.adapters.output.persistence.entidades.correspondenciaEntidad;

@Repository
public interface correspondenciaRepositorio extends JpaRepository<correspondenciaEntidad, Long> {

    List<correspondenciaEntidad> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<correspondenciaEntidad> findByNomResidenteContainingIgnoreCase(String nombre);


}
