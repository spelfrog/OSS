package P5.prak4serv;

import P5.prak4serv.BenutzerVerwaltungAdmin;

import java.io.IOException;

public class Server {
    private final BenutzerVerwaltungAdmin bv;

    Server() throws IOException {

        bv = new BenutzerVerwaltungAdmin();

        ServerOrb so = new ServerOrb(bv);

    }

    public static void main(String[] args) {
        try {
            Server launch = new Server();

        } catch (IOException ex) {
            System.err.println("Fehler beim Starten des Servers");
        }
    }

}
