package util.listener;

import util.Client;

import javax.swing.*;

public class Remote {
    Client user;
    GameControl controls;
    public Remote(Client us){
        user=us;
        controls=new GameControl(this);
        JFrame frame=new JFrame();
        frame.setVisible(true);
        frame.addKeyListener(controls);
    }
}
