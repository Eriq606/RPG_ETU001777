package util.display;

import assets.Personnage;
import util.Session;
import util.listen.ReconnectListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class WinScreen extends JPanel {
    Session session;
    public WinScreen(Session ses){
        session=ses;
    }
    public void preparePanel() throws Exception{
        Box full=new Box(1);
        JButton restart = new JButton("Retour");
        restart.addActionListener(new ReconnectListener(session));
        if(session.getMatch().getVainqueur()!=0) {
            JLabel label = new JLabel("Vainqueur");
            JPanel imagePerso = new JPanel();
            JLabel imgPerso=new JLabel();
            Personnage vainqueur=new Personnage();
            vainqueur.setIdPersonnage(session.getMatch().getVainqueur());
            vainqueur=vainqueur.getPersonnageByID(session.getRessources().getPersonnages());
            ImageIcon icon=new ImageIcon(ImageIO.read(new File("./src/datas/images/"+vainqueur.getImage())));
            imgPerso.setIcon(icon);
            imagePerso.add(imgPerso);
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
            JLabel imgP1=new JLabel();
            ImageIcon icon1=new ImageIcon(ImageIO.read(new File("./src/datas/images/"+person1.getImage())));
            imgP1.setIcon(icon1);
            illustre1.add(imgP1);
            JLabel nom1 = new JLabel(person1.getNom());
            perso1.add(illustre1);
            perso1.add(nom1);
            Box perso2 = new Box(1);
            JPanel illustre2 = new JPanel();
            JLabel imgP2=new JLabel();
            ImageIcon icon2=new ImageIcon(ImageIO.read(new File("./src/datas/images/"+person2.getImage())));
            imgP2.setIcon(icon2);
            illustre2.add(imgP2);
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
