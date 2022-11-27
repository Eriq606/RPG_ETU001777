package assets;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Attack {
    int id;
    String nom;
    double degats;
    public Attack(int id, String nom, double degats){
        setId(id);
        setNom(nom);
        setDegats(degats);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getDegats() {
        return degats;
    }

    public void setDegats(double degats) {
        this.degats = degats;
    }
    public static Vector<Attack> getAllAttacks() throws Exception{
        Scanner scan=new Scanner(new File("H:/Eriq_RohWeltall/Prog/Java/IntelliJ/RPG/src/datas/attacks.txt"));
        Vector<Attack> attacks=new Vector<Attack>();
        try{
            while(scan.hasNextLine()){
                String[] atk=scan.nextLine().split("::");
                Attack attack=new Attack(Integer.parseInt(atk[0]), atk[1], Double.parseDouble(atk[2]));
                attacks.add(attack);
            }
            return attacks;
        }finally{
            scan.close();
        }
    }
    public static Attack getAttackById(Vector<Attack> liste, int id){
        for(int i=0; i<liste.size(); i++){
            if(liste.get(i).getId()==id)
                return liste.get(i);
        }
        return liste.get(0);
    }
}
