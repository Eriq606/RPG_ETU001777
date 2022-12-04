package util;

import util.network.ClientThread;
import util.network.ServerThread;

import javax.swing.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Network {
    Session session;
    ServerSocket serveur;
    Socket client;
    int port;
    String IP;
    int message;
    public Network(int port, Session ses){
        this.port=port;
        session=ses;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
    public void demarrerServeur() throws Exception{
        serveur=new ServerSocket(port);
        Socket autreJoueur = serveur.accept();
        new ServerThread(autreJoueur, session).start();
        session.setMode(3);
    }
    public void demarrerClient() throws Exception{
        try {
            client = new Socket(IP, port);
            new ServerThread(client, session).start();
            session.setMode(3);
        }catch(Exception e){
            session.setMode(4);
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
}
