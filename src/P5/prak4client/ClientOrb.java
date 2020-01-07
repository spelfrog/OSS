package P5.prak4client;

import P5.prak4gemklassen.*;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientOrb implements BenutzerVerwaltung {


    private final String internetAdd;

    public ClientOrb(String adresse) {
        internetAdd = adresse;
    }


    public void dbInitialisieren() {
        initData(true);
    }

    public void initData(boolean init) {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        Socket clientSocket = null;
        try {


            clientSocket = new Socket(internetAdd, 4711);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            System.err.println("Client: Versuche Übertragung für Datenhaltung");
            //Task 3
            out.write(3);
            out.writeBoolean(init);
            out.flush();

        } catch (IOException ex) {
            System.err.println("Client: Übertragung für die Datenhaltung- Fehler!!!");
        } finally {
            try {
                if (out != null && in != null && clientSocket != null) {


                    out.close();
                    in.close();
                    clientSocket.close();

                }

            } catch (IOException ex) {
            }

        }
    }

    public boolean isConnectionPossible() {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        Socket clientSocket = null;

        try {


            clientSocket = new Socket(internetAdd, 4711);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());


        } catch (ConnectException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        } finally {
            try {
                if (out != null && in != null && clientSocket != null) {


                    out.close();
                    in.close();
                    clientSocket.close();

                }

            } catch (IOException ex) {
            }

        }
        return true;
    }


    @Override
    public void benutzerEintragen(Benutzer benutzer) throws BenutzerExits {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        Socket clientSocket = null;
        try {


            clientSocket = new Socket(internetAdd, 4711);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());


            System.err.println("Client: Versuche einen Benutzer einzutragen.");

            //Wähle Task 2.
            out.write(2);
            //Übergib an Server das Benutzerobjekt.
            out.writeObject(benutzer);

            //Empfange Nachricht von Server

            boolean exception = in.readBoolean();

            if (exception) {
                System.err.println("Client: Benutzer existiert bereits.");
                clientSocket.close();
                throw new BenutzerExits("Error");

            } else {
                System.err.println("Client: Benutzer wird eingetragen.");
                clientSocket.close();
            }


        } catch (IOException ex) {
            Logger.getLogger(ClientOrb.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (out != null && in != null && clientSocket != null) {


                    out.close();
                    in.close();
                    clientSocket.close();
                }

            } catch (IOException ex) {
            }
        }
    }

    @Override
    public boolean benutzerOk(Benutzer benutzer) {
        boolean ergebnis = false;
        Socket clientSocket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {


            clientSocket = new Socket(internetAdd, 4711);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            System.err.println("Client: Stelle Anfrage, ob LogIn richtig ist.");
            //Wähle Task 1.
            out.write(1);

            //Übergib einen Benutzer.
            out.writeObject(benutzer);
            out.flush();

            System.out.println(benutzer.toString());
            //Empfange die Information vom Server

            ergebnis = in.readBoolean();

            //Schließe die Verbindung zum Server
            System.err.println("Client: Login ist " + ergebnis);
            clientSocket.close();


            //Rückgabe der Anfrage

        } catch (IOException ex) {
        } finally {
            try {
                if (out != null && in != null && clientSocket != null) {


                    out.close();
                    in.close();
                    clientSocket.close();
                }


            } catch (IOException ex) {
                Logger.getLogger(ClientOrb.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        return ergebnis;
    }

    /*
    alternativer init
    @Override
    public void dbInitialisieren() {
        boolean ergebnis = false;
        Socket clientSocket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {


            clientSocket = new Socket(internetAdd, 4711);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());

            System.err.println("Client: Stelle Anfrage, für datenbank init.");
            //Wähle Task 3.
            out.write(3);

            //Datenbank soll neu.
            out.writeObject(true);
            out.flush();

            //Schließe die Verbindung zum Server
            System.err.println("Client: Login ist " + ergebnis);
            clientSocket.close();
        } catch (IOException ex) {
        } finally {
            try {
                if (out != null && in != null && clientSocket != null) {
                    out.close();
                    in.close();
                    clientSocket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientOrb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/

}
