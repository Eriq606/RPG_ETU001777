package util;
public class Joueur {
    String nom;
    Manette manette;
    int id;
    public Joueur(String n){
        nom=n;
        manette=new Manette();
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Manette getManette() {
        return manette;
    }

    public void setManette(Manette manette) {
        this.manette = manette;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getInstruct(){
        return manette.instruct;
    }
}
