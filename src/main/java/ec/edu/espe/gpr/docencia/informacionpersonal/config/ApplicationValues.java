package ec.edu.espe.gpr.docencia.informacionpersonal.config;

import org.springframework.stereotype.Component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Component
public class ApplicationValues {
    private final String mongoHost;
    private final String mongoDB;
    private final String mongoUsr;
    private final String mongoPwd;
    private final String mongoAut;

    public ApplicationValues(
            @Value("${gpr.docencia.informacion.personal.mongo.host}") String mongoHost,
            @Value("${gpr.docencia.informacion.personal.mongo.db}") String mongoDB,
            @Value("${gpr.docencia.informacion.personal.mongo.usr}") String mongoUsr,
            @Value("${gpr.docencia.informacion.personal.mongo.pwd}") String mongoPwd,
            @Value("${gpr.docencia.informacion.personal.mongo.aut}") String mongoAut) {

        this.mongoHost = mongoHost;
        this.mongoDB = mongoDB;
        this.mongoUsr = mongoUsr;
        this.mongoPwd = mongoPwd;
        this.mongoAut = mongoAut;
    }
}