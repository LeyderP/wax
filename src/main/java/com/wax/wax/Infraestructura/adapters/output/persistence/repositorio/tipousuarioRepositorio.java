package com.wax.wax.Infraestructura.adapters.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wax.wax.Infraestructura.adapters.output.persistence.entidades.tipousuarioEntidad;

@Repository
public interface tipousuarioRepositorio extends JpaRepository<tipousuarioEntidad, Long> {

}