package assets;

import util.BddObj;

import java.lang.reflect.Field;
import java.util.Vector;

public class AttackSetup extends BddObj {
    int idAttackSetup;
    int idAttack1;
    int idAttack2;
    int idAttack3;
    int idAttack4;

    public int getIdAttackSetup() {
        return idAttackSetup;
    }

    public void setIdAttackSetup(int idAttackSetup) {
        this.idAttackSetup = idAttackSetup;
    }

    public int getIdAttack1() {
        return idAttack1;
    }

    public void setIdAttack1(int idAttack1) {
        this.idAttack1 = idAttack1;
    }

    public int getIdAttack2() {
        return idAttack2;
    }

    public void setIdAttack2(int idAttack2) {
        this.idAttack2 = idAttack2;
    }

    public int getIdAttack3() {
        return idAttack3;
    }

    public void setIdAttack3(int idAttack3) {
        this.idAttack3 = idAttack3;
    }

    public int getIdAttack4() {
        return idAttack4;
    }

    public void setIdAttack4(int idAttack4) {
        this.idAttack4 = idAttack4;
    }
    public AttackSetup[] getAllAttackSetups() throws Exception{
        Vector all=selectAll();
        AttackSetup[] allAttackSetups=new AttackSetup[all.size()];
        for(int i=0; i<all.size(); i++)
            allAttackSetups[i]=(AttackSetup)all.get(i);
        return allAttackSetups;
    }
    public AttackSetup getAttackSetupByID(AttackSetup[] liste) throws Exception{
        return (AttackSetup)getElementByID(liste);
    }
    public Vector<Attack> getAttacksSet(Attack[] liste) throws Exception{
        Vector<Attack> listeAtk=new Vector<Attack>();
        Field[] champs= getClass().getDeclaredFields();
        for(int i=1; i<5; i++){
            Attack attack=new Attack();
            int idAtk=Integer.parseInt(getClass().getMethod("get"+BddObj.majStart(champs[i].getName())).invoke(this).toString());
            if(idAtk==0)
                continue;
            attack.setIdAttack(idAtk);
            attack=attack.getAttackByID(liste);
            listeAtk.add(attack);
        }
        return listeAtk;
    }
}
