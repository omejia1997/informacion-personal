package ec.edu.espe.gpr.docencia.informacionpersonal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.docencia.informacionpersonal.dao.DocenteDao;
import ec.edu.espe.gpr.docencia.informacionpersonal.model.DocenteInformacion;

@Service
public class DocenteService {

    @Autowired
    private DocenteDao docenteDao;

    public void guardarInformacion(DocenteInformacion docente){
        this.docenteDao.save(docente);
    }

    public void actualizarInformacion(DocenteInformacion docente){
        this.docenteDao.save(docente);
    }
    
}
