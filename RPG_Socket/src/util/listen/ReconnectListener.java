package util.listen;

import util.Match;
import util.Network;
import util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReconnectListener implements ActionListener {
    Session session;
    public ReconnectListener(Session ses){
        session=ses;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            session.getScreen().dispose();
            session=new Session();
            session.start();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();
        }
    }
}
