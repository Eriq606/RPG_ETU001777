package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    Socket client;
    Match match;
    BufferedReader read;
    BufferedWriter write;
    public ClientThread(Socket client, int nb, Match match) throws Exception{
        setClient(client);
        setMatch(match);
        read=new BufferedReader(new InputStreamReader(client.getInputStream()));
        write=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
    public void process() throws Exception{
        int perso2=Integer.parseInt(read.readLine());
        match.setPerso2(perso2);
        int perso1=match.getPerso1();
        write.write(String.valueOf(perso1));
        write.newLine();
        write.flush();
        read.close();
        write.close();
    }
    public void run(){
        try{
            process();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
