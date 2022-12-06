package assets;

import util.BddObj;

import java.util.Vector;

public class Statistiques extends BddObj {
    int idStatistiques;
    int hp;
    public int getIdStatistiques() {
        return idStatistiques;
    }

    public void setIdStatistiques(int idStatistiques) {
        this.idStatistiques = idStatistiques;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public Statistiques[] getAllStatistiques() throws Exception{
        Vector all=selectAll();
        Statistiques[] allStatistiquess=new Statistiques[all.size()];
        for(int i=0; i<all.size(); i++)
            allStatistiquess[i]=(Statistiques)all.get(i);
        return allStatistiquess;
    }
    public Statistiques getStatistiquesByID(Statistiques[] liste) throws Exception{
        return (Statistiques)getElementByID(liste);
    }
}
