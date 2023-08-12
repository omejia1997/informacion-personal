package ec.edu.espe.gpr.docencia.informacionpersonal.services;

import ec.edu.espe.gpr.docencia.informacionpersonal.dao.DocenteDao;
import ec.edu.espe.gpr.docencia.informacionpersonal.model.DocenteInformacion;
import ec.edu.espe.gpr.docencia.informacionpersonal.model.ImagenUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteDao docenteDao;
    @Autowired
    private AzureStorageService azureStorageService;

    public DocenteInformacion obtenerDocentePorIdEspe(String idEspe){
        DocenteInformacion docente = this.docenteDao.findByIdEspe(idEspe);
        if(docente.getFechaNacimiento()!=null){
            LocalDate fechaActual = LocalDate.now();
            int edad = docente.getFechaNacimiento().until(fechaActual).getYears();
            docente.setEdad(edad);
        }
        return docente;
    }

    public List<DocenteInformacion> listarTodosDocentes() {
        List<DocenteInformacion> docentes= this.docenteDao.findAll();
        for (DocenteInformacion docente:docentes) {
            if(docente.getFechaNacimiento()!=null){
                LocalDate fechaActual = LocalDate.now();
                int edad = docente.getFechaNacimiento().until(fechaActual).getYears();
                docente.setEdad(edad);
            }
        }
        return docentes;
    }

    private String obtenerExtensionArchivo(MultipartFile file) {
        String nombreOriginal = file.getOriginalFilename();
        if (nombreOriginal != null && !nombreOriginal.isEmpty()) {
            int ultimaPuntoIndex = nombreOriginal.lastIndexOf('.');
            if (ultimaPuntoIndex > 0) {
                //return nombreOriginal.substring(ultimaPuntoIndex + 1).toLowerCase();
                return nombreOriginal.substring(ultimaPuntoIndex + 1);
            }
        }
        return "";
    }
    public void guardarInformacion(DocenteInformacion docente, MultipartFile file) throws IOException {

        docente.setFechaEntrega(new Date());
        DocenteInformacion docenteInformacion = this.docenteDao.save(docente);
        if(file!=null){
            String nombreImagen = docenteInformacion.getId()+"."+this.obtenerExtensionArchivo(file);
            docenteInformacion.setImagenUser(new ImagenUser());
            docenteInformacion.getImagenUser().setUrlImagen(this.azureStorageService.subirArchivo(nombreImagen,file));
            docenteInformacion.getImagenUser().setNombreImagen(nombreImagen);
            this.docenteDao.save(docenteInformacion);
        }
        /*if(docente.getFechaNacimiento()!=null){
            LocalDate fechaActual = LocalDate.now();
            int edad = docente.getFechaNacimiento().until(fechaActual).getYears();
            docente.setEdad(edad);
        }*/
    }

    public void actualizarInformacion(DocenteInformacion docente,MultipartFile file) throws IOException {
        if(file!=null){
            String nombreImagen = docente.getId()+"."+this.obtenerExtensionArchivo(file);
            docente.setImagenUser(new ImagenUser());
            docente.getImagenUser().setUrlImagen(this.azureStorageService.actualizarImagen(nombreImagen,file));
            docente.getImagenUser().setNombreImagen(nombreImagen);
            this.docenteDao.save(docente);
        }
        docente.setFechaEntrega(new Date());

        this.docenteDao.save(docente);
    }

    public ImagenUser obtenerArchivoComoBase64(String fileName) throws IOException {
        ImagenUser imagenUser = new ImagenUser();
        imagenUser.setNombreImagen(fileName);
        imagenUser.setFileBase64(this.azureStorageService.obtenerArchivoComoBase64(fileName));
        return imagenUser;
    }
}
