package util;

import java.net.Socket;

public class ClientThread extends Thread{
    Socket client;
    public ClientThread(Socket client, int nb){
        setClient(client);
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }
}
