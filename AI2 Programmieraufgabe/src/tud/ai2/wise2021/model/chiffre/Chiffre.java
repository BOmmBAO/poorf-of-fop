package tud.ai2.wise2021.model.chiffre;

/**
 * Ein Interface fuer Chiffren.
 *
 * @author Robert Cieslinski
 */
public abstract class Chiffre {
    /** Alle moeglichen Zeichen */
    public static final String alphabet = "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ,.!?";

    /**
     * Gibt den Buchstaben am angegebenen Index des Alphabets zurueck.
     *
     * @param index Die Position des Buchstabens
     * @return Der Buchstabe am Index
     */
    public char charAt(int index) {
        while (index < 0) index += alphabetLenght();
        return alphabet.charAt(index % alphabetLenght());
    }

    /**
     * Gibt den Index des angegebenen Buchstabens im Alphabet zurueck.
     *
     * @param character Der zu suchende Buchstabe
     * @return Der Index des Buchstabens
     */
    public int indexOf(char character) {
        int index = alphabet.indexOf(character);
        if (index < 0) throw new IllegalArgumentException("Das Zeichen " + character +" ist nicht im Alphabet.");
        return index;
    }

    public int alphabetLenght() {
        return alphabet.length();
    }

    public abstract String decode(String chiffre, String key);

    public abstract String encode(String klartext, String key);
}
