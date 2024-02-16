package com.kwillot.produits.restControllers;

import com.kwillot.produits.dto.ProduitDTO;
import com.kwillot.produits.entities.Produit;
import com.kwillot.produits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRestController {
    @Autowired
    ProduitService produitService;

    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<ProduitDTO> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/getbyid/{id}")
    public ProduitDTO getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @PostMapping("/addprod")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ProduitDTO createProduit(@RequestBody ProduitDTO produit) {
        return produitService.saveProduit(produit);
    }

    @PutMapping("/updateprod")
    public ProduitDTO updateProduit(@RequestBody ProduitDTO produit) {
        return produitService.updateProduit(produit);
    }

    @DeleteMapping("/delprod/{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        produitService.deleteProduitById(id);
    }

    @RequestMapping(value = "/prodscat/{idCat}", method = RequestMethod.GET)
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

    @RequestMapping(value = "/prodsByName/{nom}", method = RequestMethod.GET)
    public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom) {
        return produitService.findByNomProduitContains(nom);
    }
}
