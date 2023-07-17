package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FormacionAcademicaAdicional {

    private String codigoFormacionAdicional;

    private String nivelInstruccion;

    private String institucion;

    private String tituloObtenido;

    private String numeroSenescyt;

    private LocalDate fechaRegistroSenescyt;

    private LocalDate fechaGraduacion;

    private String pais;
    
    private Integer tiempoEstudio;
}
