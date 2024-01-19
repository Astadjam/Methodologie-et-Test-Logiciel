package com.test.exam;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class ProjetIntegrationTest {

    @Autowired
    private GestionTaches gestionTaches;

    @Autowired
    private Projet projet;

    @BeforeEach
    public void setUp() {
        // Réinitialiser la classe GestionTaches et la classe Projet avant chaque test
        gestionTaches = new GestionTaches();
        projet = new Projet(gestionTaches);
    }

    @Test
    public void testAjouterTacheAuProjet() throws TacheInexistante {
        // Ajouter une tâche au projet
        projet.ajouterTacheAuProjet("Tache Projet 1", "Description tache projet 1", 1);

        // Vérifier que la tâche a été ajoutée au projet
        List<Tache> tachesDuProjet = projet.getTaches();
        assertEquals(1, tachesDuProjet.size());
        assertEquals("Tache Projet 1", tachesDuProjet.get(0).getTitre());

        // Vérifier que la tâche a également été ajoutée dans la classe GestionTaches
        assertFalse(gestionTaches.verifierTache("Tache Projet 1"));
    }

    @Test
    public void testCompleterTacheDansLeProjet() throws TacheInexistante {
        // Ajouter une tâche au projet
        projet.ajouterTacheAuProjet("Tache Projet 2", "Description tache projet 2", 2);

        // Marquer la tâche comme complétée dans le projet
        projet.completerTacheDansLeProjet("Tache Projet 2");

        // Vérifier que la tâche est complétée dans le projet
        List<Tache> tachesDuProjet = projet.getTaches();
        assertTrue(tachesDuProjet.get(0).estComplete());

        // Vérifier que la tâche est également complétée dans la classe GestionTaches
        assertTrue(gestionTaches.verifierTache("Tache Projet 2"));
    }
}