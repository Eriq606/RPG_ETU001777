package exec;

import util.Server;

public class Run {
    public static void main(String[] args) throws  Exception{
        Server serveur=new Server(9999);
        serveur.process();
    }
}
