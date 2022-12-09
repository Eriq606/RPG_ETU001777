package util.display;

import assets.Personnage;
import util.Session;

import javax.swing.*;

public class WinScreen extends JPanel {
    Session session;
    public WinScreen(Session ses){
        session=ses;
    }
    public void preparePanel() throws Exception{
        Box full=new Box(1);
        JButton restart = new JButton("Retour");
        if(session.getMatch().getVainqueur()!=0) {
            JLabel label = new JLabel("Vainqueur");
            JPanel imagePerso = new JPanel();
            Personnage vainqueur=new Personnage();
            vainqueur.setIdPersonnage(session.getMatch().getVainqueur());
            vainqueur=vainqueur.getPersonnageByID(session.getRessources().getPersonnages());
            JLabel nomPerso = new JLabel(vainqueur.getNom());
            full.add(label);
            full.add(imagePerso);
            full.add(nomPerso);
            full.add(restart);
        }else {
            JLabel labelEqual = new JLabel("Le match s'est termine en match nul");
            JPanel persos = new JPanel();

            Personnage person1=new Personnage();
            person1.setIdPersonnage(session.getMatch().getPerso1());
            person1=person1.getPersonnageByID(session.getRessources().getPersonnages());
            Personnage person2=new Personnage();
            person2.setIdPersonnage(session.getMatch().getPerso2());
            person2=person2.getPersonnageByID(session.getRessources().getPersonnages());
            Box perso1 = new Box(1);
            JPanel illustre1 = new JPanel();
            JLabel nom1 = new JLabel(person1.getNom());
            perso1.add(illustre1);
            perso1.add(nom1);
            Box perso2 = new Box(1);
            JPanel illustre2 = new JPanel();
            JLabel nom2 = new JLabel(person2.getNom());

            perso2.add(illustre2);
            perso2.add(nom2);
            persos.add(perso1);
            persos.add(perso2);
            full.add(labelEqual);
            full.add(persos);
            full.add(restart);
        }
        add(full);
    }
}
