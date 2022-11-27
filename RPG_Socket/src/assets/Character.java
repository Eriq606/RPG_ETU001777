package assets;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Character {
    int id;
    String nom;
    Vector<Card> cartes;
    Stats stats;
    public Character(int id, String nom){
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

    public Vector<Card> getCartes() {
        return cartes;
    }

    public void setCartes(Vector<Card> cartes) {
        this.cartes = cartes;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public static Vector<Character> getAllCharacters() throws Exception{
        Scanner scan=new Scanner(new File("H:/Eriq_RohWeltall/Prog/Java/IntelliJ/RPG/src/datas/character.txt"));
        Vector<Character> chars=new Vector<Character>();
        try{
            Vector<Card> allCards=Card.getAllCards();
            Vector<Stats> stats=Stats.getAllStatss();
            while(scan.hasNextLine()){
                String[] pers=scan.nextLine().split("::");
                Character chara=new Character(Integer.parseInt(pers[0]), pers[1]);
                String[] carts=pers[2].split("!");
                Vector<Card> itsCards=new Vector<Card>();
                for(int i=0; i<carts.length; i++){
                    Card carte=Card.getCardById(allCards, Integer.parseInt(carts[i]));
                    itsCards.add(carte);
                }
                Stats stat=Stats.getStatsByIdPerso(stats, chara.getId());
                chara.setCartes(itsCards);
                chara.setStats(stat);
                chars.add(chara);
            }
            return chars;
        }finally{
            scan.close();
        }
    }
}
