package util.listen;

import util.display.EnterIPWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IPlisten implements ActionListener {
    EnterIPWindow ip;
    public IPlisten(EnterIPWindow ipEnter){
        setIp(ipEnter);
    }

    public EnterIPWindow getIp() {
        return ip;
    }

    public void setIp(EnterIPWindow ip) {
        this.ip = ip;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ipTyped=ip.getChamp().getText();
        System.out.println(ipTyped);
        ip.dispose();
    }
}
