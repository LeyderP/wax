package wax.wax.Infraestructura.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wax.wax.Infraestructura.output.persistence.entidades.correspondenciaEntidad;


@Repository
public interface correspondenciaRepositorio extends JpaRepository<correspondenciaEntidad, Long> {

}