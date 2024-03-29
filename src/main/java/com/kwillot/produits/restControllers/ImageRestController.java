package com.kwillot.produits.restControllers;

import com.kwillot.produits.entities.Image;
import com.kwillot.produits.entities.Produit;
import com.kwillot.produits.service.ImageService;
import com.kwillot.produits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
    @Autowired
    ImageService imageService;

    @Autowired
    ProduitService produitService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }

//    @PostMapping(value = "/uplaodImageProd/{idProd}")
//    public Image uploadMultiImages(@RequestParam("image") MultipartFile file,
//                                   @PathVariable("idProd") Long idProd)
//            throws IOException {
//        return imageService.uplaodImagesProd(file, idProd);
//    }

//    @RequestMapping(value = "/getImagesProd/{idProd}",
//            method = RequestMethod.GET)
//    public List<Image> getImagesProd(@PathVariable("idProd") Long idProd) throws IOException {
//        return imageService.getImagesParProd(idProd);
//    }

    @RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        return imageService.getImage(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }

    @RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
    public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        Produit p = produitService.getProduit(id);
        p.setImagePath(id + ".jpg");
        Files.write(Paths.get(System.getProperty("user.home") + "/Pictures/test/" + p.getImagePath()), file.getBytes());
        produitService.saveProduit(p);
    }

    @RequestMapping(value = "/loadfromFS/{id}",
            method = RequestMethod.GET,
            produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
        Produit p = produitService.getProduit(id);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Pictures/test/" + p.getImagePath()));
    }
}
