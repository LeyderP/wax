package wax.wax.Infraestructura.adapters.input.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wax.wax.Dominio.excepciones.FechaInvalida;
import wax.wax.Dominio.servicios.VisitanteService;
import wax.wax.Infraestructura.output.persistence.entidades.VisitanteEntidad;
import java.util.List;
import wax.wax.Dominio.excepciones.VisitanteExistenteException;

@RestController
@RequestMapping("/visita")

public class VisitaControlador {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping("/")
    public ResponseEntity<List<VisitanteEntidad>> findAll() {
        List<VisitanteEntidad> visitatables = visitanteService.findAll();
        return new ResponseEntity<>(visitatables, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitanteEntidad> findById(@PathVariable("id") Integer id) {
        VisitanteEntidad visitatable = visitanteService.findById(id);
        return new ResponseEntity<>(visitatable, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@Valid @RequestBody VisitanteEntidad visitante) {
        try {
            VisitanteEntidad createdVisitante = visitanteService.create(visitante);
            return new ResponseEntity<>("Visitante creado con id " + createdVisitante.getId(), HttpStatus.CREATED);
        } catch (FechaInvalida e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (VisitanteExistenteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<VisitanteEntidad> update(@PathVariable("id") Integer id, @Valid @RequestBody VisitanteEntidad visitatable) {
        VisitanteEntidad updatedVisitatable = visitanteService.actualizarVisitante(id, visitatable);
        return new ResponseEntity<>(updatedVisitatable, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        visitanteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}