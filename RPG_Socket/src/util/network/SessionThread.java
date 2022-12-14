package util.network;
import util.Session;
import util.listen.ChooseCharacterListener;

import javax.swing.*;

public class SessionThread extends Thread{
    Session session;
    public SessionThread(Session ses){
        session=ses;
    }
    public void process() throws Exception{
        while(true){
            switch(session.getMode()){
                case 1:
                    session.getNetwork().demarrerServeur();
                    break;
                case 2:
                    session.getNetwork().demarrerClient();
                    break;
                case 3:
                    session.getScreen().getCardFull().next(session.getScreen().getFullUI());
                    session.setMode(0);
                    session.getScreen().addKeyListener(new ChooseCharacterListener(session));
                    break;
                case 5:
                    session.getScreen().getBattleScreen().preparePersos();
                    session.getScreen().getBattleScreen().prepare();
                    session.getScreen().getCardFull().next(session.getScreen().getFullUI());
                    session.setMode(0);
                    break;
                case 6:
                    session.getScreen().getWinScreen().preparePanel();
                    session.getScreen().getCardFull().next(session.getScreen().getFullUI());
                    session.setMode(0);
                    break;
                case 4:
                    session.getScreen().getCardFull().first(session.getScreen().getFullUI());
                    session.getScreen().getConnectScreen().getCardConnection().first(session.getScreen().getConnectScreen());
                    session.setMode(0);
                    break;
                default:
                    System.out.print("");
            }
        }
    }
    public void run(){
        try{
            process();
        }catch(Exception e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Alert", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
}
