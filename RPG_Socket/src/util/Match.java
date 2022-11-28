package util;

import assets.Character;

import java.util.Vector;

public class Match {
    Integer perso1, perso2;
    Vector<Character> allChars;
    int tour;
    int action;
    public Match(Vector<Character> all){
        allChars=all;
    }

    public Integer getPerso1() {
        return perso1;
    }

    public void setPerso1(int perso1) {
        this.perso1 = perso1;
    }

    public Integer getPerso2() {
        return perso2;
    }

    public void setPerso2(int perso2) {
        this.perso2 = perso2;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Vector<Character> getAllChars() {
        return allChars;
    }

    public void setAllChars(Vector<Character> allChars) {
        this.allChars = allChars;
    }
}
