package tud.ai2.wise2021.model.bst;

import tud.ai2.wise2021.model.addressbook.AddressBookEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse modelliert einen BinarySearchTree
 *
 * @author Kurt Cieslinski, Robert Cieslinski
 */
public class BST {

    /**
     * Kopf / Wurzel des BSTs
     */
    private Node head;

    /**
     * Erstellt einen BST mit einem einzelnen Knoten.
     *
     * @param head die Ursprungswurzel
     */
    public BST(Node head) {
        this.head = head;
    }

    /**
     * Erstellt einen BST aus einer Liste mit AddressBookEntry.
     *
     * @param list zu verarbeitende Liste
     */
    public BST(List<AddressBookEntry> list) {
        if (list.isEmpty()) {
            head = null;
            return;
        }
        List<AddressBookEntry> cpy = new ArrayList<>(list);

        for (AddressBookEntry addressBookEntry : cpy) {
            insert(new Node(addressBookEntry));
        }
    }

    /**
     * Fuegt einen neuen Knoten in den BST ein und beachtet dabei die Ordnung.
     *
     * @param toInsert der einzufuegende Knoten
     */
    private void insert(Node toInsert) {
        Node x;
        Node prev;
        x = head;
        prev = null;
        while (x != null) {
            prev = x;
            if (x.getKey().getLastName().toLowerCase().compareTo(toInsert.getKey().getLastName().toLowerCase()) > 0)
                x = x.getLeft();
            else x = x.getRight();
        }
        if (prev == null)
            head = toInsert;
        else {
            if (prev.getKey().getLastName().toLowerCase().compareTo(toInsert.getKey().getLastName().toLowerCase()) > 0)
                prev.setLeft(toInsert);
            else
                prev.setRight(toInsert);
        }
    }

    /**
     * @return head
     */
    public Node getHead() {
        return head;
    }
}
