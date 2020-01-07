package P5.prak4serv;

import P5.prak4gemklassen.*;

import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;

public class ServerOrb {


    BenutzerVerwaltungAdmin bv;

    ServerOrb(BenutzerVerwaltungAdmin ref) {

        ServerSocket server = null;
        try {
            server = new ServerSocket(4711);
        } catch (IOException ex) {
        }

        bv = ref;

        System.err.println("Server: Start");
        while (true) {
            try {
                //Der Server läuft.
                Socket client = server.accept();
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

                // Über eine Nummer wird eine Task aufgerufen
                int task = in.read();


                //Task 1 BenutzerOK?
                switch (task) {
                    case 1: {
                        System.err.println("Server: Überprüfe, ob der Benutzer eingetragen ist.");
                        // Hier wird überprüuft, ob der Benutzer eingetragen ist.
                        Benutzer benutzer = null;
                        try {

                            benutzer = (Benutzer) in.readObject();
                            benutzer.toString();
                        } catch (ClassNotFoundException ex) {
                            //Error read Object
                        }
                        boolean abfrage = bv.benutzerOk(benutzer);
                        //Übergibt an Client die Information, ob Benutzer vorhanden

                        out.writeBoolean(abfrage);
                        out.flush();
                        //Task 2 Benutzer eintragen
                        break;
                    }
                    case 2: {
                        System.err.println("Server: Trage Benutzer ein.");
                        Benutzer benutzer = null;
                        try {

                            benutzer = (Benutzer) in.readObject();
                            benutzer.toString();
                        } catch (ClassNotFoundException ex) {
                            //Error read Object
                        }       //Trage den Benutzer ein
                        try {

                            bv.benutzerEintragen(benutzer);

                            out.writeBoolean(false);
                            out.flush();
                            System.err.println("Server: Benutzer wurde eingetragen.");
                        } catch (BenutzerExits ex) {
                            System.err.println("Server: Benutzer ist bereits eingetragen.");
                            out.writeBoolean(true);
                            out.flush();
                            //Übergibt die Exception, wenn Benutzer
                            //bereits eingetragen ist.
                        }


                        //Task 3 Datenhaltung
                        break;
                    }
                    case 3:
                        System.err.println("Server: Soll Datenhaltung initialisiert werden?");
                        boolean initalisierung = in.readBoolean();
                        if (initalisierung) {
                            System.err.println("Server: Datenhaltung wird initialisiert.");
                            bv.dbInitialisieren();
                        } else {
                            System.err.println("Server: Datenhaltung wird nicht initialisiert.");
                        }
                        break;
                    default:
                        break;
                }
            } catch (IOException ex) {
            }

        }
    }


}
