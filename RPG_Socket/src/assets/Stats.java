package assets;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class Stats {
    int id;
    int idperso;
    double hp;
    public Stats(int id, int idperso, double hp){
        setId(id);
        setIdperso(idperso);
        setHp(hp);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getIdperso() {
        return idperso;
    }

    public void setIdperso(int idperso) {
        this.idperso = idperso;
    }
    public static Vector<Stats> getAllStatss() throws Exception{
        Scanner scan=new Scanner(new File("H:/Eriq_RohWeltall/Prog/Java/IntelliJ/RPG/src/datas/stats.txt"));
        Vector<Stats> attacks=new Vector<Stats>();
        try{
            while(scan.hasNextLine()){
                String[] atk=scan.nextLine().split("::");
                Stats attack=new Stats(Integer.parseInt(atk[0]), Integer.parseInt(atk[1]), Double.parseDouble(atk[2]));
                attacks.add(attack);
            }
            return attacks;
        }finally{
            scan.close();
        }
    }
    public static Stats getStatsByIdPerso(Vector<Stats> liste, int idPerso){
        for(int i=0; i<liste.size(); i++){
            if(liste.get(i).getIdperso()==idPerso)
                return liste.get(i);
        }
        return liste.get(0);
    }
}
