package util.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControl implements KeyListener {
    Remote remote;
    public GameControl(Remote remote){
        this.remote=remote;
    }
    public void keyPressed(KeyEvent e){
        System.out.println("EEEEEEEEEEHHHHHHHHH?");
    }
    public void keyReleased(KeyEvent e){

    }
    public void keyTyped(KeyEvent e){

    }
}
