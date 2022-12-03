package assets;

import util.BddObj;

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
}
