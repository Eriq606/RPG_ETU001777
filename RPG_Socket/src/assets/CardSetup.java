package assets;

import util.BddObj;

import java.lang.reflect.Field;
import java.util.Vector;

public class CardSetup extends BddObj {
    int idCardSetup;
    int idCard1;
    int idCard2;
    int idCard3;

    public int getIdCardSetup() {
        return idCardSetup;
    }

    public void setIdCardSetup(int idCardSetup) {
        this.idCardSetup = idCardSetup;
    }

    public int getIdCard1() {
        return idCard1;
    }

    public void setIdCard1(int idCard1) {
        this.idCard1 = idCard1;
    }

    public int getIdCard2() {
        return idCard2;
    }

    public void setIdCard2(int idCard2) {
        this.idCard2 = idCard2;
    }

    public int getIdCard3() {
        return idCard3;
    }

    public void setIdCard3(int idCard3) {
        this.idCard3 = idCard3;
    }
    public CardSetup[] getAllCardSetups() throws Exception{
        Vector all=selectAll();
        CardSetup[] allCardSetups=new CardSetup[all.size()];
        for(int i=0; i<all.size(); i++)
            allCardSetups[i]=(CardSetup)all.get(i);
        return allCardSetups;
    }
    public CardSetup getCardSetupByID(CardSetup[] liste) throws Exception{
        return (CardSetup)getElementByID(liste);
    }
    public Vector<Card> getCardsSet(Card[] liste) throws Exception{
        Vector<Card> listeAtk=new Vector<Card>();
        Field[] champs= getClass().getDeclaredFields();
        for(int i=1; i<4; i++){
            Card attack=new Card();
            int idAtk=Integer.parseInt(getClass().getMethod("get"+BddObj.majStart(champs[i].getName())).invoke(this).toString());
            if(idAtk==0)
                continue;
            attack.setIdCard(idAtk);
            attack=attack.getCardByID(liste);
            listeAtk.add(attack);
        }
        return listeAtk;
    }
}
