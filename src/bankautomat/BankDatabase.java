package bankautomat;

import java.util.ArrayList;
/**
 * Datenbestand des Bankautomaten
 */
public class BankDatabase {
    static ArrayList<Account> accounts = new ArrayList<Account>(); // Array von Konten

    /**
     * Argumentloser Konstruktor, welcher die vorhandenen Accounts initialisiert
     */
    public BankDatabase() {
        // Das ursprüngliche Array wurde in eine Arrayliste umgewandelt, was das
        // Hinzufügen/Löschen aus dem Datenbestand erleichtert.
        Account accounts1 = new Account("Customer1", 12345, 11111, 1000.0, 1200.0, false);
        Account accounts2 = new Account("Customer2", 98765, 22222, 200.0, 200.0, false);
        Account accounts3 = new Account("Customer3", 19234, 33333, 200.0, 200.0, false);
        Account accounts4 = new Account("Manager1", 99999, 00000, 0, 0, true);
        accounts.add(accounts1);
        accounts.add(accounts2);
        accounts.add(accounts3);
        accounts.add(accounts4);
    } // Ende des argumentlosen "BankDatabase" Konstruktors

    public static Iterator createIterator() {
        return new AccountIterator(accounts);
    }

    /**
     * Methode um neues Konto hinzuzufügen, wird nur für die aktuelle Sitzung
     * gespeichert
     */
    public static void Adduser() {
        boolean check = true;
        String name = Screen.Inputfield1.getText();
        int accountnumber = Integer.parseInt(Screen.Inputfield2.getText());
        int pin = Integer.parseInt(Screen.Inputfield4.getText());
        int balance = Integer.parseInt(Screen.Inputfield3.getText());
        // Überprüfen ob Kontonummer oder Pin schon vergeben sind
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountnumber) {
                Screen.Inputfield2.setText("Accountnumber already taken");
                check = false;
            } else {
                if (accounts.get(i).getPin() == pin) {
                    Screen.Inputfield4.setText("Pin already taken");
                    check = false;
                }

            }

        }
        // Weder Kontonummer noch Pin bereits vergeben, Konto wird für aktuelle Sitzung
        // hinzugefügt
        if (check == true) {
            Account newaccount = new Account(name, accountnumber, pin, balance, balance, false);
            accounts.add(newaccount);

            Screen.Inputfield1.setText("");
            Screen.Inputfield2.setText("");
            Screen.Inputfield3.setText("");
            Screen.Inputfield4.setText("");
        }
    }

    /**
     * Methode um bestimmtes Konto zu löschen, wird nur für die aktuelle Sitzung
     * gelöscht
     *
     * @param position Position des zu löschenden Kontos
     */
    public static void Deleteuser(int position) {
        accounts.remove(position);

    }

    /**
     * Erhalten des Kontoobjekts mit einer spezifischen Kontonummer
     *
     * @param accountnumber Konto, dessen Objekt herausgefunden werden soll
     * @return Kontoobjekt
     */
    public Account getAccount(int accountnumber) {
        // Durchlaufen der Konten auf der Suche nach der passenden Kontonummer
        for (Account currentAccount : accounts) {
            // gibt das aktuelle Konto zurück, wenn eine Übereinstimmung gefunden wurde
            if (currentAccount.getAccountNumber() == accountnumber)
                return currentAccount;
        } // Ende "for"

        return null; // wenn kein passendes Konto gefunden wurde, wird null zurückgegeben
    } // Ende der Methode "getAccount"

    /**
     * Überprüft, ob übergebene Pin zu einem Konto gehört
     *
     * @param PIN übergebene Pin
     * @return wenn ein passendes Konto gefunden wurde, wird das Objekt dessen
     * zurückgegeben
     */
    private Account getAccountpin(int PIN) {
        // Durchlaufen der Konten auf der Suche nach der passenden Kontonummer
        for (Account currentAccount : accounts) {
            // gibt das aktuelle Konto zurück, wenn eine Übereinstimmung gefunden wurde
            if (currentAccount.GetPin() == PIN)
                return currentAccount;
        } // Ende "for"

        return null; // wenn kein passendes Konto gefunden wurde, wird null zurückgegeben
    }

    /**
     * Überprüft, ob die angegebene Kontonummer und Pin zu einem Konto im
     * Datenbestand passen
     *
     * @param userPIN eingegebene Pin
     * @return Weiterleitung an die Methode validatePin mit der übergebenen Pin
     */
    public boolean authenticateUser(int userPIN) {
        // Versuch, das Konto mit der Kontonummer abzurufen
        Account userAccount = getAccountpin(userPIN);

        // wenn Konto vorhanden, Rückgabe des Ergebnisses der Konto-Methode
        // "validatePIN"
        if (userAccount != null)
            return userAccount.validatePIN(userPIN);
        else
            return false; // Kontonummer nicht gefunden, also Rückgabe von false
    } // Ende der Methode "authenticateUser"

    // gibt den verfügbaren Geldbetrag des Kontos mit der spezifischen Kontonummer
    // zurück
    public double getAvailableBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getAvailableBalance();
    } // Ende der Methode "getAvailableBalance"

    // gibt die gesamte Geldsumme des Kontos mit der spezifischen Kontonummer zurück
    public double getTotalBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getTotalBalance();
    } // Ende der Methode "getTotalBalance"

    /**
     * Methode, um eingegebenen Betrag auf das Konto mit der angegebenen Kontonummer
     * gutzuschreiben
     *
     * @param userAccountNumber Kontonummer des Kontos
     * @param amount            Summe des eingezahlten Betrags
     */
    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount);
    } // Ende der Methode "credit"

    /**
     * Methode, um eingegebenen Betrag vom Konto mit der spezifischen Kontonummer
     * abzubuchen
     *
     * @param userAccountNumber Kontonummer des Kontos
     * @param amount            Summe des auszuzahlenden Betrags
     */
    public void debit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).debit(amount);
    } // Ende der Methode "debit"

    public boolean getadmin(int userAccountNumber) {
        return getAccountpin(userAccountNumber).getISadmin();
    }

    /**
     * Überprüft, ob übergebene Pin im Datenbestand vorhanden ist
     *
     * @param PIN übergebene Pin
     * @return wenn Pin gefunden wurde, wird die Kontonummer zurückgegeben,
     * ansonsten 1, sowie die übergebene Pin
     */
    public int getaccpin(int PIN) {
        for (Account currentAccount : accounts) {
            // gibt das aktuelle Konto zurück, wenn eine Übereinstimmung gefunden wurde
            if (currentAccount.GetPin() == PIN)
                return currentAccount.getAccountNumber();
            else
                return 1;
        } // Ende "for"
        return PIN;
    }

} // Ende der Klasse "BankDatabase"

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