package util.listen;

import util.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseCardListener implements ActionListener {
    Session session;
    int indexCard;
    public ChooseCardListener(Session ses, int indexC){
        session=ses;
        indexCard=indexC;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        session.getScreen().getBattleScreen().getCombattant1().setCurrentCard(indexCard);
        session.getScreen().getBattleScreen().getMenuCardLayout().next(session.getScreen().getBattleScreen().getMenuBox());
        session.getScreen().getBattleScreen().getMenu2CardLayout().first(session.getScreen().getBattleScreen().getMenu2());
        for(int i=0; i<session.getScreen().getBattleScreen().getCombattant1().getCurrentCard(); i++)
            session.getScreen().getBattleScreen().getMenu2CardLayout().next(session.getScreen().getBattleScreen().getMenu2());
        session.getMatch().setAction1(3);
    }
}
