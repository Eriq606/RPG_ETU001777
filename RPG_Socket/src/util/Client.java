package util;

import util.display.Screen;
import util.listener.Remote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends Socket {
    BufferedWriter write;
    Remote gameRemote;
    Screen gameScreen;
    public Client(String host, int port) throws Exception{
        super(host, port);
        write=new BufferedWriter(new OutputStreamWriter(getOutputStream()));
        gameRemote=new Remote(this);
    }
}
