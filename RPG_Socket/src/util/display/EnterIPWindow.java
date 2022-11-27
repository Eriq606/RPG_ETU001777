package util.display;

import util.Menu;
import util.listen.IPlisten;

import javax.swing.*;

public class EnterIPWindow extends JFrame {
    Menu menu;
    JTextField champ;
    public EnterIPWindow(Menu menu){
        setMenu(menu);
        preparePanel();
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public JTextField getChamp() {
        return champ;
    }

    public void setChamp(JTextField champ) {
        this.champ = champ;
    }

    public void preparePanel(){
        setSize(320, 120);
        setResizable(false);
        JPanel panel=new JPanel();
        JLabel label=new JLabel("IP Address");
        champ=new JTextField(15);
        JButton confirm=new JButton("Confirm");
        confirm.addActionListener(new IPlisten(this));
        Box out=new Box(1);
        Box in=new Box(0);
        in.add(label);
        in.add(champ);
        out.add(in);
        out.add(confirm);
        panel.add(out);
        add(panel);
        setVisible(true);
    }
}
