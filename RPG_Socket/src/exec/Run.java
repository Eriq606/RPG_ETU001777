package exec;

import assets.Attack;
import util.Screen;
import util.Session;
import util.display.ConnectScreen;

import java.util.Vector;

public class Run {
    public static void main(String[] args) throws Exception{
        Vector liste=new Attack().selectAll();
        for(int i=0; i<liste.size(); i++)
            System.out.println(((Attack)liste.get(i)).getNom()+" : "+((Attack)liste.get(i)).getDegats());
    }
}
