package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publicacion {

    private String idPublicacion;

    private String tipoInvestigacion;

    private String tituloCompleto;

    private String publicador;

    private String codigoPublicacion;

    private String participacion;

    private String idioma;

    private String estadoPublicacion;

    private LocalDate fechaPublicacion;

    private Integer volumenPublicacion;

    private String revisionPares;
}
