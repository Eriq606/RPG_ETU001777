package util.listen;

import util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseListener implements ActionListener {
    Session session;
    public ChooseListener(Session ses){
        session=ses;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            session.getScreen().getMenuScreen().prepareChose();
            session.getScreen().getMenuScreen().getCardLayout().next(session.getScreen().getMenuScreen());
            session.getMatch().setPerso1(session.getRessources().getPersonnages()[session.getScreen().getMenuScreen().getCurrentCharacter()].getIdPersonnage());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();
        }
    }
}
