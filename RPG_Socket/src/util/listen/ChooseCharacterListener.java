package util.listen;
import util.Session;
import util.display.MenuScreen;
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
                menu.getChoosingLayout().previous(menu.getChoosing());
                menu.setCurrentCharacter(menu.getCurrentCharacter()-1);
                if(menu.getCurrentCharacter()<0)
                    menu.setCurrentCharacter(nbOfPerso-1);
                break;
            case 39:
                menu.getChoosingLayout().next(menu.getChoosing());
                menu.setCurrentCharacter(menu.getCurrentCharacter()+1);
                if(menu.getCurrentCharacter()==nbOfPerso)
                    menu.setCurrentCharacter(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
