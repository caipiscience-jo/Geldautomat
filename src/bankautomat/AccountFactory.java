package bankautomat;

/**
 * Hiermit werden neue Konten zum Datenbestand hinzugefügt
 */
public class AccountFactory extends Account {

    /**
     * Konstruktor um ein Konto erstellen und zum Datenbestand hinzuzufügen
     *
     * @param Username            Nutzername der Person
     * @param theAccountNumber    Kontonummer des Accounts
     * @param thePIN              Pin zur Authentifizierung des Accounts
     * @param theAvailableBalance frei zur Verfügung stehender Geldbetrag
     * @param theTotalBalance     gesamter Geldbetrag
     * @param isadmin             ist das Konto ein Administratorzugang
     */
    public AccountFactory(String Username, int theAccountNumber, int thePIN, double theAvailableBalance,
                          double theTotalBalance, boolean isadmin) {
        super(Username, theAccountNumber, thePIN, theAvailableBalance, theTotalBalance, isadmin);
        setUsername(Username);
        setAccountNumber(theAccountNumber);
        setPin(thePIN);
        setAvailableBalance(theAvailableBalance);
        setTotalBalance(theTotalBalance);
        setAdmin(isadmin);
    }
}
