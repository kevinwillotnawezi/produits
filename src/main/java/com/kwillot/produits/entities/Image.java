package com.kwillot.produits.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;
    private String name;
    private String type;
    @Column(name = "IMAGE", length = 4048576)
    @Lob
    private byte[] image;
    //    @ManyToOne
//    @JoinColumn(name = "PRODUIT_ID")
//    @JsonIgnore
    @OneToOne
    private Produit produit;
}
