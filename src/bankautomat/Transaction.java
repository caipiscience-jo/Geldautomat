package bankautomat;

/**
 * Vorlage für eine Transaktion
 */
public abstract class Transaction {
    protected Screen screen; // Bildschirm des Bankautomaten
    private int accountNumber; // gibt das involvierte Konto an
    private BankDatabase bankDatabase; // Kontoinformation-Datenbestand


    /**
     * Transaktions-Konstruktor der von Unterklassen mit super() aufgerufen wird
     *
     * @param userAccountNumber Kontonummer des Kontos
     * @param atmScreen         aktuelles Menü
     * @param atmBankDatabase   aktueller Datenbestand
     */
    public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        accountNumber = userAccountNumber;
        screen = atmScreen;
        bankDatabase = atmBankDatabase;
    } // Ende des Transaktions-Konstruktors

    // gibt Kontonummer zurück
    public int getAccountNumber() {
        return accountNumber;
    } // Ende der Methode "getAccountNumber"

    // gibt Referenz zum Bildschirm zurück
    public Screen getScreen() {
        return screen;
    } // Ende der Methode "getScreen"

    // gibt Referenz zum Datenbestand zurück
    public BankDatabase getBankDatabase() {
        return bankDatabase;
    } // Ende der Methode "getBankDatabase"


    /**
     * Vorlage zum Ausführen einer Transaktion (wird von jeder Unterklasse überschrieben)
     */
    abstract public void execute();
} // Ende der Klasse "Transaction"


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