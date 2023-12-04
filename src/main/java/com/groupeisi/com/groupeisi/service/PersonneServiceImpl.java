package com.groupeisi.com.groupeisi.service;
import com.groupeisi.com.groupeisi.classe.Personne;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonneServiceImpl implements PersonneService {

    private Map<Long, Personne> personnes = new HashMap<>();
    private long idSequence = 1;

    @Override
    public Personne creerPersonne(Personne personne) {
        personne.setId(idSequence++);
        personnes.put(personne.getId(), personne);
        return personne;
    }

    @Override
    public Personne obtenirPersonneParId(Long id) {
        return personnes.get(id);
    }

    @Override
    public List<Personne> obtenirToutesLesPersonnes() {
        return new ArrayList<>(personnes.values());
    }

    @Override
    public Personne mettreAJourPersonne(Long id, Personne personne) {
        if (personnes.containsKey(id)) {
            personne.setId(id);
            personnes.put(id, personne);
            return personne;
        } else {
            return null; // Personne non trouvée
        }
    }

    @Override
    public void supprimerPersonne(Long id) {
        personnes.remove(id);
    }
}