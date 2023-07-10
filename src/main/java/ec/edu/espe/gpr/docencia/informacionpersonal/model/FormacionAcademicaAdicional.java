package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class FormacionAcademicaAdicional {

    private String nivelInstruccion;

    private String institucion;

    private String tituloObtenido;

    private String numeroSenescyt;

    private Date fechaRegistroSenescyt;

    private Date fechaGraduacion;

    private String pais;
    
    private Integer tiempoEstudio;
}
