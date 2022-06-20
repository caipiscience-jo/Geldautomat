package bankautomat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Klasse für das Menü der Auszahlung
 */
public class Withdrawal extends Transaction {
    // Menüoption zum Abbrechen
    private final static int CANCELED = 6;
    private int amount; // abzuhebender Betrag
    private Keypad keypad; // Verweis auf die Tastenfelder
    private CashDispenser cashDispenser; // Referenz zum Geldausgabeautomaten


    /**
     * Auszahlungs-Konstruktor
     *
     * @param userAccountNumber Kontonummer des Kontos
     * @param atmScreen         aktuelles Menü
     * @param atmBankDatabase   aktueller Datenbestand
     * @param atmKeypad         aktuelles Tastenfeld
     * @param atmCashDispenser  aktueller Auszahlungsautomat
     */
    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser) {
        // initialisiert superclass Variablen
        super(userAccountNumber, atmScreen, atmBankDatabase);

        // initialisiert Referenzen zum Tastaturfeld und dem Geldausgabeautomaten
        keypad = atmKeypad;
        cashDispenser = atmCashDispenser;
    } // Ende des "Withdrawal" Konstruktors


    /**
     * Führt das Geldabheben aus
     */
    @Override
    public void execute() {
        // zur Entnahme verfügbarer Betrag

        // Referenzen zum Bankdatenbestand und Bildschirm abrufen


        // Durchlaufen, bis Bargeld ausgezahlt wird oder der Benutzer abbricht
        displayMenuOfAmounts();
    }

    /**
     * Überprüft ob Person Geld ausgezahlt werden kann und setzt entsprechend Texte
     *
     * @param amount gewünschter auszuzahlender Betrag
     */
    public void transaction(int amount) {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();
        boolean cashDispensed = false; // Bargeld wurde noch nicht ausgezahlt
        double availableBalance;
        // prüfen, ob der Benutzer einen Abhebungsbetrag gewählt oder abgebrochen hat

        // den verfügbaren Betrag des betreffenden Kontos abrufen
        availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

        // prüfen, ob der Nutzer über genügend Geld auf dem Konto verfügt
        if (amount <= availableBalance) {
            // prüfen, ob der Geldausgabeautomat genügend Geld enthält
            if (cashDispenser.isSufficientCashAvailable(amount)) {
                // das betreffende Konto aktualisieren, um die Abhebung zu erfassen
                bankDatabase.debit(getAccountNumber(), amount);

                cashDispenser.dispenseCash(amount); // Bargeld ausgeben
                cashDispensed = true; // Bargeld wurde ausgegeben

                // Benutzer anweisen, Bargeld zu nehmen
                screen.messageJLabel7.setText("\nYour cash has been" + " dispensed. Please take your cash now.");
            } // Ende "if"
            else // Geldausgabeautomat enthält nicht genug Geld
                screen.messageJLabel7.setText("\nInsufficient cash available in the ATM." +
                        "\n\nPlease choose a smaller amount.");
        } // Ende "if"
        else // nicht genügend Geld auf dem Benutzerkonto vorhanden
        {
            screen.messageJLabel7.setText(
                    "\nInsufficient funds in your account." +
                            "\n\nPlease choose a smaller amount.");
        } // Ende "else"
    } // Ende "if"
    // Ende "else"


    // Ende der  Methode "execute"


    /**
     * Anzeige eines Menüs mit Abhebungsbeträgen und der Möglichkeit zum Abbruch, Rückgabe des gewählten Betrags oder 0, wenn der Benutzer den Vorgang abbrechen möchte
     */
    private void displayMenuOfAmounts() {

        int userChoice = 0; // lokale Variable zum Speichern des Rückgabewerts

        Screen screen = getScreen(); // Herstellen des Bezugs zum Bildschirm
        screen.createWithdrawGUI();
        screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
        withdraw1 check1 = new withdraw1();
        withdraw2 check2 = new withdraw2();
        withdraw3 check3 = new withdraw3();
        withdraw4 check4 = new withdraw4();
        withdraw5 check5 = new withdraw5();
        Keypad.B1.addActionListener(check1);
        Keypad.B2.addActionListener(check2);
        Keypad.B3.addActionListener(check3);
        Keypad.B4.addActionListener(check4);
        Keypad.B5.addActionListener(check5);


        screen.Mainframe.revalidate();
    }

    /**
     * Wenn Button geklickt wurde, sollen 20$ ausgezahlt werden
     */
    public class withdraw1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            transaction(20);
        }
    }

    /**
     * Wenn Button geklickt wurde, sollen 40$ ausgezahlt werden
     */
    public class withdraw2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            transaction(40);
        }
    }

    /**
     * Wenn Button geklickt wurde, sollen 60$ ausgezahlt werden
     */
    public class withdraw3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            transaction(60);
        }
    }

    /**
     * Wenn Button geklickt wurde, sollen 100$ ausgezahlt werden
     */
    public class withdraw4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            transaction(100);
        }
    }

    /**
     * Wenn Button geklickt wurde, sollen 200$ ausgezahlt werden
     */
    public class withdraw5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            transaction(200);
        }
    }
}


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/