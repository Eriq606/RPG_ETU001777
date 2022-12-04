package assets;

import util.BddObj;

import java.util.Vector;

public class Attack extends BddObj {
    int idAttack;
    String nom;
    int degats;

    public int getIdAttack() {
        return idAttack;
    }

    public void setIdAttack(int idAttack) {
        this.idAttack = idAttack;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
    public Attack[] getAllAttacks() throws Exception{
        Vector all=selectAll();
        Attack[] allAttacks=new Attack[all.size()];
        for(int i=0; i<all.size(); i++)
            allAttacks[i]=(Attack)all.get(i);
        return allAttacks;
    }
    public Attack getAttackByID(Attack[] liste) throws Exception{
        return (Attack)getElementByID(liste);
    }
}
