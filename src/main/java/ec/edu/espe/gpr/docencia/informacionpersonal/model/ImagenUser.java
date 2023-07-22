package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ImagenUser {

    private String nombreImagen;

    private String urlImagen;

    private String fileBase64;
}
