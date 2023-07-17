package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Idioma {

    private String codigoIdioma;

    private String idioma;

    private Double porcentajeHablado;

    private Double porcentajeEscrito;

    private Double porcentajeComprension;

}
