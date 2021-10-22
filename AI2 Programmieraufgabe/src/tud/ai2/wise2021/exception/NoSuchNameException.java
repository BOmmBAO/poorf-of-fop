package tud.ai2.wise2021.exception;
import tud.ai2.wise2021.model.addressbook.*;
import java.util.ArrayList;
import java.util.List;

public class NoSuchNameException extends Exception {
	private final List<AddressBookEntry> wrongList;
	public String s;
	private final List<AddressBookEntry> list;

}
