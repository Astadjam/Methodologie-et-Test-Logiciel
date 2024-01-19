package com.test.exam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Projet {

    private String nom;
    private List<Tache> taches;
    private GestionTaches gestionTaches;

    public Projet(GestionTaches gestionTaches) {
        this.gestionTaches = gestionTaches;
        this.taches = new ArrayList<>();
    }

    public void ajouterTacheAuProjet(String titre, String description) throws TacheInexistante {
        gestionTaches.ajouterTache(titre, description);
        taches.add(new Tache(titre, description));
    }

    public void completerTacheDansLeProjet(String titre) throws TacheInexistante {
        gestionTaches.completerTache(titre);
        trouverTacheDansLeProjet(titre).completer();
    }

    public List<Tache> getTaches() {
        return taches;
    }

    private Tache trouverTacheDansLeProjet(String titre) throws TacheInexistante {
        for (Tache tache : taches) {
            if (tache.getTitre().equals(titre)) {
                return tache;
            }
        }
        throw new TacheInexistante("La tâche '" + titre + "' n'existe pas dans le projet.");
    }
}