package ec.edu.espe.gpr.docencia.informacionpersonal.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.gpr.docencia.informacionpersonal.model.Docente;

public interface DocenteDao extends MongoRepository<Docente, String> {
    
}
