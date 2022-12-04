package util.display;

import assets.*;
import util.Session;
import util.listen.ChooseListener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MenuScreen extends JPanel {
    JPanel choosing;
    JPanel chosen;
    CardLayout cardLayout;
    Session session;
    Personnage[] allPersos;
    Vector<Vector<Card>> cardsUsed;
    Vector<Vector<Vector<Attack>>> attacksPerPerso;
    int currentCharacter;
    public MenuScreen(Session ses) throws Exception{
        session=ses;
        choosing=new JPanel();
        chosen=new JPanel();
        cardLayout=new CardLayout();
        setLayout(cardLayout);
        prepareAssets();
        prepare();
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public int getCurrentCharacter() {
        return currentCharacter;
    }

    public void setCurrentCharacter(int currentCharacter) {
        this.currentCharacter = currentCharacter;
    }

    void prepareAssets() throws Exception{
        allPersos=session.getRessources().getPersonnages();
        cardsUsed=new Vector<>();
        attacksPerPerso=new Vector<>();
        Card[] cards=session.getRessources().getCards();
        CardSetup[] allCardSetups=session.getRessources().getCardSetups();
        Attack[] attacks=session.getRessources().getAttacks();
        AttackSetup[] allAttackSetups=session.getRessources().getAttackSetups();
        for(int i=0; i< allPersos.length; i++){
            CardSetup cardSetup=new CardSetup();
            cardSetup.setIdCardSetup(allPersos[i].getIdCardSetup());
            cardSetup=cardSetup.getCardSetupByID(allCardSetups);
            Vector<Card> cardsUsedByPerso=cardSetup.getCardsSet(cards);
            cardsUsed.add(cardsUsedByPerso);
        }
        for(int i=0; i<cardsUsed.size(); i++){
            Vector<Vector<Attack>> attacksUsed=new Vector<>();
            for(int j=0; j<cardsUsed.get(i).size(); j++){
                AttackSetup attackSetup=new AttackSetup();
                attackSetup.setIdAttackSetup(cardsUsed.get(i).get(j).getIdAttackSetup());
                attackSetup=attackSetup.getAttackSetupByID(allAttackSetups);
                Vector<Attack> attacksOnCard=attackSetup.getAttacksSet(attacks);
                attacksUsed.add(attacksOnCard);
            }
            attacksPerPerso.add(attacksUsed);
        }
    }

    void prepareChoosing(){
        JPanel choose=new JPanel();
        Box full=new Box(1);
        JPanel upper=new JPanel();
        Box illustration=new Box(1);
        Box cards=new Box(1);
        JPanel image=new JPanel();
        JLabel nom=new JLabel(allPersos[currentCharacter].getNom());

        for(int i=0; i<cardsUsed.get(currentCharacter).size(); i++) {
            JPanel card = new JPanel();
            Box illustrCard=new Box(1);
            JPanel illustre=new JPanel();
            JLabel nomCard=new JLabel(cardsUsed.get(currentCharacter).get(i).getNom());
            illustrCard.add(illustre);
            illustrCard.add(nomCard);
            JPanel listeAtks = new JPanel();
            GridLayout gridAtk = new GridLayout(2, 2);
            listeAtks.setLayout(gridAtk);
            for(int k=0; k<attacksPerPerso.get(currentCharacter).get(i).size(); k++){
                JLabel nomAtk=new JLabel(attacksPerPerso.get(currentCharacter).get(i).get(k).getNom());
                listeAtks.add(nomAtk);
            }
            card.add(illustrCard);
            card.add(listeAtks);
            cards.add(card);
        }

        JButton confirm=new JButton("Confirmer");
        confirm.addActionListener(new ChooseListener(session));

        illustration.add(image);
        illustration.add(nom);
        upper.add(illustration);
        upper.add(cards);
        full.add(upper);
        full.add(confirm);
        choose.add(full);
        choosing=choose;
    }
    void prepareChosen(){
        JPanel hasChosen=new JPanel();
        Box illustration=new Box(1);
        JPanel image=new JPanel();
        JLabel nom=new JLabel("Personnage");
        illustration.add(image);
        illustration.add(nom);
        hasChosen.add(illustration);
        chosen=hasChosen;
    }
    void prepare(){
        prepareChoosing();
        prepareChosen();
        add(choosing);
        add(chosen);
    }
    public void reload(){
        prepareChoosing();
        prepareChosen();
    }
}
