package util.display;

import util.Session;
import util.listen.ChooseListener;

import javax.swing.*;
import java.awt.*;

public class MenuScreen extends JPanel {
    JPanel choosing;
    JPanel chosen;
    CardLayout cardLayout;
    Session session;
    public MenuScreen(Session ses){
        session=ses;
        choosing=new JPanel();
        chosen=new JPanel();
        cardLayout=new CardLayout();
        setLayout(cardLayout);
        prepare();
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    void prepareChoosing(){
        Box full=new Box(1);
        JPanel upper=new JPanel();
        Box illustration=new Box(1);
        Box cards=new Box(1);
        JPanel image=new JPanel();
        JLabel nom=new JLabel("Personnage");

        JPanel card=new JPanel();
        JPanel illustrCard=new JPanel();
        JPanel listeAtks=new JPanel();
        GridLayout gridAtk=new GridLayout(2, 2);
        listeAtks.setLayout(gridAtk);
        JLabel atk1=new JLabel("Attack1");
        JLabel atk2=new JLabel("Attack2");
        JLabel atk3=new JLabel("Attack3");
        JLabel atk4=new JLabel("Attack4");
        listeAtks.add(atk1);
        listeAtks.add(atk2);
        listeAtks.add(atk3);
        listeAtks.add(atk4);
        card.add(illustrCard);
        card.add(listeAtks);

        JButton confirm=new JButton("Confirmer");
        confirm.addActionListener(new ChooseListener(session));

        illustration.add(image);
        illustration.add(nom);
        cards.add(card);
        upper.add(illustration);
        upper.add(cards);
        full.add(upper);
        full.add(confirm);
        choosing.add(full);
    }
    void prepareChosen(){
        Box illustration=new Box(1);
        JPanel image=new JPanel();
        JLabel nom=new JLabel("Personnage");
        illustration.add(image);
        illustration.add(nom);
        chosen.add(illustration);
    }
    void prepare(){
        prepareChoosing();
        prepareChosen();
        add(choosing);
        add(chosen);
    }
}
