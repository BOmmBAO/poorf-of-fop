package tud.ai2.wise2021.model.bst;

import tud.ai2.wise2021.model.addressbook.AddressBookEntry;

/**
 * Stellte einen Knoten eines BSTs da.
 *
 * @author Kurt Cieslinski
 */
public class Node {

    /** linkes Kind */
    private Node left;
    /** rechtes Kind */
    private Node right;
    /** Wert des Knotens */
    private AddressBookEntry key;

    /**
     * Konstruktor.
     *
     * @param entry die Daten (ABE) des Knoten
     */
    public Node(AddressBookEntry entry){
        key = entry;
    }

    /**
     *
     * @return linkes Kind
     */
    public Node getLeft() {
        return left;
    }

    /**
     *
     * @param left zu setzen
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     *
     * @return rechtes Kind
     */
    public Node getRight() {
        return right;
    }

    /**
     *
     * @param right zu setzen
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     *
     * @return key
     */
    public AddressBookEntry getKey() {
        return key;
    }

    /**
     *
     * @param key zu setzten
     */
    public void setKey(AddressBookEntry key) {
        this.key = key;
    }
}
