package util;

import assets.Character;
import util.display.EnterIPWindow;
import util.listen.Manette;

import java.util.Vector;

public class Menu{
    int currLine;
    int currPerso;
    int currMode;
    String iPhost;
    Vector<Character> allChars;
    boolean started;
    Manette manette;
    public Menu(Manette manette) throws Exception{
        setManette(manette);
        allChars=Character.getAllCharacters();
    }

    public int getCurrLine() {
        return currLine;
    }

    public void setCurrLine(int currLine) {
        this.currLine = currLine;
    }

    public int getCurrPerso() {
        return currPerso;
    }

    public void setCurrPerso(int currPerso) {
        this.currPerso = currPerso;
    }

    public Manette getManette() {
        return manette;
    }

    public void setManette(Manette manette) {
        this.manette = manette;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getCurrMode() {
        return currMode;
    }

    public void setCurrMode(int currMode) {
        this.currMode = currMode;
    }

    public String getiPhost() {
        return iPhost;
    }

    public void setiPhost(String iPhost) {
        this.iPhost = iPhost;
    }

    public void choose() throws Exception{
        switch(manette.getInstruct()){
            case 37:
                if(currLine==0&&currPerso>0)
                    currPerso=currPerso-1;
                else if(currLine==1&&currMode>0)
                    currMode--;
                break;
            case 39:
                if(currLine==0&&currPerso<allChars.size()-1)
                    currPerso = currPerso + 1;
                else if(currLine==1&&currMode<1)
                    currMode++;
                break;
            case 38:
                if(currLine>0)
                    currLine--;
                break;
            case 40:
                if(currLine<2)
                    currLine++;
                break;
            case 65:
                if(currLine==2) {
                    started = true;
                    if(currMode==1)
                        new EnterIPWindow(this);
                }
                break;
        }
        manette.setInstruct(0);
    }
    public Character getCurrentCharacter(){
        return allChars.get(currPerso);
    }
}
