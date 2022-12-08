package util.display;

import assets.*;
import util.Match;
import util.Session;
import util.listen.ChooseActionListener;
import util.listen.ChooseCardListener;
import util.listen.ChooseMagicListener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class BattleScreen extends JPanel {
    Session session;
    JPanel menuBox;
    CardLayout menuCardLayout;
    JPanel menu1;
    CardLayout menu1CardLayout;
    JPanel menu2;
    CardLayout menu2CardLayout;
    Combattants combattant1;
    Vector<JButton> myCards;
    Combattants combattant2;
    JLabel label1, label2;
    JLabel labelHP1, labelHP2;
    public BattleScreen(Session ses) throws Exception{
        session=ses;
        menuBox=new JPanel();
        menuCardLayout=new CardLayout();
        menuBox.setLayout(menuCardLayout);
        menu1=new JPanel();
        menu1CardLayout=new CardLayout();
        menu1.setLayout(menu1CardLayout);
        menu2=new JPanel();
        menu2CardLayout=new CardLayout();
        menu2.setLayout(menu2CardLayout);
        combattant1=new Combattants();
        myCards=new Vector<>();
        combattant2=new Combattants();
    }

    public JPanel getMenuBox() {
        return menuBox;
    }

    public void setMenuBox(JPanel menuBox) {
        this.menuBox = menuBox;
    }

    public CardLayout getMenuCardLayout() {
        return menuCardLayout;
    }

    public void setMenuCardLayout(CardLayout menuCardLayout) {
        this.menuCardLayout = menuCardLayout;
    }

    public JPanel getMenu1() {
        return menu1;
    }

    public void setMenu1(JPanel menu1) {
        this.menu1 = menu1;
    }

    public CardLayout getMenu1CardLayout() {
        return menu1CardLayout;
    }

    public void setMenu1CardLayout(CardLayout menu1CardLayout) {
        this.menu1CardLayout = menu1CardLayout;
    }

    public JPanel getMenu2() {
        return menu2;
    }

    public void setMenu2(JPanel menu2) {
        this.menu2 = menu2;
    }

    public CardLayout getMenu2CardLayout() {
        return menu2CardLayout;
    }

    public void setMenu2CardLayout(CardLayout menu2CardLayout) {
        this.menu2CardLayout = menu2CardLayout;
    }

    public Combattants getCombattant1() {
        return combattant1;
    }

    public void setCombattant1(Combattants combattant1) {
        this.combattant1 = combattant1;
    }

    public Vector<JButton> getMyCards() {
        return myCards;
    }

    public void setMyCards(Vector<JButton> myCards) {
        this.myCards = myCards;
    }

    public Combattants getCombattant2() {
        return combattant2;
    }

    public void setCombattant2(Combattants combattant2) {
        this.combattant2 = combattant2;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public JLabel getLabelHP1() {
        return labelHP1;
    }

    public void setLabelHP1(JLabel labelHP1) {
        this.labelHP1 = labelHP1;
    }

    public JLabel getLabelHP2() {
        return labelHP2;
    }

    public void setLabelHP2(JLabel labelHP2) {
        this.labelHP2 = labelHP2;
    }

    public void preparePersos() throws Exception{
        Personnage personnage1=new Personnage();
        personnage1.setIdPersonnage(session.getMatch().getPerso1());
        personnage1=personnage1.getPersonnageByID(session.getRessources().getPersonnages());
        Personnage personnage2=new Personnage();
        personnage2.setIdPersonnage(session.getMatch().getPerso2());
        personnage2=personnage2.getPersonnageByID(session.getRessources().getPersonnages());
        CardSetup cardSetup1=new CardSetup();
        cardSetup1.setIdCardSetup(personnage1.getIdCardSetup());
        cardSetup1=cardSetup1.getCardSetupByID(session.getRessources().getCardSetups());
        Vector<Card> myCards=cardSetup1.getCardsSet(session.getRessources().getCards());
        Statistiques stats1=new Statistiques();
        stats1.setIdStatistiques(personnage1.getIdStatistiques());
        stats1=stats1.getStatistiquesByID(session.getRessources().getStatistiques());
        Statistiques stats2=new Statistiques();
        stats2.setIdStatistiques(personnage2.getIdStatistiques());
        stats2=stats2.getStatistiquesByID(session.getRessources().getStatistiques());
        Vector<Vector<Attack>> myAttacks=new Vector<>();
        for(int i=0; i<myCards.size(); i++){
            AttackSetup setup=new AttackSetup();
            setup.setIdAttackSetup(myCards.get(i).getIdAttackSetup());
            setup=setup.getAttackSetupByID(session.getRessources().getAttackSetups());
            Vector<Attack> attacks=setup.getAttacksSet(session.getRessources().getAttacks());
            myAttacks.add(attacks);
        }

        combattant1.setPersonnage(personnage1);
        combattant1.setHpRestants(stats1.getHp());
        combattant1.setHpTotal(stats1.getHp());
        combattant1.setMyCards(myCards);
        combattant1.setMyAttacks(myAttacks);

        combattant2.setPersonnage(personnage2);
        combattant2.setHpRestants(stats2.getHp());
        combattant2.setHpTotal(stats2.getHp());
    }

    public void prepare(){
        Box full=new Box(1);
        JPanel allPersos=new JPanel();
        Box perso1=new Box(1);
        Box perso2=new Box(1);

        JPanel imagePerso1=new JPanel();
        JLabel nomPerso1=new JLabel(combattant1.getPersonnage().getNom());
        labelHP1=new JLabel("HP: "+combattant1.getHpRestants()+"/"+combattant1.getHpTotal());
        JPanel imagePerso2=new JPanel();
        JLabel nomPerso2=new JLabel(combattant2.getPersonnage().getNom());
        labelHP2=new JLabel("HP: "+combattant2.getHpRestants()+"/"+combattant2.getHpTotal());
        perso1.add(imagePerso1);
        perso1.add(nomPerso1);
        perso1.add(labelHP1);
        perso2.add(imagePerso2);
        perso2.add(nomPerso2);
        perso2.add(labelHP2);
        allPersos.add(perso1);
        allPersos.add(perso2);

        Box menu=new Box(1);
        JButton action1=new JButton("Attack");
        action1.addActionListener(new ChooseActionListener(session, 1));
        JButton action2=new JButton("Magie");
        action2.addActionListener(new ChooseActionListener(session, 2));
        JButton action3=new JButton("Change Card");
        action3.addActionListener(new ChooseActionListener(session, 3));
        menu.add(action1);
        menu.add(action2);
        menu.add(action3);
        menu1.add(menu);

        for(int j=0; j<combattant1.getMyCards().size(); j++) {
            menu = new Box(1);
            for (int i = 0; i < combattant1.getMyAttacks().get(j).size(); i++) {
                JButton magie = new JButton(combattant1.getMyAttacks().get(j).get(i).getNom());
                magie.addActionListener(new ChooseMagicListener(session, combattant1.getMyAttacks().get(j).get(i).getIdAttack()));
                menu.add(magie);
            }
            menu2.add(menu);
        }
        menu1.add(menu2);

        menu=new Box(1);
        for(int i=0; i<combattant1.getMyCards().size(); i++) {
            JButton carte = new JButton(combattant1.getMyCards().get(i).getNom());
            carte.addActionListener(new ChooseCardListener(session, i));
            if(i==combattant1.getCurrentCard())
                carte.setEnabled(false);
            myCards.add(carte);
            menu.add(myCards.lastElement());
        }
        menu1.add(menu);

        menuBox.add(menu1);

        JPanel waiting=new JPanel();
        JLabel wait=new JLabel("Waiting...");
        waiting.add(wait);
        menuBox.add(waiting);

        JPanel allActions=new JPanel();
        JPanel dialog1=new JPanel();
        label1=new JLabel("Joueur 1 a execute action 1");
        dialog1.add(label1);
        JPanel dialog2=new JPanel();
        label2=new JLabel("Joueur 2 a execute action 2");
        dialog2.add(label2);
        allActions.add(dialog1);
        allActions.add(dialog2);
        menuBox.add(allActions);

        full.add(allPersos);
        full.add(menuBox);
        add(full);
    }
}
