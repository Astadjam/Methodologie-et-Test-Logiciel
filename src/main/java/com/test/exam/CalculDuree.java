package com.test.exam;

import java.util.List;

public class CalculDuree {

    public static int calculerDureeTotale(List<Tache> taches) {
        int dureeTotale = 0;

        for (Tache tache : taches) {
            // ne pas inclure les durées négatives
            if (tache.getDuree() > 0) {
                dureeTotale += tache.getDuree();
            }
        }

        return dureeTotale;
    }
}
