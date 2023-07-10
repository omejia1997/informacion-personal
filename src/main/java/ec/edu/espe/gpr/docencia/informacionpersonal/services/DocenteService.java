package ec.edu.espe.gpr.docencia.informacionpersonal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.docencia.informacionpersonal.dao.DocenteDao;
import ec.edu.espe.gpr.docencia.informacionpersonal.model.Docente;

@Service
public class DocenteService {

    @Autowired
    private DocenteDao docenteDao;

    public void guardarInformacion(Docente docente){
        this.docenteDao.save(docente);
    }

    public void actualizarInformacion(Docente docente){
        this.docenteDao.save(docente);
    }
    
}
