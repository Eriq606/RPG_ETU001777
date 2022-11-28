package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends Socket {
    Match match;
    BufferedReader read;
    BufferedWriter write;
    public Client(String host, int port, Match match) throws Exception{
        super(host, port);
        setMatch(match);
        write=new BufferedWriter(new OutputStreamWriter(getOutputStream()));
        read=new BufferedReader(new InputStreamReader(getInputStream()));
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void process() throws Exception{
        int perso1=match.getPerso1();
        write.write(String.valueOf(perso1));
        write.newLine();
        write.flush();
        int perso2=Integer.parseInt(read.readLine());
        match.setPerso2(perso2);
        read.close();
        write.close();
    }
}
