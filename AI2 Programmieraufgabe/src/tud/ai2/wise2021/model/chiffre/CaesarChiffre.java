package tud.ai2.wise2021.model.chiffre;

/**
 * Eine Caesar Chiffre.
 *
 * @author Robert Cieslinski
 */
public class CaesarChiffre extends Chiffre {

    /**
     * {@inheritDoc}
     */
    @Override
    public String encode(String klartext, String key) {
        char[] c = new char[klartext.length()];
        int schluessel = 42;
        try {
            schluessel = Integer.parseInt(key);
        } catch (Exception ignored) {
        }
        String k = klartext.toUpperCase(); // zur Verarbeitung von Kleinbuchstaben
        for (int i = 0; i < klartext.length(); i++) {
            int positiverSchluessel = schluessel % alphabet.length() + alphabet.length(); // auf jeden Fall positiv (so kann auch mit negativen Schluesseln gearbeitet werden, s. entschluesseln-Methode)
            int position = (indexOf(k.charAt(i)) + positiverSchluessel) % alphabet.length(); //Berechnung der Position des neuen Buchstaben.
            c[i] = charAt(position);
        }
        return new String(c); // Erzeugt einen neuen String aus dem char-Array
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String decode(String chiffre, String key) {
        int schluessel = 42;
        try {
            schluessel = Integer.parseInt(key);
        } catch (Exception ignored) {
        }
        return encode(chiffre, "-" + schluessel);
    }

}
