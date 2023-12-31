package ec.edu.espe.gpr.docencia.informacionpersonal.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.gpr.docencia.informacionpersonal.model.DocenteInformacion;

public interface DocenteDao extends MongoRepository<DocenteInformacion, String> {
    DocenteInformacion findByIdEspe(String idEspe);
}
