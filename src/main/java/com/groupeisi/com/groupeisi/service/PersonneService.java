package com.groupeisi.com.groupeisi.service;
import com.groupeisi.com.groupeisi.classe.Personne;

import java.util.List;

public interface PersonneService {

    Personne creerPersonne(Personne personne);

    Personne obtenirPersonneParId(Long id);

    List<Personne> obtenirToutesLesPersonnes();

    Personne mettreAJourPersonne(Long id, Personne personne);

    void supprimerPersonne(Long id);
}
