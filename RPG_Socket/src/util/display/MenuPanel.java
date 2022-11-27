package util.display;

import assets.Attack;
import assets.Card;
import assets.Character;
import assets.Stats;
import util.Game;
import util.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MenuPanel extends JPanel {
    Game game;
    public MenuPanel(Game game) throws Exception{
        setGame(game);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void paint(Graphics g){
        super.paint(g);
        try {
            game.getMenu().choose();
            Character current=game.getMenu().getCurrentCharacter();
            Stats stat=current.getStats();
            Vector<Card> cards=current.getCartes();
            g.drawRect(320, 75, 640, 450);
            g.drawString(current.getNom(), 350, 100);
            g.drawString("HP: "+stat.getHp(), 350, 150);
            for(int i=0; i<cards.size(); i++){
                g.drawRect(400+(i*300), 200, 200, 300);
                g.drawString(cards.get(i).getNom(), 425+(i*300), 225);
                Vector<Attack> attacks=cards.get(i).getAttacks();
                for(int j=0; j<attacks.size(); j++)
                    g.drawString(attacks.get(j).getNom()+": "+String.valueOf(attacks.get(j).getDegats()), 425+(i*300), 275+(j*25));
            }
            g.drawString("Network: ", 540, 550);
            g.drawString("Host", 600, 550);
            g.drawString("Client", 660, 550);
            g.drawString(String.valueOf(game.getMenu().getCurrMode()), 780, 550);
            g.drawString("Confirm", 600, 600);
            switch(game.getMenu().getCurrLine()){
                case 1:
                    g.drawRect(580+(game.getMenu().getCurrMode()*60), 530, 90, 20);
                    break;
                case 2:
                    g.drawRect(580, 580, 100, 30);
                    break;
            }
            if(game.getMenu().isStarted()){
                game.setState(1);
                return;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        repaint();
    }
}
