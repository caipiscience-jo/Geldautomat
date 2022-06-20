package bankautomat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Klasse für das Menü zum Einzahlen
 */
public class Deposit extends Transaction {
    private final static int CANCELED = 0; // Konstante für Abbruchoption
    private double amount; // zu hinterlegende Summe
    private Keypad keypad; // Verweis auf die Eingabetastatur
    private DepositSlot depositSlot; // Verweis auf den Einzahlungsslot

    /**
     * Konstruktor, welcher ein Auszahlungsmenü initialisiert
     *
     * @param userAccountNumber Kontonummer des Kontos
     * @param atmScreen         aktuelles Menü
     * @param atmBankDatabase   aktueller Datenbestand
     * @param atmKeypad         aktuelles Tastenfeld
     * @param atmDepositSlot    aktueller
     */
    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
        // initialisiert "superclass Variablen"
        super(userAccountNumber, atmScreen, atmBankDatabase);

        // Initialisierung der Verweise auf die Eingabetastatur und den Einzahlungsslot
        keypad = atmKeypad;
        depositSlot = atmDepositSlot;
    } // Ende des "Deposit" Konstruktors


    /**
     * Führt Transaktion aus
     */
    @Override
    public void execute() {
        promptForDepositAmount();
    }

    /**
     * Leitet zur Einzahlungsmethode weiter, falls Person etwas einzahlen möchte. Setzt entsprechende Texte in die Textfelder
     *
     * @param amount gewünschter einzuzahlender Betrag
     */
    public void makedeposit(double amount) {
        BankDatabase bankDatabase = getBankDatabase(); // Referenz abrufen
        Screen screen = getScreen(); // Referenz abrufen
        // Einzahlungsbetrag vom Benutzer erhalten

        // prüfen, ob der Benutzer einen Einzahlungsbetrag eingegeben oder storniert hat
        if (amount != CANCELED) {
            // Anforderung einer Einzahlung mit einem bestimmten Betrag
            screen.messageJLabel2.setText("\nPlease insert a deposit envelope containing " + amount);

            // Einzahlung erhalten
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();

            // prüfen, ob der Einzahlung eingegangen ist
            if (envelopeReceived) {
                screen.messageJLabel2.setText("\nYour envelope has been " + "received.\nNOTE: The money just deposited will not ");
                screen.messageJLabel3.setText("be available until we verify the amount of any " + "enclosed cash and your checks clear.");

                // Guthabenkonto, um die Einzahlung wiederzugeben
                bankDatabase.credit(getAccountNumber(), amount);
            } // Ende "if"
            else // Einzahlungnicht erhalten
            {
                screen.messageJLabel2.setText("\nYou did not insert an " + "envelope, so the ATM has canceled your transaction.");
            } // Ende "else"
        } // Ende "if"
        else // Benutzer hat abgebrochen, anstatt den Betrag einzugeben
        {
            screen.messageJLabel2.setText("\nCanceling transaction...");
        } // Ende "else"
    } // Ende der Methode "execute"


    /**
     * Methode, um den*die Benutzer*in aufzufordern, einen Einzahlungsbetrag in Cent einzugeben
     */
    private void promptForDepositAmount() {
        Screen screen = getScreen(); // Bezug zum Bildschirm herstellen

        // die Eingabeaufforderung anzeigen
        screen.CreateDepositGUI(); // Eingabe des Einzahlungsbetrags erhalten        
        screen.Mainframe.add(keypad.addkeypad(), BorderLayout.CENTER);
        Depositcheck check1 = new Depositcheck();
        keypad.BEnter.addActionListener(check1);
        screen.Mainframe.revalidate();
        // prüfen, ob der Benutzer abgebrochen oder einen gültigen Betrag eingegeben hat

        // Dollarbetrag zurückgeben
    } // Ende "else"
    // Ende der Methode "promptForDepositAmount"

    /**
     * Holt den eingegebenen Betrag aus dem Eingabefeld und gibt diesen an die Methode makedeposit() weiter
     */
    private class Depositcheck implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            double input = Integer.parseInt(screen.Inputfield2.getText());
            double amount = input / 100;

            makedeposit(amount);

        }
    }
}
// Ende der Klasse "Deposit"


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