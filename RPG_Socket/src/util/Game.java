package util;

import assets.Character;
import util.display.Loading;
import util.display.MenuPanel;
import util.display.Screen;
import util.listen.Manette;
import util.listen.Mouse;

import java.util.Vector;

public class Game {
    Manette manette;
    Screen screen;
    int state;
    Menu menu;
    Vector<Character> chars;
    Server server;
    Client client;
    Match match;
    public Game() throws Exception{
        manette=new Manette();
        screen=new Screen();
        screen.addKeyListener(manette);
        screen.addMouseListener(new Mouse());
        menu=new Menu(manette);
        chars=Character.getAllCharacters();
    }
    public Manette getManette() {
        return manette;
    }

    public void setManette(Manette manette) {
        this.manette = manette;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void launchMenu() throws Exception{
        MenuPanel menuPan=new MenuPanel(this);
        screen.add(menuPan);
        screen.setVisible(true);
    }
    public void launchNetwork() throws Exception{
        match=new Match(chars);
        int mode=menu.getCurrMode();
        match.setPerso1(menu.getCurrPerso());
        screen.add(new Loading(match));
        screen.setVisible(true);
        if(mode==0){
            server=new Server(9999, match);
            server.waiting();
        }else if(mode==1){
            client=new Client(null, 9999, match);
            client.process();
        }
    }
    public void launch() throws Exception{
        launchMenu();
        while(true){
            System.out.println();
            if(state==1)
                break;
        }
        launchNetwork();
    }
}
