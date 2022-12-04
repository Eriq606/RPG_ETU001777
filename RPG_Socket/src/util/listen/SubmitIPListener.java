package util.listen;
import util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitIPListener implements ActionListener {
    JTextField champ;
    Session session;
    public SubmitIPListener(JTextField champ, Session ses){
        this.champ=champ;
        session=ses;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String IP=champ.getText();
        session.getNetwork().setIP(IP);
        session.setMode(2);
    }
}
