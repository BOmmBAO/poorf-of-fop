package tud.ai2.wise2021.model;

import edu.princeton.cs.introcs.Out;
import tud.ai2.wise2021.Launch;
import tud.ai2.wise2021.model.addressbook.AddressBook;
import tud.ai2.wise2021.model.addressbook.AddressBookEntry;
import tud.ai2.wise2021.model.chiffre.CaesarChiffre;
import tud.ai2.wise2021.model.chiffre.Chiffre;

import java.util.LinkedList;
import java.util.List;


/**
 * Diese Klasse verwaltet das Speichern und Laden von Adressbuechern.
 *
 * @author Kurt Cieslinski
 */
public class AddressBookIO {

    /** Eine Chiffre */
    private static final Chiffre chiffre = new CaesarChiffre();

    /**
     * Der zu verwendende Schluessel.
     * Dies ist relativ unsicher.
     * In richtigen Anwendungen sollten Schluessel immer sicher abgelegt werden!
     */
    private static final String key = "sicher";

    /**
     * Diese Methode speichert das aktuelle Adressbuch als .txt Datei im Projektordner ab.
     *
     * @param name Dateiname
     */
    public static void printAddressBook(String name) {
        Out file = new Out(name + ".txt");
        AddressBook.getInstance().getAddressList().forEach(e -> file.println(chiffre.encode(e.toString(), key)));
    }

    // TODO task 4
    public static void readAddressBook(String name) {
        String[] sArr;
        String decodedLine;
        List<AddressBookEntry> list = new LinkedList<>();

        while () {
            decodedLine =
            sArr = decodedLine.split(", ");
            list.add(new AddressBookEntry(sArr[1], sArr[0], sArr[2]));
        }

        Launch.frame.updateAddressView();
    }
}
