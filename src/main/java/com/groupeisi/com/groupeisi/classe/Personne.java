package com.groupeisi.com.groupeisi.classe;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personne {

    private Long id;
    private String prenom;
    private String nom;
    private String telephone;
    private String adresse;
}
