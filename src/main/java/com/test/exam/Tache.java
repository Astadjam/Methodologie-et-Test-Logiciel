package com.test.exam;

public class Tache {

    private String titre;
    private String description;
    private boolean complete;
    private int duree;

    public Tache(String titre, String description, int duree) {
        this.titre = titre;
        this.description = description;
        this.complete = false;
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public boolean estComplete() {
        return complete;
    }

    public int getDuree() {
        return duree;
    }

    public void completer() {
        this.complete = true;
    }
}
