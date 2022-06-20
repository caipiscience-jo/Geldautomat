package bankautomat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Klasse für den Bargeldautomaten
 */
public class ATM extends JFrame {
    // Konstanten für das Hauptmenü
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;
    private static ATM uniqueinstance;
    Iterator Users = BankDatabase.createIterator();
    private boolean userAuthenticated; // ist der*die Nutzer*in eingeloggt
    private int currentAccountNumber; // Kontonummer der eingeloggten Person
    private Screen screen; // Fenster des Bankautomaten
    private Keypad keypad; // Tastenblock des Bankautomaten
    private CashDispenser cashDispenser; // Auszahlungsteil des Bankautomaten
    private DepositSlot depositSlot; // Einzahlungsteil des Bankautomaten
    private BankDatabase bankDatabase; // Datenbank der Kontoinformationen
    private boolean AdminCheck;
    private String userinput = "";
    private int position = 0;

    /**
     * Argumentloser Konstruktor um die Instanzvariablen zu initialisieren
     */
    public ATM() {
        userAuthenticated = false; // Nutzer*in ist nicht erlaubt zu starten
        currentAccountNumber = 0; // keine aktuelle Kontonummer zum Starten
        screen = new Screen(); // erzeugt ein Fester

        keypad = new Keypad(); // erzeugt das Tastenfeld

        cashDispenser = new CashDispenser(); // erzeugt Auszahlungsteil
        depositSlot = new DepositSlot(); // erzeugt Einzahlungsteil
        bankDatabase = new BankDatabase(); // erzeugt Datenbank der Kontoinformationen
    } // Ende des argumentarlosen Konstruktors

    /**
     * erzeugt einen neuen Bargeldautomaten (Singleton-Muster)
     *
     * @return neuer Bargeldautomat
     */
    public static ATM getinstance() {
        if (uniqueinstance == null) {
            uniqueinstance = new ATM();
        }
        return uniqueinstance;
    }

    /**
     * Methode zum Starten des Bargeldautomaten
     */
    public void run() {
        // Begrüßung und Authentifizierung von Benutzern; Durchführung von Transaktionen
        startlogin(); // Benutzer authentifizieren
        // Durchlaufen, solange der Benutzer noch authentifiziert ist
        while (userAuthenticated == true) {
            performTransactions(4); // Benutzer ist jetzt authentifiziert
            userAuthenticated = false; // vor der nächsten Bankomat-Sitzung zurücksetzen
            currentAccountNumber = 0; // vor der nächsten Bankomat-Sitzung zurücksetzen
            screen.displayMessageLine("\nThank you! Goodbye!");
        } // Ende "while"

    } // Ende der Methode "run"

    /**
     * Generiert das Startfenster und authentifiziert Nutzer*in
     */
    void startlogin() {
        position = 0;
        screen.createlogin();
        userinput = "";

        authenticate check = new authenticate();
        screen.Mainframe.revalidate();
        screen.Inputfield2.setText("");
        keypad.setbuttons();
        addkeypadlisteners();

        screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);

