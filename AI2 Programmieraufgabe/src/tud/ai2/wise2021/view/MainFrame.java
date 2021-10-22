package tud.ai2.wise2021.view;

import tud.ai2.wise2021.model.AddressBookIO;
import tud.ai2.wise2021.model.addressbook.AddressBook;
import tud.ai2.wise2021.model.addressbook.AddressBookEntry;
import tud.ai2.wise2021.model.addressbook.AddressBookFinder;
import tud.ai2.wise2021.model.bst.BST;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Das Hauptfenster der Adressbuch GUI
 *
 *
 * @author Kurt Cieslinski
 * @author Robert Cieslinski
 */
public class MainFrame extends JFrame {

    private JPanel panelEast, panelWest;

    private JTextField fieldFirstName, fieldLastName, fieldStreet, fieldFind, fieldIO;

    private JButton buttonAdd, buttonFind, buttonSave, buttonRead;

    private JComboBox<String> comboBox;

    private JTextArea textTable;


    public MainFrame(){
        super("Adressbuch");
        buildFrame();
    }

    /**
     * Diese Methode erstellt das MainFrame und beinhaltet die ActionListener der JButton buttonFind, buttonSave, buttonRead.
     *
     */
    private void buildFrame() {
        setSize(700,450);
        setLayout(new BorderLayout());
        ImageIcon img = new ImageIcon("assets/logo.png");
        setIconImage(img.getImage());

        panelEast = new JPanel();

        textTable = new JTextArea(25, 40);
        textTable.setEditable(false);
        panelEast.add(textTable);

        panelWest = new JPanel();

        panelWest.setLayout(new GridLayout(17,1));
        panelWest.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));


        JLabel labelFirstName = new JLabel("Vorname");
        panelWest.add(labelFirstName);

        fieldFirstName = new JTextField(20);
        panelWest.add(fieldFirstName);

        JLabel labelLastName = new JLabel("Nachname");
        panelWest.add(labelLastName);

        fieldLastName = new JTextField(20);
        panelWest.add(fieldLastName);

        JLabel labelStreet = new JLabel("Strasse");
        panelWest.add(labelStreet);

        fieldStreet = new JTextField(20);
        panelWest.add(fieldStreet);

        buttonAdd = new JButton("Add");
        buttonAdd.addActionListener((event) -> {
            String fn = fieldFirstName.getText();
            String ln = fieldLastName.getText();
            String st = fieldStreet.getText();
            if (fn.isBlank() || ln.isBlank() || st.isBlank())
                JOptionPane.showMessageDialog(this, new IllegalArgumentException("Ungueltige Eingabe"), "Error", JOptionPane.ERROR_MESSAGE);
            else {
                AddressBookEntry e = new AddressBookEntry(fn, ln, st);
                AddressBook.getInstance().addEntry(e);
                fieldFirstName.setText("");
                fieldLastName.setText("");
                fieldStreet.setText("");
                updateAddressView();
            }
        });
        panelWest.add(buttonAdd);

        panelWest.add(new JLabel());

        comboBox = new JComboBox<>(new String[]{"Nachname", "Vorname", "Strasse"});
        panelWest.add(comboBox);

        ////////////
        // TODO task 2d)


        ////////////

        panelWest.add(new JLabel());

        fieldFind = new JTextField("Gesuchter Nachname");
        panelWest.add(fieldFind);

        buttonFind = new JButton("Find");
        buttonFind.addActionListener(event -> {
            BST tree = new BST(AddressBook.getInstance().getAddressList());
            try{
                AddressBookEntry entry = AddressBookFinder.find(tree.getHead(), fieldFind.getText());
                JOptionPane.showMessageDialog(this, entry.toString());
            }catch (Exception e){
                JOptionPane.showMessageDialog(this, e,"Error", JOptionPane.ERROR_MESSAGE);
            }


        });
        panelWest.add(buttonFind);

        panelWest.add(new JLabel());

        fieldIO = new JTextField("Dateiname");
        panelWest.add(fieldIO);

        buttonSave = new JButton("Save");
        buttonSave.addActionListener(event -> {
            AddressBookIO.printAddressBook(fieldIO.getText());
            JOptionPane.showMessageDialog(this, "Erfolgreich als " + fieldIO.getText() + ".txt gespeichert!");
        });
        panelWest.add(buttonSave);

        buttonRead = new JButton(("Load"));
        buttonRead.addActionListener(event -> {

            try {
                AddressBookIO.readAddressBook(fieldIO.getText());
                JOptionPane.showMessageDialog(this, fieldIO.getText() + ".txt wurde erfolgreich geladen!!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e,"Error", JOptionPane.ERROR_MESSAGE);
            }


        });
        panelWest.add(buttonRead);

        updateAddressView();



        add(panelEast, BorderLayout.EAST);
        add(panelWest, BorderLayout.WEST);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     *  Diese Methode updatet den textTable.
     *  Sollte immer nach Veraenderung des Adressnucjes aufgerufen werden.
     */
    public void updateAddressView(){
        StringBuffer sb = new StringBuffer();
        sb.append("Vorname");
        sb.append('\t');
        sb.append("Nachname");
        sb.append('\t');
        sb.append("Strasse");
        sb.append('\n');
        sb.append("=".repeat(50));
        sb.append('\n');

        List<AddressBookEntry> list = AddressBook.getInstance().getAddressList();

        for(AddressBookEntry entry:list){
            sb.append(entry.getFirstName());
            sb.append('\t');
            sb.append(entry.getLastName());
            sb.append('\t');
            sb.append(entry.getStreet());
            sb.append('\n');
        }

        textTable.setText(sb.toString());
    }

    /**
     *
     * @return ausgewaehlten Eintrag der comboBox
     */
    public String getComboBoxItem(){
        return (String) comboBox.getSelectedItem();
    }

}
