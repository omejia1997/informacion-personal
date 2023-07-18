package ec.edu.espe.gpr.docencia.informacionpersonal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.gpr.docencia.informacionpersonal.model.DocenteInformacion;
import ec.edu.espe.gpr.docencia.informacionpersonal.services.DocenteService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@CrossOrigin(origins= {"https://yellow-river-0ca1d1510.3.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping(path = "/docente")
@RequiredArgsConstructor
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping(path = "/obtenerDocentePorIdEspe/{idEspe}")
    public ResponseEntity<DocenteInformacion> obtenerDocentePorIdEspe(@PathVariable String idEspe) {
        try {
            DocenteInformacion docente = this.docenteService.obtenerDocentePorIdEspe(idEspe);
            return ResponseEntity.ok(docente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarTodosDocentes")
    public ResponseEntity<List<DocenteInformacion>> listarTodosDocentes() {
        try {
            List<DocenteInformacion> docentes = this.docenteService.listarTodosDocentes();
            return ResponseEntity.ok(docentes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping
    public ResponseEntity<String> guardarInformacion(@RequestBody DocenteInformacion docente) {
        try {
            this.docenteService.guardarInformacion(docente);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping
    public ResponseEntity<String> actualizarInformacion(@RequestBody DocenteInformacion docente) {
        try {
            this.docenteService.actualizarInformacion(docente);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