        screen.Mainframe.revalidate();
        keypad.BEnter.addActionListener(check);
        screen.Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.Mainframe.setSize(400, 280); // Einstellen der Rahmengröße
        screen.Mainframe.setVisible(true);
        screen.Mainframe.revalidate();
    }

    /**
     * Überprüft, ob eingegebene Pin einem Konto zugeordnet werden kann und ob dies
     * ein Administratorzugang ist
     *
     * @param pin eingegebene Pin
     */
    public void authenticateuser(int pin) {
        userAuthenticated = bankDatabase.authenticateUser(pin);

        // prüfen, ob die Authentifizierung erfolgreich war
        if (userAuthenticated) {
            int accountNumber = bankDatabase.getaccpin(pin);
            AdminCheck = bankDatabase.getadmin(pin);
            if (AdminCheck == false) {
                currentAccountNumber = accountNumber;
                screen.Mainframe.getContentPane().removeAll();
                screen.Mainframe.revalidate();
                createmenu();
                screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
                screen.Mainframe.revalidate();
            } else {
                createAdminGUI();
                Iterator UserIterator = BankDatabase.createIterator();
                Addcheck check = new Addcheck();
                Deletecheck check2 = new Deletecheck();
                screen.button2.addActionListener(check);
                screen.button3.addActionListener(check2);
                currentAccountNumber = accountNumber; // Speichern des Benutzerkontos

            }
        } // Ende if
        else
            screen.messageJLabel3.setText("Invalid account number or PIN. Please try again.");
    } // Ende Methode "authenticateUser"

    /**
     * Generiert das Hauptmenü nach erfolgreichem Login eines normalen Kontos
     */
    public void createmenu() {
        screen.setSize(300, 150);
        balancecheck check1 = new balancecheck();
        Depositcheck check2 = new Depositcheck();
        Withdrawcheck check3 = new Withdrawcheck();
        Exitcheck check4 = new Exitcheck();
        screen.Mainframe.getContentPane().removeAll();
        screen.Mainframe.revalidate();
        // Fügt das Tastenfeld dem Fenster hinzu
        screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
        screen.createmenu();
        Account Account1 = bankDatabase.getAccount(currentAccountNumber);
        screen.messageJLabel.setText("Welcome " + Account1.getUsername()
                + "                                                                                   ");

        keypad.B1.addActionListener(check1);
        keypad.B2.addActionListener(check3);
        keypad.B3.addActionListener(check2);
        keypad.B4.addActionListener(check4);
        screen.Mainframe.revalidate();
    }

    /**
     * Erstellt das aufgerufene Menü
     *
     * @param a aufgerufenes Menü
     */
    private void performTransactions(int a) {

        // lokale Variable zur Speicherung der aktuell bearbeiteten Transaktion
        Transaction currentTransaction = null;

        currentTransaction = createTransaction(a);
        keypad.setbuttons();
        addkeypadlisteners();

        userinput = "";
        screen.Inputfield2.setText(userinput);
        currentTransaction.execute();

        Backcheck Back = new Backcheck();
        screen.Exit.addActionListener(Back);

        screen.Mainframe.revalidate();
    }

    /**
     * Überprüft welches der einzelnen Menüs (Einzahlung, Auszahlung, Kontostand)
     * erstellt werden soll
     *
     * @param type Typ des Menüs
     * @return das aufgerufene Menü
     */
    private Transaction createTransaction(int type) {
        Transaction temp = null; // temporäre Transaktionsvariable
        screen.getContentPane().removeAll();
        screen.revalidate();

        // bestimmen, welche Art von Transaktion erstellt werden soll

        if (type == 1) // eine neue Kontoübersicht-Transaktion erstellen
            temp = new BalanceInquiry(
                    currentAccountNumber, screen, bankDatabase);
        else if (type == 2)// neue Abhebungs-Transaktion erstellen
            temp = new Withdrawal(currentAccountNumber, screen,
                    bankDatabase, keypad, cashDispenser);
        else if (type == 3) { // neue Einzahlungs-Transaktion erstellen
            screen.setSize(400, 250);
            temp = new Deposit(currentAccountNumber, screen,
                    bankDatabase, keypad, depositSlot);
        }
        // Ende "switch"

        return temp; // Zurückgeben des neu erstellten Objekts
    }

    /**
     * Erstellt das Adminmenü. wenn das Feld "Isadmin" auf 1 gesetzt ist
     */
    public void createAdminGUI() {

        screen.Mainframe.getContentPane().removeAll();
        Nextcheck Ncheck = new Nextcheck();
        Prevcheck Pcheck = new Prevcheck();
        Exitcheck check4 = new Exitcheck();
        screen.Mainframe.revalidate();
        screen.createAdminpage();
        screen.button1.addActionListener(Ncheck);
        screen.button4.addActionListener(Pcheck);
        screen.Exit.addActionListener(check4);
        screen.Mainframe.revalidate();

    }

    /**
     * Actionlistener für die Tasten 0-9, sowie Clear und Check/Enter
     */
    public void addkeypadlisteners() {
        BCheck BC = new BCheck();
        BClear BC1 = new BClear();
        keypad.B1.addActionListener(BC);
        keypad.B2.addActionListener(BC);
        keypad.B3.addActionListener(BC);
        keypad.B4.addActionListener(BC);
        keypad.B5.addActionListener(BC);
        keypad.B6.addActionListener(BC);
        keypad.B7.addActionListener(BC);
        keypad.B8.addActionListener(BC);
        keypad.B9.addActionListener(BC);
        keypad.B0.addActionListener(BC);
        keypad.BClear.addActionListener(BC1);
    }

    /**
     * Zeigt das nächste Konto an, nach Klick auf den Button (Literator-Muster)
     *
     * @param Iterator
     */
    public void IterateUser(Iterator Iterator) {
        if (Iterator.hasNext(position) == true) {
            position = position + 1;
            // Anzeige des aktuellen Benutzers in der GUI-Meldungsanzeige.
            Account AccountItem = (Account) Iterator.next(position);
            screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
            screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
            screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());
        } else {
            // Zum ersten Konto springen, wenn man beim letzten Konto angekommen ist
            if (Iterator.hasNext(position) == false) {
                position = 0;
                // Anzeige des aktuellen Benutzers in der GUI-Meldungsanzeige.
                Account AccountItem = (Account) Iterator.next(position);
                screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
                screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
                screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());
            }
        }

    }

    /**
     * Zeigt das vorherige Konto an, nach Klick auf den Button (Literator-Muster)
     *
     * @param Iterator
     */
    public void prevIterateUser(Iterator Iterator) {
        if (Iterator.hasPrev(position) == true) {
            position = position - 1;
            Account AccountItem = (Account) Iterator.next(position);
            screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
            screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
            screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());

        } else {
            // Zum letzten Konto springen, wenn man beim ersten Konto angekommen ist
            if (Iterator.hasPrev(position) == false) {
                position = bankDatabase.accounts.size() - 1;
                Account AccountItem = (Account) Iterator.next(position);
                screen.messageJLabel2.setText("Username: " + AccountItem.getUsername());
                screen.messageJLabel3.setText("Avaliable Balance: " + AccountItem.getAvailableBalance());
                screen.messageJLabel4.setText("Avaliable Balance: " + AccountItem.getTotalBalance());
            }
        }
    }

    /**
     * Holt die eingegebene Pin aus dem Eingabefeld
     */
    private class authenticate implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // int accnum = Integer.parseInt(screen.Inputfield1.getText());
            int PIN = Integer.parseInt(screen.Inputfield2.getText());
            // Abruf der PIN aus dem GUI-Textfeld.
            authenticateuser(PIN);
        }
    }

    /**
     * Überprüft, ob Button für das Hinzufügen eines neuen Users geklickt wurde
     */
    private class Addcheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // "Action Listener" für das Hinzufügen von Benutzern.
            BankDatabase.Adduser();

        }
    }

    /**
     * Überprüft, ob Button zum Löschen eines Users geklickt wurde
     */
    private class Deletecheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // "Action Listener" für das Löschen von Benutzern.
            BankDatabase.Deleteuser(position);
            position = position - 1;

        }
    }
    // Ende der Methode "createTransaction"

    /**
     * Weiterleitung zur Übersicht über den Kontostand
     */
    private class balancecheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            userinput = "";
            performTransactions(1);
        }
    }

    /**
     * Weiterleitung zum Einzahlungsmenü
     */
    private class Depositcheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            userinput = "";
            performTransactions(3);
        }
    }

    // Dieser Code prüft, welche Taste auf dem Tastenfeld gedrückt wurde.

    /**
     * Weiterleitung zum Auszahlungsmenü
     */
    private class Withdrawcheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            userinput = "";
            performTransactions(2);
        }
    }

    /**
     * Ausloggen
     */
    private class Exitcheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // startlogin();
            System.exit(0);
        }
    }

    /**
     * Weiterleitung zum Hauptmenü
     */
    public class Backcheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Dies bringt den Benutzer zurück zum Hauptmenü.

            createmenu();
            screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
            screen.Mainframe.revalidate();
            userinput = "";
            screen.Inputfield2.setText(userinput);
        }
    }

    /**
     * Enter Button wurde gedrückt
     */
    public class BCheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            String label = b.getLabel();
            userinput = userinput + label;
            // Aktualisieren des Textfelds anhand der Eingaben des Benutzers.
            screen.Inputfield2.setText(userinput);

        }
    }

    /**
     * Clear Button wurde gedrückt
     */
    public class BClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Löschen des Eingabefeldes.
            userinput = "";
            screen.Inputfield2.setText(userinput);
        }
    }

    /**
     * Next Button wurde gedrückt (Literator-Muster)
     */
    public class Nextcheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            IterateUser(BankDatabase.createIterator());
        }
    }

    /**
     * Previous Button wurde gedrückt (Literator-Muster)
     */
    public class Prevcheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            prevIterateUser(BankDatabase.createIterator());
        }
    }

}

// Ende der Methode "actionPerformed"

// Ende i
// Ende der Klasse "ATM"

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/
