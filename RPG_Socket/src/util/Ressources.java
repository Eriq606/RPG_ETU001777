package util;

import assets.*;

public class Ressources {
    Personnage[] personnages;
    CardSetup[] cardSetups;
    Card[] cards;
    AttackSetup[] attackSetups;
    Attack[] attacks;
    public Ressources() throws Exception{
        personnages=new Personnage().getAllPersonnages();
        cardSetups=new CardSetup().getAllCardSetups();
        cards=new Card().getAllCards();
        attackSetups=new AttackSetup().getAllAttackSetups();
        attacks=new Attack().getAllAttacks();
    }

    public Personnage[] getPersonnages() {
        return personnages;
    }

    public void setPersonnages(Personnage[] personnages) {
        this.personnages = personnages;
    }

    public CardSetup[] getCardSetups() {
        return cardSetups;
    }

    public void setCardSetups(CardSetup[] cardSetups) {
        this.cardSetups = cardSetups;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public AttackSetup[] getAttackSetups() {
        return attackSetups;
    }

    public void setAttackSetups(AttackSetup[] attackSetups) {
        this.attackSetups = attackSetups;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }
}
