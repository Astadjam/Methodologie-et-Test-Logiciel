package com.test.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CalculDureeTest {

    @Test
    public void testCalculDureeTotaleAvecTaches() {
        // Création d'une liste de tâches avec des durées positives
        List<Tache> taches = new ArrayList<>();
        taches.add(new Tache("Tache 1", "Desc Tache 1", 5));
        taches.add(new Tache("Tache 2", "Desc Tache 2", 8));
        taches.add(new Tache("Tache 3", "Desc Tache 3", 3));

        // Calculer la durée totale
        int dureeTotale = CalculDuree.calculerDureeTotale(taches);

        // Vérifier que la durée totale est correcte
        assertEquals(16, dureeTotale);
    }

    @Test
    public void testCalculDureeTotaleAvecTachesVide() {
        // Créer une liste vide de tâches
        List<Tache> taches = new ArrayList<>();

        // Calculer la durée totale
        int dureeTotale = CalculDuree.calculerDureeTotale(taches);

        // Vérifier que la durée totale est zéro pour une liste vide
        assertEquals(0, dureeTotale);
    }

    @Test
    public void testCalculDureeTotaleAvecTachesNegatives() {
        // Créer une liste de tâches avec des durées négatives
        List<Tache> taches = new ArrayList<>();
        taches.add(new Tache("Tache 1", "Desc Tache 1", -5));
        taches.add(new Tache("Tache 2", "Desc Tache 2", -8));
        taches.add(new Tache("Tache 3", "Desc Tache 3", -3));

        // Calculer la durée totale
        int dureeTotale = CalculDuree.calculerDureeTotale(taches);

        // Vérifier que la durée totale est zéro pour des durées négatives
        assertEquals(0, dureeTotale);
    }
}
