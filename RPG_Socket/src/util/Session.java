package util;
import util.network.SessionThread;

public class Session {
    Network network;
    Screen screen;
    Ressources ressources;
    int mode;               //      1: Serveur          2: Client       3: Connecté         4: Echec
    public Session() throws Exception{
        network=new Network(9999, this);
        screen=new Screen(this);
        ressources=new Ressources();
        new SessionThread(this).start();
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
}
