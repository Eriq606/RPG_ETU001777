package util.listen;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class MouseListener implements MouseInputListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
