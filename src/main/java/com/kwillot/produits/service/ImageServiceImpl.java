package com.kwillot.produits.service;

import com.kwillot.produits.entities.Image;
import com.kwillot.produits.entities.Produit;
import com.kwillot.produits.repos.ImageRepository;
import com.kwillot.produits.repos.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    ProduitService produitService;

    @Override
    public Image uplaodImagesProd(MultipartFile file, Long idProd) throws IOException {
        Produit p = new Produit();
        p.setId(idProd);
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .produit(p).build());
    }

    @Override
    public Image uplaodImage(MultipartFile file) throws IOException {
        /*Ce code commenté est équivalent au code utilisant le design pattern Builder
        * Image image = new Image(null, file.getOriginalFilename(),
        file.getContentType(), file.getBytes(), null);
        return imageRepository.save(image);*/
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes()).build());
    }

    @Override
    public Image getImageDetails(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        return Image.builder()
                .idImage(dbImage.get().getIdImage())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage()).build();
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

//    @Override
//    public List<Image> getImagesParProd(Long prodId) {
//        Produit p = produitRepository.findById(prodId).get();
//        System.out.println("----------------------------------------------kwi---------------------------------");
//        System.out.println(p);
//        System.out.println(p.getImages());
//        return p.getImages();
//    }
}
