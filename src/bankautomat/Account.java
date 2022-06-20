package bankautomat;

/**
 * Mit der Klasse kann ein Account instanziiert werden
 */
public class Account {
    private int accountNumber; // Kontonummer
    private int pin; // PIN zur Authentifizierung
    private double availableBalance; // verfügbarer Geldbetrag zum Abheben
    private double totalBalance; // verfügbare Geldsumme + ausstehende Anzahlungen
    private boolean admin;
    private String username;

    /**
     * Account Konstruktor initialisiert die Attribute
     *
     * @param Username            Nutzername der kontoinhabenden Person
     * @param theAccountNumber    Kontonummer des Bankaccounts
     * @param thePIN              Pin zur Authentifizierung
     * @param theAvailableBalance verfügbarer Geldbetrag zum Abheben
     * @param theTotalBalance     der gesamte Betrag
     * @param isadmin             ist das Konto ein Administratorzugang
     */
    public Account(String Username, int theAccountNumber, int thePIN, double theAvailableBalance,
                   double theTotalBalance, boolean isadmin) {
        setUsername(Username);
        setAccountNumber(theAccountNumber);
        setPin(thePIN);
        setAvailableBalance(theAvailableBalance);
        setTotalBalance(theTotalBalance);
        setAdmin(isadmin);
    } // Ende des Account Konstruktors

    /**
     * Methode um beim Login angegebene PIN mit der PIN im Konto übereinstimmt
     *
     * @param userPIN von nutzender Person eingegebene Pin
     * @return true: eingegebene Pin ist richtig, false: eingegebene Pin ist falsch
     */
    public boolean validatePIN(int userPIN) {
        if (userPIN == getPin())
            return true;
        else
            return false;
    } // Ende der Methode "validatePIN"

    /**
     * Gibt den verfügbaren Geldbetrag zurück
     *
     * @return frei verfügbare Geldsumme
     */
    public double getAvailableBalance() {
        return availableBalance;
    } // Ende von "getAvailableBalance"

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * Gibt die gesamte Geldsumme zurück
     *
     * @return gesamte Geldsumme
     */
    public double getTotalBalance() {
        return totalBalance;
    } // Ende der Methode "getTotalBalance"

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    /**
     * Methode um einen Betrag auf dem Konto gutzuschreiben
     *
     * @param amount von nutzender Person angegebene Summe
     */
    public void credit(double amount) {
        setTotalBalance(getTotalBalance() + amount); // zur gesamten Geldsumme hinzufügen
    } // Ende der Methode "credit"

    /**
     * Methode um einen Betrag vom Konto abzubuchen
     *
     * @param amount zu überweisender Betrag
     */
    public void debit(double amount) {
        setAvailableBalance(getAvailableBalance() - amount); // vom verfügbaren Geldbetrag abziehen
        setTotalBalance(getTotalBalance() - amount); // von gesamter Geldsumme abziehen
    } // Ende der Methode "debit"

    /**
     * Getter und Setter der Attribute
     */
    public int getAccountNumber() {
        return accountNumber;
    } // Ende der Methode "getAccountNumber"

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean getISadmin() {
        return getAdmin();
    }

    public int GetPin() {
        return getPin();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

} // Ende der Klasse "Account"

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
