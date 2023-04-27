package wax.wax.Infraestructura.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wax.wax.Infraestructura.output.persistence.entidades.tipousuarioEntidad;


@Repository
public interface tiposuarioRepositorio extends JpaRepository<tipousuarioEntidad, Long> {

}