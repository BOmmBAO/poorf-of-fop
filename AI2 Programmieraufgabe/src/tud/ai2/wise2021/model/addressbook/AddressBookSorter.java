package tud.ai2.wise2021.model.addressbook;

import java.util.List;

/**
 * Ein Sortierter fuer ein AddressBook.
 *
 * @author Kurt Cieslinski
 */
public class AddressBookSorter {

    // TODO task 2b)
    public static void sort(List<AddressBookEntry> list, String s) {
    	for (int i =1; i<list.size(); i++) {
    		for(int j= 0; j<list.size()-i-1; j++) {
    			if(list.get(j).compare(list.get(j+1), s) >0) {
    				AddressBookEntry chan = list.get(j);
    				list.set(j, list.get(j+1));
    				list.set(j+1, chan);
    			}
    		}
    	}

    }

}
