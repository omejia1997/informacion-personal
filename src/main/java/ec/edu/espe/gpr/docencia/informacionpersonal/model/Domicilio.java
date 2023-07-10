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
public class Domicilio {
    private String provincia;

    private String canton;

    private String parroquia;

    private String callePrincipal;

    private String calleSecundaria;

    private String numeroDomicilio;

    private String referencia;

    private String telefonoDomicilio;

    private String telefonoCelular;

    private Domicilio domicilio;
}
