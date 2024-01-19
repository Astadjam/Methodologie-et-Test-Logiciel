package com.test.exam;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class GestionTaches {

    // Liste pour stocker les tâches avec leur état completé ou non (true/false)
    private Map<String, Boolean> taches;

    // constructeur initialisant la liste vide
    public GestionTaches() {
        taches = new HashMap<>();
    }

    // Méthode pour ajouter une nouvelle tâche
    public void ajouterTache(String titre, String description, int duree) {
        // Ajoute la tâche à la liste avec l'état initial non-complété
        taches.put(titre, false);
    }

    // Méthode pour marquer une tâche comme complétée
    public void completerTache(String titre) throws TacheInexistante {
        // Vérifie si la tâche existe dans la liste
        if (taches.containsKey(titre)) {
            // Marquer la tâche comme complétée
            taches.put(titre, true);
        } else {
            // Afficher un message si la tâche n'existe pas
            throw new TacheInexistante("La tâche '" + titre + "' n'existe pas.");
        }
    }

    // Méthode pour vérifier si une tâche est complétée
    public boolean verifierTache(String titre) throws TacheInexistante {
        // Vérifie si la tâche existe dans la liste
        if (taches.containsKey(titre)) {
            // Retourner l'état de la tâche
            return taches.get(titre);
        } else {
            // Afficher un message si la tâche n'existe pas
            throw new TacheInexistante("La tâche '" + titre + "' n'existe pas.");
        }
    }

}
