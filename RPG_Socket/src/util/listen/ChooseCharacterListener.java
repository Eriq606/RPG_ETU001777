package util.listen;

import util.Screen;
import util.Session;
import util.display.MenuScreen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChooseCharacterListener implements KeyListener {
    Session session;
    public ChooseCharacterListener(Session ses){
        session=ses;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        MenuScreen menu=session.getScreen().getMenuScreen();
        int nbOfPerso=session.getRessources().getPersonnages().length;
        switch(e.getKeyCode()){
            case 37:
                if(menu.getCurrentCharacter()>0)
                    menu.setCurrentCharacter(menu.getCurrentCharacter()-1);
                break;
            case 39:
                if(menu.getCurrentCharacter()<nbOfPerso-1)
                    menu.setCurrentCharacter(menu.getCurrentCharacter()+1);
                break;
        }
        System.out.println(menu.getCurrentCharacter());
        menu.reload();
        session.getScreen().setVisible(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
