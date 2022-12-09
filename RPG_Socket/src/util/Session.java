package util;
import util.network.SessionThread;

public class Session {
    Network network;
    Screen screen;
    Ressources ressources;
    int mode;               //      1: Serveur          2: Client       3: Connecté         4: Echec        5: Debut partie       6: Fin de partie
    Match match;
    public Session() throws Exception{
        network=new Network(9999, this);
        ressources=new Ressources();
        match=new Match(this);
        screen=new Screen(this);
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public Ressources getRessources() {
        return ressources;
    }

    public void setRessources(Ressources ressources) {
        this.ressources = ressources;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void start(){
        new SessionThread(this).start();
        screen.setVisible(true);
    }
}
