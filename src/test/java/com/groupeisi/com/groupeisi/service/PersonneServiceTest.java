package com.groupeisi.com.groupeisi.service;

import com.groupeisi.com.groupeisi.classe.Personne;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneServiceTest {


    private PersonneService personneService;

    @BeforeEach
    void setUp() {
        // Initialisation du service avant chaque test
        personneService = new PersonneServiceImpl();
    }

    @AfterEach
    void tearDown() {
        // Réinitialisation après chaque test si nécessaire
    }

    @Test
    void creerPersonne() {
        // Test Create
        Personne nouvellePersonne = new Personne(null, "John", "Doe", "123456789", "123 Main St");
        Personne personneCreee = personneService.creerPersonne(nouvellePersonne);
        assertNotNull(personneCreee.getId());
    }

    @Test
    void obtenirPersonneParId() {
        // Test Read
        Personne nouvellePersonne = new Personne(null, "John", "Doe", "123456789", "123 Main St");
        Personne personneCreee = personneService.creerPersonne(nouvellePersonne);

        Personne personneRecuperee = personneService.obtenirPersonneParId(personneCreee.getId());
        assertEquals("John", personneRecuperee.getPrenom());
    }

    @Test
    void obtenirToutesLesPersonnes() {
        // Test Read All
        Personne personne1 = new Personne(null, "John", "Doe", "123456789", "123 Main St");
        Personne personne2 = new Personne(null, "Jane", "Smith", "987654321", "456 Oak St");

        personneService.creerPersonne(personne1);
        personneService.creerPersonne(personne2);

        assertEquals(2, personneService.obtenirToutesLesPersonnes().size());
    }

    @Test
    void mettreAJourPersonne() {
        // Test Update
        Personne nouvellePersonne = new Personne(null, "John", "Doe", "123456789", "123 Main St");
        Personne personneCreee = personneService.creerPersonne(nouvellePersonne);

        personneCreee.setAdresse("456 Oak St");
        Personne personneMiseAJour = personneService.mettreAJourPersonne(personneCreee.getId(), personneCreee);
        assertEquals("456 Oak St", personneMiseAJour.getAdresse());
    }

    @Test
    void supprimerPersonne() {
        // Test Delete
        Personne nouvellePersonne = new Personne(null, "John", "Doe", "123456789", "123 Main St");
        Personne personneCreee = personneService.creerPersonne(nouvellePersonne);

        personneService.supprimerPersonne(personneCreee.getId());
        assertNull(personneService.obtenirPersonneParId(personneCreee.getId()));
    }
}