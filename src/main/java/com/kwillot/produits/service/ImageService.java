package com.kwillot.produits.service;

import com.kwillot.produits.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    Image uplaodImagesProd(MultipartFile file, Long idProd) throws IOException;

    Image uplaodImage(MultipartFile file) throws IOException;

    Image getImageDetails(Long id) throws IOException;

    ResponseEntity<byte[]> getImage(Long id) throws IOException;

    void deleteImage(Long id);

//    List<Image> getImagesParProd(Long prodId);
}