package ec.edu.espe.gpr.docencia.informacionpersonal.services;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.specialized.BlockBlobClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Service
public class AzureStorageService {

    @Value("${azure.storage.connection-string}")
    private String connectionString; // Lee la cadena de conexión desde el archivo application.properties

    @Value("${azure.storage.container-name}")
    private String containerName; // Lee el nombre del contenedor desde el archivo application.properties

    /*public void subirArchivo(String nombreArchivo, InputStream archivoStream) throws IOException {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(nombreArchivo);
        blobClient.upload(archivoStream, archivoStream.available());
    }*/

    public String subirArchivo(String nombreArchivo, MultipartFile archivo) throws IOException {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(nombreArchivo);
        blobClient.upload(archivo.getInputStream(), archivo.getSize());
        String urlImagen = blobClient.getBlobUrl();
        return urlImagen;
    }

    public String actualizarImagen(String nombreArchivo, MultipartFile nuevaImagen) throws IOException {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(nombreArchivo);
        if (blobClient.exists()) {
            blobClient.delete();
        }
        return subirNuevaImagen(nombreArchivo, nuevaImagen, containerClient);
    }

    private String subirNuevaImagen(String nombreArchivo, MultipartFile nuevaImagen, BlobContainerClient containerClient) throws IOException {
        BlobClient blobClient = containerClient.getBlobClient(nombreArchivo);
        blobClient.upload(nuevaImagen.getInputStream(), nuevaImagen.getSize(), true);
        String urlImagen = blobClient.getBlobUrl();
        return urlImagen;
    }


    public String obtenerArchivoComoBase64(String fileName) throws IOException {

        BlobContainerClient containerClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient()
                .getBlobContainerClient(containerName);

        BlockBlobClient blobClient = containerClient.getBlobClient(fileName).getBlockBlobClient();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blobClient.download(outputStream);
        byte[] data = outputStream.toByteArray();

        return Base64.getEncoder().encodeToString(data);
    }

}
