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
public class InformacionBancaria {
    
    private String tipoinstitucionFinanciera;

    private String nombreinstitucionFinanciera;

    private String tipoCuenta;

    private String numeroCuenta;
}
