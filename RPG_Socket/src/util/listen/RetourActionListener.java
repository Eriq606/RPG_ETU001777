package util.listen;

import util.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourActionListener implements ActionListener {
    Session session;
    public RetourActionListener(Session ses){
        session=ses;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        session.getScreen().getBattleScreen().getMenu1CardLayout().first(session.getScreen().getBattleScreen().getMenu1());
    }
}
