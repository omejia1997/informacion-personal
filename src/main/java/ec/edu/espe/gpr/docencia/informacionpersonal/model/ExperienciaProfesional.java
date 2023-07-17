package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExperienciaProfesional {

    private String codigoExperiencia;

    private String nombreInstitucion;

    private String puesto;

    private String unidadAdministrativa;

    private String tipoInstitucion;

    private String modalidadContratacion;

    private LocalDate fechaIngreso;

    private String motivoSalidaLaboral;

    private String fechaSalida;

    private String pais;

    private String provincia;
}
