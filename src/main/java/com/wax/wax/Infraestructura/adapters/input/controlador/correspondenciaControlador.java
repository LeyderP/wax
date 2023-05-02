package com.wax.wax.Infraestructura.adapters.input.controlador;


import com.wax.wax.Dominio.excepciones.fechaInvalidaExcepcion;
import com.wax.wax.Dominio.servicios.correspondenciaServicios;
import com.wax.wax.Infraestructura.adapters.output.persistence.entidades.correspondenciaEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/correspondencia")
public class correspondenciaControlador {
    @Autowired
    private correspondenciaServicios correspodenciaServicios;
    @Autowired
    private com.wax.wax.Infraestructura.adapters.output.persistence.repositorio.correspondenciaRepositorio correspondenciaRepositorio;

    @GetMapping("/")
    public List<correspondenciaEntidad> obtenerTodaLaCorrespondencia() { return correspodenciaServicios.obtenerTodaLaCorrespondencia();
    }

    @GetMapping("/{id}")
    public correspondenciaEntidad obtenerCorrespondenciaPorId(@PathVariable Long id) { return correspodenciaServicios.obtenerCorrespondenciaPorId(id).orElseThrow(() -> new NoSuchElementException("Correspondencia no encontrada con el id: " + id));
    }
    @GetMapping("/rango-fechas")
    public List<correspondenciaEntidad> obtenerCorrespondenciaPorRangoDeFechas(@RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
                                                                               @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return correspodenciaServicios.obtenerCorrespondenciaPorRangoDeFechas(fechaInicio, fechaFin);
    }
    @GetMapping("/por-nombre-residente")
    public List<correspondenciaEntidad> obtenerCorrespondenciaPorNombreResidente(@RequestParam("nombre") String nombre) {
        return correspodenciaServicios.obtenerCorrespondenciaPorNombreResidente(nombre);
    }

    @PostMapping("/")
    public ResponseEntity<?> crearCorrespondencia(@RequestBody correspondenciaEntidad correspondencia) {
        try {
            correspondenciaEntidad nuevaCorrespondencia = correspodenciaServicios.crearCorrespondencia(correspondencia);
            return new ResponseEntity<>("Correspondencia creada exitosamente con id " + nuevaCorrespondencia.getId(), HttpStatus.CREATED);
        } catch (fechaInvalidaExcepcion e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public correspondenciaEntidad actualizarCorrespondencia(@PathVariable Long id, @RequestBody correspondenciaEntidad correspondencia) {
        return correspodenciaServicios.actualizarCorrespondencia(id, correspondencia);
    }

    @DeleteMapping("/{id}")
    public void eliminarCorrespondencia(@PathVariable Long id) {correspodenciaServicios.eliminarCorrespondencia(id);
    }

}