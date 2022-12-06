package util;

import assets.*;

public class Ressources {
    Personnage[] personnages;
    Statistiques[] statistiques;
    CardSetup[] cardSetups;
    Card[] cards;
    AttackSetup[] attackSetups;
    Attack[] attacks;
    public Ressources() throws Exception{
        personnages=new Personnage().getAllPersonnages();
        statistiques=new Statistiques().getAllStatistiques();
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

    public Statistiques[] getStatistiques() {
        return statistiques;
    }

    public void setStatistiques(Statistiques[] statistiques) {
        this.statistiques = statistiques;
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
