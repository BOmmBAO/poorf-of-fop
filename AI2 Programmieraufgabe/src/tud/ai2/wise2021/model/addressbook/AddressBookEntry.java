package tud.ai2.wise2021.model.addressbook;

/**
 * Diese Klasse modelliert ein Adressbucheintrag.
 *
 * @author Kurt Cieslinski
 */
public class AddressBookEntry {

    /** Vorname */
    private String firstName;
    /** Nachname */
    private String lastName;
    /** Strasse */
    private String street;

    /**
     * Konstruktor.
     *
     * @param firstName Vorname
     * @param lastName Nachname
     * @param street Strasse
     */
    public AddressBookEntry(String firstName, String lastName, String street) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param firstName zu setzten
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName zu setzten
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param street zu setzten
     */
    public void setStreet(String street) {
        this.street = street;
    }

    // TODO task 2a)
    public int compare(AddressBookEntry entry, String s) throws IllegalArgumentException {
    	if(!s.equals("Strasse")||!s.equals("Vorname")||!s.equals("Nchname")) {
    		throw new IllegalArgumentException();
    	}
    	//vergleich Strasse
    	if(s.equals("Strasse")) {
    		return street.compareToIgnoreCase(entry.getStreet());
    	}
    	//vergleich Nachname
    	else if (s.equals("Nchname")){
    		if(compare(entry, "Strasse") == 0) {
    			return lastName.compareToIgnoreCase(entry.getLastName());
    		}
    		else {
    			return compare(entry, "Strasse");
    		}}
    	//vergleich Vorname
    	else if(s.equals("Vorname")) {
    		if(compare(entry, "Strasse") == 0 && compare(entry, "Nachname") == 0) {
    			return lastName.compareToIgnoreCase(entry.getLastName());
    		}
    		else if(compare(entry, "Strasse") == 0) {
    			return compare(entry, "Nachname");
    		}
    		else return compare(entry,"Strasse");
    	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return lastName + ", " + firstName + ", " + street;
    }
}
