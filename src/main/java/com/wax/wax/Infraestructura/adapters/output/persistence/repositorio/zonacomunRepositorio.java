package com.wax.wax.Infraestructura.adapters.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wax.wax.Infraestructura.adapters.output.persistence.entidades.zonacomunEntidad;

@Repository
public interface zonacomunRepositorio extends JpaRepository<zonacomunEntidad, Long> {

}
