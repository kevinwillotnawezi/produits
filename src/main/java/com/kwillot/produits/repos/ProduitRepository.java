package com.kwillot.produits.repos;

import com.kwillot.produits.entities.Categorie;
import com.kwillot.produits.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByNomProduit(String nom);

    List<Produit> findByNomProduitContains(String nom);

    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie(Categorie categorie);

    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

    List<Produit> findByCategorieIdCat(Long id);

    List<Produit> findByOrderByNomProduitAsc();

    @Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNomsPrix();
}