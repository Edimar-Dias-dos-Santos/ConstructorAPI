package com.constructor.constructorAPI.models;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Entity
@Table(name = "TB_USUARIO_SERV_IMG")
public class UsuarioServImg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuarioServImg;

    @ManyToOne
    @JoinColumn(name = "idCliFornec")
    private CliFornec cliFornec;

    private String url;

    public UUID getId() {
        return idUsuarioServImg;
    }

    public void setId(UUID id) {
        this.idUsuarioServImg = id;
    }

    public CliFornec getCliFornec() {
        return cliFornec;
    }

    public void setCliFornec(CliFornec cliFornec) {
        this.cliFornec = cliFornec;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void saveImage(UUID idCliFornec, MultipartFile imageFile) throws IOException {
        String directoryPath = "C:/diretorio/imagens/"; // Diretório onde a imagem será salva

        if (!imageFile.isEmpty()) {
            String originalFileName = imageFile.getOriginalFilename();
            String fileExtension = getFileExtension(originalFileName);

            String uniqueFileName = generateUniqueFileName(idCliFornec, fileExtension);
            String filePath = directoryPath + uniqueFileName;
            File directory = new File(directoryPath);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            File dest = new File(filePath);
            imageFile.transferTo(dest);
            setUrl(filePath);
        }
    }

    private String getFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }

    private String generateUniqueFileName(UUID idCliFornec, String fileExtension) {
        String uniqueId = UUID.randomUUID().toString().replace("-", "");
        return idCliFornec.toString() + "_" + uniqueId + fileExtension;
    }
}