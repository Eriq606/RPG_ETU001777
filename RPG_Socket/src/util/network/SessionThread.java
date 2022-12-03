package util.network;

import util.Session;

public class SessionThread extends Thread{
    Session session;
    public SessionThread(Session ses){
        session=ses;
    }
    void vide(){}
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
            e.printStackTrace();
        }
    }
}
