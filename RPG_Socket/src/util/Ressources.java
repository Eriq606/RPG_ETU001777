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
}
