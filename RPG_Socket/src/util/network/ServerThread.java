package util.network;
import util.Match;
import util.Session;

import javax.swing.*;
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
    void send(String message) throws Exception{
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
    void receiveAction() throws Exception{
        String message=fromClient.readLine();
        String[] actions=message.split("::");
        switch(Integer.parseInt(actions[0])){
            case 1:
                session.getMatch().setAction2(1);
                break;
            case 2:
                session.getMatch().setAction2(2);
                session.getMatch().setMagic2(Integer.parseInt(actions[1]));
                break;
            case 3:
                session.getMatch().setAction2(3);
                break;
        }
        session.getMatch().setReceived(1);
    }
    void processPreparation() throws Exception{
        while(true){
            System.out.print("");
            if(session.getMatch().getSent()==0&&session.getMatch().getPerso1()!=0){
                send(String.valueOf(session.getMatch().getPerso1()));
                session.getMatch().setSent(1);
                receivePerso();
            }
            if(session.getMatch().getSent()==1&&session.getMatch().getReceived()==1) {
                session.getMatch().setPhase(1);
                session.getMatch().setSent(0);
                session.getMatch().setReceived(0);
                break;
            }
        }
    }
    void processMatch() throws Exception{
        while(true){
            System.out.print("");
            if(session.getMatch().getSent()==0&&session.getMatch().getAction1()!=0){
                send(String.valueOf(session.getMatch().getAction1()+"::"+session.getMatch().getMagic1()));
                session.getMatch().setSent(1);
                receiveAction();
            }
            if(session.getMatch().getSent()==1&&session.getMatch().getReceived()==1){
                session.getMatch().setProcess(2);
                session.getMatch().setSent(0);
                session.getMatch().setReceived(0);
                session.getMatch().execute();
            }
            if(session.getMode()==6)
                break;
        }
    }
    public void run(){
        try{
            processPreparation();
            session.setMode(5);
            processMatch();
            fromClient.close();
            writeToClient.close();
            client.close();
            if(session.getNetwork().getEtat()==1)
                session.getNetwork().getServeur().close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
}
