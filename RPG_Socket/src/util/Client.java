package util;

import java.net.Socket;

public class Client extends Socket {
    public Client(String host, int port) throws Exception{
        super(host, port);
    }
}
