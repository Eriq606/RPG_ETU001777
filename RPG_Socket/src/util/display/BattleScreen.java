package util.display;

import util.Match;
import util.Session;

import javax.swing.*;
import java.awt.*;

public class BattleScreen extends JPanel {
    Session session;
    public BattleScreen(Session ses){
        session=ses;
    }
    void prepare(){
        Box full=new Box(1);
        Box perso1=new Box(1);
        Box perso2=new Box(1);
        Box menu=new Box(1);

        JPanel imagePerso1=new JPanel();
        JLabel hpPerso1=new JLabel("HP: 0/0");
        JPanel imagePerso2=new JPanel();
        JLabel hpPerso2=new JLabel("HP: 0/0");
        perso1.add(imagePerso1);
        perso1.add(hpPerso1);
        perso2.add(imagePerso2);
        perso2.add(hpPerso2);

        switch(session.getMatch().getPhase()){
            case 1:
                break;
        }
    }
}
