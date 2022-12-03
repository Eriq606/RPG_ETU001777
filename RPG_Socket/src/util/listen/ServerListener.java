package util.listen;

import util.Screen;
import util.Session;
import util.display.ConnectScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerListener implements ActionListener {
    Session session;
    public ServerListener(Session ses){
        session=ses;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        session.getScreen().getConnectScreen().getCardConnection().next(session.getScreen().getConnectScreen());
        session.setMode(1);
    }
}
