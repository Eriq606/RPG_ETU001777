package util.listen;

import util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseActionListener implements ActionListener {
    Session session;
    int action;
    public ChooseActionListener(Session ses, int act){
        session=ses;
        action=act;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(action){
            case 1:
                session.getMatch().setAction1(1);
                session.getScreen().getBattleScreen().getMenuCardLayout().next(session.getScreen().getBattleScreen().getMenuBox());
                break;
            case 2:
                session.getScreen().getBattleScreen().getMenu1CardLayout().next(session.getScreen().getBattleScreen().getMenu1());
                break;
            case 3:
                session.getScreen().getBattleScreen().getMenu1CardLayout().last(session.getScreen().getBattleScreen().getMenu1());
                break;
        }
    }
}
