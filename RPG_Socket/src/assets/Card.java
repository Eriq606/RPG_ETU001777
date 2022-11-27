package assets;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Card {
    int id;
    String nom;
    Vector<Attack> attacks;
    public Card(int id, String nom){
        setId(id);
        setNom(nom);
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

    public Vector<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(Vector<Attack> attacks) {
        this.attacks = attacks;
    }

    public static Vector<Card> getAllCards() throws Exception{
        Scanner scan=new Scanner(new File("H:/Eriq_RohWeltall/Prog/Java/IntelliJ/RPG/src/datas/cards.txt"));
        Vector<Card> cartes=new Vector<Card>();
        try{
            Vector<Attack> attaques=Attack.getAllAttacks();
            while(scan.hasNextLine()){
                String[] crt=scan.nextLine().split("::");
                Card carte=new Card(Integer.parseInt(crt[0]), crt[1]);
                String[] atks=crt[2].split("!");
                Vector<Attack> itsAttacks=new Vector<Attack>();
                for(int i=0; i<atks.length; i++){
                    Attack atk=Attack.getAttackById(attaques, Integer.parseInt(atks[i]));
                    itsAttacks.add(atk);
                }
                carte.setAttacks(itsAttacks);
                cartes.add(carte);
            }
            return cartes;
        }finally{
            scan.close();
        }
    }
    public static Card getCardById(Vector<Card> liste, int id){
        for(int i=0; i<liste.size(); i++){
            if(liste.get(i).getId()==id)
                return liste.get(i);
        }
        return liste.get(0);
    }
}
