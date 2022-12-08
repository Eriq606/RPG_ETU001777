package assets;

import java.util.Vector;

public class Combattants {
    Personnage personnage;
    int hpRestants, hpTotal;
    Vector<Card> myCards;
    Vector<Vector<Attack>> myAttacks;
    int currentCard;

    public int getHpRestants() {
        return hpRestants;
    }

    public void setHpRestants(int hpRestants) {
        this.hpRestants = hpRestants;
    }

    public int getHpTotal() {
        return hpTotal;
    }

    public void setHpTotal(int hpTotal) {
        this.hpTotal = hpTotal;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public Vector<Card> getMyCards() {
        return myCards;
    }

    public void setMyCards(Vector<Card> myCards) {
        this.myCards = myCards;
    }

    public Vector<Vector<Attack>> getMyAttacks() {
        return myAttacks;
    }

    public void setMyAttacks(Vector<Vector<Attack>> myAttacks) {
        this.myAttacks = myAttacks;
    }

    public int getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(int currentCard) {
        this.currentCard = currentCard;
    }
}
