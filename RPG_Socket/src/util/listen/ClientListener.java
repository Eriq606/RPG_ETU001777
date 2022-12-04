package util.listen;
import util.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientListener implements ActionListener {
    Session session;
    public ClientListener(Session ses){
        session=ses;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        session.getScreen().getConnectScreen().getCardConnection().last(session.getScreen().getConnectScreen());
    }
}
