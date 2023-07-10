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
public class Discapacidad {

    private String discapacidadEspecial;

    private String tipoDiscapacidad;

    private Double porcentajeDiscapacidad;

    private String numeroCarnet;

    private String enfermedadCatastrófica;

    private String tipoEnfermedadCatastrofica;
}
