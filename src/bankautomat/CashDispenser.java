package bankautomat;

/**
 * Klasse um die Geldauszahlung durchzuführen
 */
public class CashDispenser {
    // die default ursprüngliche Anzahl der Scheine im Geldausgabeautomaten
    private final static int INITIAL_COUNT = 500;
    private int count; // Anzahl der verbleibenden 20-Dollar-Scheine


    /**
     * Argumentloser Konstruktor initialisiert die Zählung auf den Default-Wert
     */
    public CashDispenser() {
        count = INITIAL_COUNT; // Attribut "Zählung" auf Default setzen
    } // Ende des "CashDispenser" Konstruktors


    /**
     * Simuliert das Abheben des übergebenen Geldbetrags
     *
     * @param amount gewünschter auszuzahlender Geldbetrag
     */
    public void dispenseCash(int amount) {
        int billsRequired = amount / 20; // Anzahl der benötigten 20-Dollar-Scheine
        count -= billsRequired; // die Anzahl der Scheine aktualisieren
    } // Ende der Methode "dispenseCash"


    /**
     * Überprüft, ob gewünschter Betrag abgehoben werden kann
     *
     * @param amount gewünschter Betrag
     * @return true: Betrag kann abgehoben werden, false: Betrag kann nicht abgehoben werden
     */
    public boolean isSufficientCashAvailable(int amount) {
        int billsRequired = amount / 20; // Anzahl der benötigten 20-Dollar-Scheine

        if (count >= billsRequired)
            return true; // genügend Scheine vorhanden
        else
            return false; // nicht genügend Scheine vorhanden
    } // Ende der Methode "isSufficientCashAvailable"
} // Ende der Klasse "CashDispenser"


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