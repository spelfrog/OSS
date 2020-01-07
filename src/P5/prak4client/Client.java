package P5.prak4client;

import java.io.IOException;

import P5.prak4gemklassen.*;

public class Client implements BenutzerVerwaltung {


    private String internetAdd;

    Client(String adresse) {
        internetAdd = adresse;
    }

    public void addresseAendern(String adresse) {
        internetAdd = adresse;
    }

    void datenhaltung(boolean init) {
        ClientOrb corb = new ClientOrb(internetAdd);
        corb.initData(init);
    }

    boolean connectionTest() {
        ClientOrb corb = new ClientOrb(internetAdd);
        return corb.isConnectionPossible();
    }

    @Override
    public void benutzerEintragen(Benutzer benutzer) throws BenutzerExits {
        ClientOrb corb = new ClientOrb(internetAdd);
        corb.benutzerEintragen(benutzer);
    }

    @Override
    public boolean benutzerOk(Benutzer benutzer) {
        ClientOrb corb = new ClientOrb(internetAdd);
        return corb.benutzerOk(benutzer);


    }
}
