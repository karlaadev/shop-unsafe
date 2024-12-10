package com.unsafeshop.nsf.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {
    private String folder="images//";

    public String saveImage(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path directory = Paths.get(folder);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory); // Crea la carpeta si no existe
            }
            Path path = directory.resolve(file.getOriginalFilename());
            Files.write(path, bytes);
            return file.getOriginalFilename();
        }
        return "default.jpg";
    }

    public void deleteImage(String nombre) {
        Path filePath = Paths.get(folder).resolve(nombre); // Ruta completa de la imagen
        File file = filePath.toFile(); // Convierte a File

        if (file.exists()) { // Verifica si el archivo existe
            if (file.delete()) { // Intenta eliminarlo
                System.out.println("Imagen eliminada correctamente: " + nombre);
            } else {
                System.err.println("No se pudo eliminar la imagen: " + nombre);
            }
        } else {
            System.err.println("El archivo no existe: " + nombre);
        }
    }




}
