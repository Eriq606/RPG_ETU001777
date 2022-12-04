package assets;

import util.BddObj;

import java.util.Vector;

public class Card extends BddObj {
    int idCard;
    String nom;
    int idAttackSetup;

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdAttackSetup() {
        return idAttackSetup;
    }

    public void setIdAttackSetup(int idAttackSetup) {
        this.idAttackSetup = idAttackSetup;
    }
    public Card[] getAllCards() throws Exception{
        Vector all=selectAll();
        Card[] allCards=new Card[all.size()];
        for(int i=0; i<all.size(); i++)
            allCards[i]=(Card)all.get(i);
        return allCards;
    }
    public Card getCardByID(Card[] liste) throws Exception{
        return (Card)getElementByID(liste);
    }
}
