package com.kwillot.produits.service;

import com.kwillot.produits.dto.ProduitDTO;
import com.kwillot.produits.entities.Categorie;
import com.kwillot.produits.entities.Produit;

import java.util.List;

public interface ProduitService {
    ProduitDTO convertEntityToDto(Produit produit);

    Produit convertDtoToEntity(ProduitDTO produitDto);

    //    ProduitDTO saveProduit(ProduitDTO p);
    Produit saveProduit(Produit p);

    //    ProduitDTO updateProduit(ProduitDTO p);
    Produit updateProduit(Produit p);

    void deleteProduit(Produit p);

    void deleteProduitById(Long id);

    //    ProduitDTO getProduit(Long id);
    Produit getProduit(Long id);

    //    List<ProduitDTO> getAllProduits();
    List<Produit> getAllProduits();

    List<Produit> findByNomProduit(String nom);

    List<Produit> findByNomProduitContains(String nom);

    List<Produit> findByNomPrix(String nom, Double prix);

    List<Produit> findByCategorie(Categorie categorie);

    List<Produit> findByCategorieIdCat(Long id);

    List<Produit> findByOrderByNomProduitAsc();

    List<Produit> trierProduitsNomsPrix();
}
