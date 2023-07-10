package ec.edu.espe.gpr.docencia.informacionpersonal.model;

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
public class ExperienciaProfesional {
    
    private String nombreInstitucion;

    private String puesto;

    private String unidadAdministrativa;

    private String modalidadContratacion;

    private String fechaIngreso;

    private String motivoSalidaLaboral;

    private String fechaSalida;

    private String pais;

    private String provincia;
}
