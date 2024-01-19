package com.test.exam;

public class Tache {

    private String titre;
    private String description;
    private boolean complete;

    public Tache(String titre, String description) {
        this.titre = titre;
        this.description = description;
        this.complete = false;
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

    public void completer() {
        this.complete = true;
    }
}
