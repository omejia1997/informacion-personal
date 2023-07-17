package ec.edu.espe.gpr.docencia.informacionpersonal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.docencia.informacionpersonal.dao.DocenteDao;
import ec.edu.espe.gpr.docencia.informacionpersonal.model.DocenteInformacion;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Service
public class DocenteService {

    @Autowired
    private DocenteDao docenteDao;

    public DocenteInformacion obtenerDocentePorIdEspe(String idEspe){
        return this.docenteDao.findByIdEspe(idEspe);
    }
    public void guardarInformacion(DocenteInformacion docente){
        if(docente.getFechaNacimiento()!=null){
            LocalDate fechaActual = LocalDate.now();
            int edad = docente.getFechaNacimiento().until(fechaActual).getYears();
            docente.setEdad(edad);
        }
        docente.setFechaEntrega(new Date());
        this.docenteDao.save(docente);
    }

    public void actualizarInformacion(DocenteInformacion docente){
        if(docente.getFechaNacimiento()!=null){
            LocalDate fechaActual = LocalDate.now();
            int edad = docente.getFechaNacimiento().until(fechaActual).getYears();
            docente.setEdad(edad);
        }
        docente.setFechaEntrega(new Date());
        this.docenteDao.save(docente);
    }
    
}
