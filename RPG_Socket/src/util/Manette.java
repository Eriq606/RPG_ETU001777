package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Manette implements KeyListener {
    int instruct;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        instruct=e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
