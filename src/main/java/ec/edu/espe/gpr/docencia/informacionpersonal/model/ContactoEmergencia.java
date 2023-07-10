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
public class ContactoEmergencia{

    private String nombresCompletos;

    private String tipoDocumento;

    private String numeroDocumento;

    private String parentesco;

    private Domicilio domicilio;
}
