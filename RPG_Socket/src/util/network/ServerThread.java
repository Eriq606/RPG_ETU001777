package util.network;

import util.Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket client;
    Network network;
    public ServerThread(Socket cl, Network net){
        client=cl;
        network=net;
    }
    void process() throws Exception{
        BufferedReader fromClient=new BufferedReader(new InputStreamReader(client.getInputStream()));
        while(true){
            String message=fromClient.readLine();
            int mes=Integer.parseInt(message);
            if(mes>0)
                network.setMessage(mes);
        }
    }
    public void run(){
        try{
            process();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
