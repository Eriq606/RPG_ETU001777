package util;
import util.display.BattleScreen;
import util.display.ConnectScreen;
import util.display.MenuScreen;
import util.display.WinScreen;
import util.listen.ChooseCharacterListener;
import util.listen.MouseListener;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    Session session;
    JPanel fullUI;
    CardLayout cardFull;
    ConnectScreen connectScreen;
    MenuScreen menuScreen;
    BattleScreen battleScreen;
    WinScreen winScreen;
    public Screen(Session ses) throws Exception{
        session=ses;
        fullUI=new JPanel();
        cardFull=new CardLayout();
        fullUI.setLayout(cardFull);
        connectScreen=new ConnectScreen(session);
        fullUI.add(connectScreen);
        menuScreen=new MenuScreen(session);
        fullUI.add(menuScreen);
        battleScreen=new BattleScreen(session);
        fullUI.add(battleScreen);
        winScreen=new WinScreen(session);
        fullUI.add(winScreen);
        add(fullUI);
        addMouseListener(new MouseListener());
        setFocusable(true);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
    }

    public JPanel getFullUI() {
        return fullUI;
    }

    public void setFullUI(JPanel fullUI) {
        this.fullUI = fullUI;
    }

    public CardLayout getCardFull() {
        return cardFull;
    }

    public void setCardFull(CardLayout cardFull) {
        this.cardFull = cardFull;
    }

    public ConnectScreen getConnectScreen() {
        return connectScreen;
    }

    public void setConnectScreen(ConnectScreen connectScreen) {
        this.connectScreen = connectScreen;
    }

    public MenuScreen getMenuScreen() {
        return menuScreen;
    }

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

    public BattleScreen getBattleScreen() {
        return battleScreen;
    }

    public void setBattleScreen(BattleScreen battleScreen) {
        this.battleScreen = battleScreen;
    }

    public WinScreen getWinScreen() {
        return winScreen;
    }

    public void setWinScreen(WinScreen winScreen) {
        this.winScreen = winScreen;
    }
}
