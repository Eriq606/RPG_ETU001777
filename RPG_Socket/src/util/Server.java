package util;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerSocket {
    int nbClients;
    public Server(int port) throws Exception{
        super(port);
    }

    public int getNbClients() {
        return nbClients;
    }

    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }
    public void waiting() throws Exception{
        while(nbClients<1){
            Socket client=accept();
            new ClientThread(client, nbClients++).start();
        }
    }
}
