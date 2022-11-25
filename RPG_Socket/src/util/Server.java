package util;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerSocket {
    int port;
    public Server(int port) throws Exception{
        super(port);
        this.port=port;
    }
    public void process() throws Exception{
        Client meClient=new Client("localhost", port);
        while(true){
            Socket client=accept();
        }
    }
}
