package util;

public class Match {
    int perso1, perso2;
    int sent, received;     //      0: Undone       1: Done
    int phase;              //      0: Choosing         1: Started          2: Finished

    public int getPerso1() {
        return perso1;
    }

    public void setPerso1(int perso1) {
        this.perso1 = perso1;
    }

    public int getPerso2() {
        return perso2;
    }

    public void setPerso2(int perso2) {
        this.perso2 = perso2;
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }
}
