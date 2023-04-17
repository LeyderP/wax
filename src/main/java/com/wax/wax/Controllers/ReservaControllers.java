package com.wax.wax.Controllers;
import com.wax.wax.Entities.Reserva;
import com.wax.wax.Repositories.ReservaZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wax.wax.Services.ReservaServices;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.NoSuchElementException;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaControllers {

    @Autowired
    private ReservaServices reservaServices;
    @Autowired
    private ReservaZonaRepository reservaZonaRepository;

    @GetMapping("/")
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaServices.obtenerTodasLasReservas();
    }

    @GetMapping("/{id}")
    public Reserva obtenerReservaPorId(@PathVariable Long id) { return reservaServices.obtenerReservaPorId(id).orElseThrow(() -> new NoSuchElementException("Reserva no encontrada con el id: " + id));
    }

    @PostMapping("/")
    public ResponseEntity<String> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaZonaRepository.save(reserva);
        return new ResponseEntity<>("Reserva creada exitosamente con id " + nuevaReserva.getIdReserva(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Reserva actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaServices.actualizarReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable Long id) {
        reservaServices.eliminarReserva(id);
    }
}

