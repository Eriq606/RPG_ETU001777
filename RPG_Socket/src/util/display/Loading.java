package util.display;

import util.Match;

import javax.swing.*;
import java.awt.*;

public class Loading extends JPanel {
    Match match;
    public Loading(Match mat){
        match=mat;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(212, 100, 400, 600);
        g.drawString(match.getAllChars().get(match.getPerso1()).getNom(), 220, 110);
        if(match.getPerso2()!=null){
            g.drawRect(660, 100, 400, 600);
            g.drawString(match.getAllChars().get(match.getPerso2()).getNom(), 660, 110);
        }
        repaint();
    }
}
