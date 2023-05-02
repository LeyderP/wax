package com.wax.wax.Infraestructura.adapters.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wax.wax.Infraestructura.adapters.output.persistence.entidades.reservazonaEntidad;

@Repository
public interface reservazonaRepositorio extends JpaRepository<reservazonaEntidad, Long> {

}