package wax.wax.Infraestructura.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wax.wax.Infraestructura.output.persistence.entidades.zonacomunEntidad;


@Repository
public interface zonacomunRepositorio extends JpaRepository<zonacomunEntidad, Long> {

}