package com.test.exam;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GestionTachesTest {

    @Autowired
    private GestionTaches gestionTaches = new GestionTaches();

    @Test
    public void testAjouterTache() throws TacheInexistante {
        gestionTaches.ajouterTache("Tache 1", "Desc tache 1");
        assertFalse(gestionTaches.verifierTache("Tache 1"));
    }

    @Test
    public void testCompleterTache() throws TacheInexistante {
        gestionTaches.ajouterTache("tâche 2", "Description de la tâche 2");
        gestionTaches.completerTache("tâche 2");
        assertTrue(gestionTaches.verifierTache("tâche 2"));
    }

    @Test
    public void testVerifierTache() throws TacheInexistante {
        gestionTaches.ajouterTache("Tâche 3", "Description de la tâche 3");
        assertFalse(gestionTaches.verifierTache("Tâche 3"));
    }

}
