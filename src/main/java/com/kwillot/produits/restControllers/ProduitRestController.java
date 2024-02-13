package com.kwillot.produits.restControllers;

import com.kwillot.produits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRestController {
    @Autowired
    ProduitService produitService;

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Produit> getAllProduits() {
//        return produitService.getAllProduits();
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Produit getProduitById(@PathVariable("id") Long id) {
//        return produitService.getProduit(id);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Produit createProduit(@RequestBody Produit produit) {
//        return produitService.saveProduit(produit);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public Produit updateProduit(@RequestBody Produit produit) {
//        return produitService.updateProduit(produit);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void deleteProduit(@PathVariable("id") Long id) {
//        produitService.deleteProduitById(id);
//    }
}
