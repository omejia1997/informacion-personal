package ec.edu.espe.gpr.docencia.informacionpersonal.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.gpr.docencia.informacionpersonal.model.DocenteInformacion;
import ec.edu.espe.gpr.docencia.informacionpersonal.services.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public ResponseEntity<String> guardarInformacion(@RequestParam("docente")String strDocente,@RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> {
                        return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    })
                    .create();
            DocenteInformacion docenteInformacion= gson.fromJson(strDocente, DocenteInformacion.class);
            this.docenteService.guardarInformacion(docenteInformacion,file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> actualizarInformacion(@RequestParam("docente") String strDocente,@RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> {
                        return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    }).create();
            DocenteInformacion docenteInformacion= gson.fromJson(strDocente, DocenteInformacion.class);
            this.docenteService.actualizarInformacion(docenteInformacion,file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
