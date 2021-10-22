package tud.ai2.wise2021.model.addressbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Adressbuch.
 *
 * @author Kurt Cieslinski
 */
public class AddressBook {

    /** Instanz des Adressbuches */
    private static AddressBook instance;
    /** Liste der Eintraege im Adressbuch */
    private List<AddressBookEntry> addressList;

    /**
     * Mit dieser Methode wird die einzig mögliche Instanz zurückgegeben.
     *
     * @return die einzig moegliche Instanz von AddressBook
     */
    public static AddressBook getInstance() {
        if (instance == null) instance = new AddressBook();
        return instance;
    }

    /**
     * Privater Konstruktor.
     * Wird maximal einmal aufgerufen.
     */
    private AddressBook() {
        addressList = new ArrayList<>();
    }

    /**
     * Fuegt ein AddressBookEntry der addressList hinzu.
     *
     * @param entry zu hinzufuegen
     */
    public void addEntry(AddressBookEntry entry) {
        addressList.add(entry);
    }

    /**
     *
     * @return addressList
     */
    public List<AddressBookEntry> getAddressList() {
        return addressList;
    }

    /**
     *
     * @param addressList zu setzen
     */
    public void setAddressList(List<AddressBookEntry> addressList) {
        this.addressList = addressList;
    }
}
