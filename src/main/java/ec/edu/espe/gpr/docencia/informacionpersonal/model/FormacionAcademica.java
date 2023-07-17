package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import java.time.LocalDate;
import java.util.List;

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
public class FormacionAcademica {

    private String nivelInstruccion;

    private String institucion;

    private String tituloObtenido;

    private Integer tiempoEstudio;

    private String periodoEstudio;

    private String numeroRegistroSenescyt;

    private LocalDate fechaRegistroSenescyt;

    private String pais;

    private LocalDate fechaGraduacion;

    private List<FormacionAcademicaAdicional> formacionAcademicaAdicionales;

    private List<Idioma> idiomas;

    private List<Publicacion> publicaciones;
}
