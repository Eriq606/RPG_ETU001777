package util.network;

import assets.Personnage;
import util.Network;
import util.Session;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket client;
    Session session;
    BufferedReader fromClient;
    BufferedWriter writeToClient;
    public ServerThread(Socket cl, Session ses) throws Exception{
        client=cl;
        session=ses;
        fromClient=new BufferedReader(new InputStreamReader(client.getInputStream()));
        writeToClient=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
    }
    void sendPerso(String message) throws Exception{
        writeToClient.write(message);
        writeToClient.newLine();
        writeToClient.flush();
    }
    void receivePerso() throws Exception{
        String message=fromClient.readLine();
        int mes=Integer.parseInt(message);
        if(mes!=0) {
            session.getMatch().setPerso2(mes);
            session.getMatch().setReceived(1);
        }
    }
    void processPreparation() throws Exception{
        while(true){
            System.out.print("");
            if(session.getMatch().getSent()==0&&session.getMatch().getPerso1()!=0){
                sendPerso(String.valueOf(session.getMatch().getPerso1()));
                session.getMatch().setSent(1);
                receivePerso();
            }
            if(session.getMatch().getSent()==1&&session.getMatch().getReceived()==1) {
                session.getMatch().setPhase(1);
                break;
            }
        }
    }
    public void run(){
        try{
            processPreparation();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
