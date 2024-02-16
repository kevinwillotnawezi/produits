package com.kwillot.produits.service;

import com.kwillot.produits.dto.ProduitDTO;
import com.kwillot.produits.entities.Categorie;
import com.kwillot.produits.entities.Produit;
import com.kwillot.produits.repos.ProduitRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Produit convertDtoToEntity(ProduitDTO produitDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(produitDto, Produit.class);
//        Produit produit = new Produit();
//        produit.setId(produitDto.getIdProduit());
//        produit.setNomProduit(produitDto.getNomProduit());
//        produit.setPrixProduit(produitDto.getPrixProduit());
//        produit.setDateCreation(produitDto.getDateCreation());
//        produit.setCategorie(produitDto.getCategorie());
//        return produit;
    }

    @Override
    public ProduitDTO convertEntityToDto(Produit produit) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(produit, ProduitDTO.class);
//        ProduitDTO produitDTO = new ProduitDTO();
//        produitDTO.setIdProduit(produit.getId());
//        produitDTO.setNomProduit(produit.getNomProduit());
//        produitDTO.setPrixProduit(produit.getPrixProduit());
//        produitDTO.setDateCreation(produit.getDateCreation());
//        produitDTO.setCategorie(produit.getCategorie());
//        return produitDTO;
        /*return ProduitDTO.builder()
        .idProduit(produit.getIdProduit())
        .nomProduit(produit.getNomProduit())
        .prixProduit(produit.getPrixProduit())
        .dateCreation(p.getDateCreation())
        .categorie(produit.getCategorie())
        .build();*/
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public ProduitDTO saveProduit(ProduitDTO p) {
        return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public ProduitDTO updateProduit(ProduitDTO p) {
        return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public ProduitDTO getProduit(Long id) {
        return convertEntityToDto(produitRepository.findById(id).get());
    }

    @Override
    public List<ProduitDTO> getAllProduits() {
        return produitRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }

    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }

    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepository.trierProduitsNomsPrix();
    }
}
