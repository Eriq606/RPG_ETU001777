package assets;

import java.util.Vector;

public class Map {
    Vector<Personnage> personnages;
    int maxJoueur;
    public Map() {
        personnages = new Vector<Personnage>();
        maxJoueur = 8;
    }
}
