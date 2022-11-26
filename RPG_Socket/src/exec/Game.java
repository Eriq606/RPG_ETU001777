package exec;

import util.Joueur;
import assets.Map;
import util.Screen;

import java.util.Vector;

public class Game {
    Vector<Joueur> joueurs;
    Map map;
    Screen ecran;
    int currentMap;
    int nbJoueurs;
    boolean started;

    public Game(){
        joueurs=new Vector<Joueur>();
        nbJoueurs=0;
    }
    public Vector<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Vector<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Screen getEcran() {
        return ecran;
    }

    public void setEcran(Screen ecran) {
        this.ecran = ecran;
    }

    public int getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(int currentMap) {
        this.currentMap = currentMap;
    }
    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    public void addJoueur(Joueur joueur){
        joueurs.add(joueur);
        joueurs.lastElement().setId(nbJoueurs);
        nbJoueurs++;
    }
    public void envoyerInstruct(){

    }
}
