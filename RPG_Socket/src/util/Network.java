package util;
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
    int etat;                   //      1: Serveur          2:Client
    public Network(int port, Session ses){
        this.port=port;
        session=ses;
    }

    public ServerSocket getServeur() {
        return serveur;
    }

    public void setServeur(ServerSocket serveur) {
        this.serveur = serveur;
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void demarrerServeur() throws Exception{
        serveur=new ServerSocket(port);
        Socket autreJoueur = serveur.accept();
        new ServerThread(autreJoueur, session).start();
        session.setMode(3);
        etat=1;
    }
    public void demarrerClient(){
        try {
            client = new Socket(IP, port);
            new ServerThread(client, session).start();
            session.setMode(3);
            etat=2;
        }catch(Exception e){
            session.setMode(4);
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
}
