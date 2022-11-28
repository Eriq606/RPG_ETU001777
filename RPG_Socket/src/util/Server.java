package util;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerSocket {
    int nbClients;
    Match match;
    public Server(int port, Match match) throws Exception{
        super(port);
        setMatch(match);
    }

    public int getNbClients() {
        return nbClients;
    }

    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void waiting() throws Exception{
        while(nbClients<1){
            Socket client=accept();
            new ClientThread(client, nbClients++, match).start();
        }
    }
}
