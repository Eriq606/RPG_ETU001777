package util.listen;

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

    public int getInstruct() {
        return instruct;
    }

    public void setInstruct(int instruct) {
        this.instruct = instruct;
    }
}
