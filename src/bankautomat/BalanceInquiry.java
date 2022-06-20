package bankautomat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Klasse für das Menü der Kontoübersicht
 */
public class BalanceInquiry extends Transaction {
    /**
     * Konstruktor für das Menü der Kontoübersicht
     *
     * @param userAccountNumber Kontonummer der eingeloggten Person
     * @param atmScreen         derzeitiges Fenster
     * @param atmBankDatabase   derzeitiger Datenbestand
     */
    public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    } // Ende des "BalanceInquiry" Konstruktors


    /**
     * zeigt die Informationen im Menü der Kontoübersicht an/ führt die Transaktion durch
     */
    @Override
    public void execute() {
        // Abruf der Referenzen zum Bank-Datenbestand und zum Bildschirm
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        // Abruf des verfügbaren Geldbetrags für das betreffende Konto
        double availableBalance =
                bankDatabase.getAvailableBalance(getAccountNumber());

        // Abruf der gesamten Geldsumme für das betreffende Konto
        double totalBalance =
                bankDatabase.getTotalBalance(getAccountNumber());

        // Anzeige des Geldbetrags auf dem Bildschirm
        screen.creatBalanceGUI();
        screen.messageJLabel2.setText("Avaliable Balance: " + availableBalance);
        screen.messageJLabel3.setText("Total Balance: " + totalBalance);
        screen.Mainframe.revalidate();

    } // Ende der Methode "execute"


} // Ende der Klasse "BalanceInquiry"


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