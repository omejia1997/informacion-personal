package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import java.util.Date;
import java.util.List;

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
public class FormacionAcademica {

    private String nivelInstruccion;

    private String institucion;

    private String tituloObtenido;

    private Integer tiempoEstudio;

    private String periodoEstudio;

    private String numeroRegistroSenescyt;

    private Date fechaRegistroSenescyt;

    private String pais;

    private Date fechaGraduacion;

    private List<FormacionAcademicaAdicional> formacionAcademicaAdicionales;
    
}
