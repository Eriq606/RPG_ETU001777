package util.display;
import util.Session;
import util.listen.ClientListener;
import util.listen.ServerListener;
import util.listen.SubmitIPListener;

import javax.swing.*;
import java.awt.*;

public class ConnectScreen extends JPanel {
    Session session;
    JPanel networkChoose;
    JPanel serverWait;
    JPanel submitIPforClient;
    CardLayout cardConnection;
    public ConnectScreen(Session ses){
        session=ses;
        networkChoose=new JPanel();
        serverWait=new JPanel();
        submitIPforClient=new JPanel();
        cardConnection=new CardLayout();
        setLayout(cardConnection);
        prepare();
    }

    public CardLayout getCardConnection() {
        return cardConnection;
    }

    public void setCardConnection(CardLayout cardConnection) {
        this.cardConnection = cardConnection;
    }

    void prepareNetworkChoose(){
        Box full=new Box(1);
        JLabel choose=new JLabel("Choisir le mode de connexion");
        JButton serverButton=new JButton("Serveur");
        serverButton.addActionListener(new ServerListener(session));
        JButton clientButton=new JButton("Client");
        clientButton.addActionListener(new ClientListener(session));
        full.add(choose);
        full.add(serverButton);
        full.add(clientButton);
        networkChoose.add(full);
    }
    void prepareServerWait(){
        JLabel attente=new JLabel("En attente d'autre joueurs...");
        serverWait.add(attente);
    }
    void prepareSubmitIP(){
        Box full=new Box(1);
        JLabel entrerIP=new JLabel("Entrer l'addresse IP de l'hote");
        JTextField champIP=new JTextField(20);
        JButton submit=new JButton("Entrer");
        submit.addActionListener(new SubmitIPListener(champIP, session));
        full.add(entrerIP);
        full.add(champIP);
        full.add(submit);
        submitIPforClient.add(full);
    }
    void prepare(){
        prepareNetworkChoose();
        prepareServerWait();
        prepareSubmitIP();
        add(networkChoose);
        add(serverWait);
        add(submitIPforClient);
    }
}
