package ec.edu.espe.gpr.docencia.informacionpersonal.services;

import ec.edu.espe.gpr.docencia.informacionpersonal.dao.DocenteDao;
import ec.edu.espe.gpr.docencia.informacionpersonal.model.DocenteInformacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteDao docenteDao;

    public DocenteInformacion obtenerDocentePorIdEspe(String idEspe){
        return this.docenteDao.findByIdEspe(idEspe);
    }

    public List<DocenteInformacion> listarTodosDocentes() {
        return this.docenteDao.findAll();
    }
    public void guardarInformacion(DocenteInformacion docente, MultipartFile file){
        if(docente.getFechaNacimiento()!=null){
            LocalDate fechaActual = LocalDate.now();
            int edad = docente.getFechaNacimiento().until(fechaActual).getYears();
            docente.setEdad(edad);
        }
        docente.setFechaEntrega(new Date());
        this.docenteDao.save(docente);
    }

    public void actualizarInformacion(DocenteInformacion docente,MultipartFile file){
        if(docente.getFechaNacimiento()!=null){
            LocalDate fechaActual = LocalDate.now();
            int edad = docente.getFechaNacimiento().until(fechaActual).getYears();
            docente.setEdad(edad);
        }
        docente.setFechaEntrega(new Date());
        this.docenteDao.save(docente);
    }
}
