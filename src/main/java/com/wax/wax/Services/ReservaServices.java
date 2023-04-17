package com.wax.wax.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wax.wax.Entities.Reserva;
import com.wax.wax.Repositories.ReservaZonaRepository;

@Service
public class ReservaServices {

    @Autowired
    private ReservaZonaRepository reservaZonaRepository;

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaZonaRepository.findAll();
    }

    public Reserva crearReserva(Reserva reserva) { return reservaZonaRepository.save(reserva);
    }

    public Optional<Reserva> obtenerReservaPorId(Long id) { return reservaZonaRepository.findById(id);
    }

    public Reserva actualizarReserva(Long id, Reserva reserva) {
        Optional<Reserva> reservaExistente = reservaZonaRepository.findById(id);

        if (reservaExistente.isPresent()) {
            Reserva reservaActualizada = reservaExistente.get();
            reservaActualizada.setIdentificacion(reserva.getIdentificacion());
            reservaActualizada.setIdTr(reserva.getIdTr());
            reservaActualizada.setIdZc(reserva.getIdZc());
            reservaActualizada.setFecha(reserva.getFecha());
            reservaActualizada.setTiempoReserva(reserva.getTiempoReserva());

            return reservaZonaRepository.save(reservaActualizada);
        } else {
            return null;
        }
    }

    public void eliminarReserva(Long id) {
        reservaZonaRepository.deleteById(id);
    }

}
