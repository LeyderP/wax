package com.wax.wax.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wax.wax.Entities.Reserva;

@Repository
public interface ReservaZonaRepository extends JpaRepository<Reserva, Long> {

}

