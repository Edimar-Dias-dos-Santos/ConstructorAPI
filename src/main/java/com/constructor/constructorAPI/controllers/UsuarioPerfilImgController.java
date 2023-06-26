package com.constructor.constructorAPI.controllers;
import com.constructor.constructorAPI.dtos.UsuarioPerfilImgRecordDto;
import com.constructor.constructorAPI.models.Usuario;
import com.constructor.constructorAPI.models.UsuarioPerfilImg;
import com.constructor.constructorAPI.repositories.RepUsuario;
import com.constructor.constructorAPI.repositories.RepUsuarioPerfilImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/usuario-perfil-img")
@CrossOrigin("*")
public class UsuarioPerfilImgController {

    private static final String UPLOAD_DIR = "C:/diretorio/imagens/"; // Diretório onde as imagens serão salvas

    @Autowired
    private RepUsuarioPerfilImg repUsuarioPerfilImg;

    @Autowired
    private RepUsuario repUsuario;

    @PostMapping("/{idUsuario}")
    public ResponseEntity<UsuarioPerfilImgRecordDto> uploadUserProfileImage(@PathVariable UUID idUsuario, @RequestParam("image") MultipartFile image) {
        Optional<Usuario> optionalUser = repUsuario.findById(idUsuario);
        if (optionalUser.isPresent()) {
            Usuario user = optionalUser.get();

            String originalFilename = image.getOriginalFilename();
            String filename = getUniqueFilename(originalFilename);
            String filepath = UPLOAD_DIR + File.separator + filename;

            try {

                Path destination = Path.of(filepath);
                Files.copy(image.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

                UsuarioPerfilImg userProfileImg = new UsuarioPerfilImg();
                userProfileImg.setIdUsuarioPerfilImg(UUID.randomUUID());
                userProfileImg.setUsuario(user);
                userProfileImg.setUrl(filepath);
                repUsuarioPerfilImg.save(userProfileImg);

                UsuarioPerfilImgRecordDto responseDto = new UsuarioPerfilImgRecordDto(userProfileImg.getIdUsuarioPerfilImg(), userProfileImg.getUrl());
                return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
            } catch (IOException e) {

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String getUniqueFilename(String originalFilename) {
        String baseName = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
        String extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String filename = baseName;
        int count = 1;

        while (fileExists(filename + extension)) {
            filename = baseName + "-" + count;
            count++;
        }

        return filename + extension;
    }

    private boolean fileExists(String filename) {
        File file = new File(UPLOAD_DIR + File.separator + filename);
        return file.exists();
    }
}