package com.kwillot.produits.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;
    @ManyToOne
    private Categorie categorie;

    public Produit(String nomProduit, Double prixProduit, Date dateCreation) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
    }

}
