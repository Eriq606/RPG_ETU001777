package assets;

import util.BddObj;

import java.util.Vector;

public class Personnage extends BddObj {
    int idPersonnage;
    String nom;
    int idCardSetup;
    int idStatistiques;

    public int getIdPersonnage() {
        return idPersonnage;
    }

    public void setIdPersonnage(int idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdCardSetup() {
        return idCardSetup;
    }

    public void setIdCardSetup(int idCardSetup) {
        this.idCardSetup = idCardSetup;
    }

    public int getIdStatistiques() {
        return idStatistiques;
    }

    public void setIdStatistiques(int idStatistiques) {
        this.idStatistiques = idStatistiques;
    }

    public Personnage[] getAllPersonnages() throws Exception{
        Vector all=selectAll();
        Personnage[] allPersonnages=new Personnage[all.size()];
        for(int i=0; i<all.size(); i++)
            allPersonnages[i]=(Personnage)all.get(i);
        return allPersonnages;
    }
    public Personnage getPersonnageByID(Personnage[] liste) throws Exception{
        return (Personnage)getElementByID(liste);
    }
}
