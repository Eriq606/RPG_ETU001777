package util.listen;

import util.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseMagicListener implements ActionListener {
    Session session;
    int idMagic;
    public ChooseMagicListener(Session ses, int idm){
        session=ses;
        idMagic=idm;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        session.getScreen().getBattleScreen().getMenuCardLayout().next(session.getScreen().getBattleScreen().getMenuBox());
        session.getMatch().setMagic1(idMagic);
        session.getMatch().setAction1(2);
    }
}
