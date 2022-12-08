package util;

import assets.Attack;

public class Match {
    Session session;
    int perso1, perso2;
    int sent, received;     //      0: Undone       1: Done
    int phase;              //      0: Choosing         1: Started          2: Finished
    int process;            //      0: Choosing action      1: Waiting response     2: Executing actions
    int action1, action2;   //      1: Attack           2: Magic            3: Change card
    int magic1, magic2;
    public Match(Session ses){
        session=ses;
    }
    public int getPerso1() {
        return perso1;
    }

    public void setPerso1(int perso1) {
        this.perso1 = perso1;
    }

    public int getPerso2() {
        return perso2;
    }

    public void setPerso2(int perso2) {
        this.perso2 = perso2;
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public int getAction1() {
        return action1;
    }

    public void setAction1(int action1) {
        this.action1 = action1;
    }

    public int getAction2() {
        return action2;
    }

    public void setAction2(int action2) {
        this.action2 = action2;
    }

    public int getMagic1() {
        return magic1;
    }

    public void setMagic1(int magic1) {
        this.magic1 = magic1;
    }

    public int getMagic2() {
        return magic2;
    }

    public void setMagic2(int magic2) {
        this.magic2 = magic2;
    }
    public void execute() throws Exception{
        switch(session.getMatch().getAction1()){
            case 1:
                session.getScreen().getBattleScreen().getCombattant2().setHpRestants(session.getScreen().getBattleScreen().getCombattant2().getHpRestants()-10);
                session.getScreen().getBattleScreen().getLabel1().setText(session.getScreen().getBattleScreen().getCombattant1().getPersonnage().getNom()+" a utilise Attaque normale");
                break;
            case 2:
                Attack attack=new Attack();
                attack.setIdAttack(session.getMatch().getMagic1());
                attack=attack.getAttackByID(session.getRessources().getAttacks());
                session.getScreen().getBattleScreen().getCombattant2().setHpRestants(session.getScreen().getBattleScreen().getCombattant2().getHpRestants()-attack.getDegats());
                session.getScreen().getBattleScreen().getLabel1().setText(session.getScreen().getBattleScreen().getCombattant1().getPersonnage().getNom()+" a utilise "+attack.getNom());
                break;
            case 3:
                session.getScreen().getBattleScreen().getLabel1().setText(session.getScreen().getBattleScreen().getCombattant1().getPersonnage().getNom()+" a change de carte");
                break;
        }
        switch(session.getMatch().getAction2()){
            case 1:
                session.getScreen().getBattleScreen().getCombattant1().setHpRestants(session.getScreen().getBattleScreen().getCombattant1().getHpRestants()-10);
                session.getScreen().getBattleScreen().getLabel2().setText(session.getScreen().getBattleScreen().getCombattant2().getPersonnage().getNom()+" a utilise Attaque normale");
                break;
            case 2:
                Attack attack=new Attack();
                attack.setIdAttack(session.getMatch().getMagic2());
                attack=attack.getAttackByID(session.getRessources().getAttacks());
                session.getScreen().getBattleScreen().getCombattant1().setHpRestants(session.getScreen().getBattleScreen().getCombattant1().getHpRestants()-attack.getDegats());
                session.getScreen().getBattleScreen().getLabel2().setText(session.getScreen().getBattleScreen().getCombattant2().getPersonnage().getNom()+" a utilise "+attack.getNom());
                break;
            case 3:
                session.getScreen().getBattleScreen().getLabel2().setText(session.getScreen().getBattleScreen().getCombattant2().getPersonnage().getNom()+" a change de carte");
                break;
        }
        session.getScreen().getBattleScreen().getMenuCardLayout().next(session.getScreen().getBattleScreen().getMenuBox());
        session.getScreen().getBattleScreen().getLabelHP1().setText("HP: "+session.getScreen().getBattleScreen().getCombattant1().getHpRestants()+"/"+session.getScreen().getBattleScreen().getCombattant1().getHpTotal());
        session.getScreen().getBattleScreen().getLabelHP2().setText("HP: "+session.getScreen().getBattleScreen().getCombattant2().getHpRestants()+"/"+session.getScreen().getBattleScreen().getCombattant2().getHpTotal());
        Thread.sleep(2000);
        action1=0;
        action2=0;
        magic1=0;
        magic2=0;
        for(int i=0; i<session.getScreen().getBattleScreen().getMyCards().size(); i++){
            if(i==session.getScreen().getBattleScreen().getCombattant1().getCurrentCard())
                session.getScreen().getBattleScreen().getMyCards().get(i).setEnabled(false);
            else
                session.getScreen().getBattleScreen().getMyCards().get(i).setEnabled(true);
        }
        session.getScreen().getBattleScreen().getMenu1CardLayout().first(session.getScreen().getBattleScreen().getMenu1());
        session.getScreen().getBattleScreen().getMenuCardLayout().first(session.getScreen().getBattleScreen().getMenuBox());
    }
}
