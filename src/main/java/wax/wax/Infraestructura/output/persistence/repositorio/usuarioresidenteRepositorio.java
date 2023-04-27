package wax.wax.Infraestructura.output.persistence.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wax.wax.Infraestructura.output.persistence.entidades.usuarioresidenteEntidad;


@Repository
public interface usuarioresidenteRepositorio extends JpaRepository<usuarioresidenteEntidad, Long> {

}