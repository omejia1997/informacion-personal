package ec.edu.espe.gpr.docencia.informacionpersonal.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "docente")
@TypeAlias("docente")
public class Docente {

    @Id 
    private String id;
    
    private String tipoDocumento;

    @Indexed(name = "idx_docente_numeroDocumento", unique = true)
    private String numeroDocumento;

    private String nombreCompleto;

    private Date fechaNacimiento;

    private String genero;

    private String estadoCivil;

    private String nacionalidad;

    private Integer edad;

    private String tipoSangre;

    private Integer aniosResidencia;

    private String etnia;

    private Date grupoEtnico;

    private Integer correoPrincipal;

    private String correoAlternativo;

    private Discapacidad discapacidad;
    //
    private Domicilio domicilio;

    private String telefonoTrabajo;

    private String extension;
    //
    private ContactoEmergencia contactoEmergencia;

    private InformacionBancaria informacionBancaria;

    private FormacionAcademica formacionAcademica;

    private List<ExperienciaProfesional> experienciaProfesionales;

    private Date fechaEntrega;

}