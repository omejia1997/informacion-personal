package ec.edu.espe.gpr.docencia.informacionpersonal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.docencia.informacionpersonal.model.Docente;
import ec.edu.espe.gpr.docencia.informacionpersonal.services.DocenteService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"https://yellow-river-0ca1d1510.3.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping(path = "/docente")
@RequiredArgsConstructor
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @PostMapping
    public ResponseEntity<String> guardarInformacion(@RequestBody Docente docente) {
        try {
            this.docenteService.guardarInformacion(docente);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/modificar")
    public ResponseEntity<String> actualizarInformacion(@RequestBody Docente docente) {
        try {
            this.docenteService.actualizarInformacion(docente);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
