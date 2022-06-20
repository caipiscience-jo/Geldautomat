package bankautomat;

import java.util.ArrayList;

/**
 * Klasse für die Auflistung der erstellten Konten (Iterator-Entwurfsmuster)
 */
public class AccountIterator implements Iterator {
    ArrayList<Account> accounts;

    /**
     * Konstruktor um die Liste der Konten zu initialisieren, um eine bereits
     * vorhandene ArrayList zur Verwendung in dieser Klasse abzurufen
     *
     * @param accounts2 Liste der Konten
     */
    public AccountIterator(ArrayList<Account> accounts2) {
        this.accounts = accounts2;
    }

    /**
     * Prüft, ob es in der Liste ein nächstes Konto gibt
     *
     * @param position Position des Kontos in der Liste
     * @return true: es gibt ein nächstes Konto false: Konto ist an letzter Stelle
     * in der Liste
     */
    public boolean hasNext(int position) {
        if (position >= accounts.size() - 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Iteriert zur nächsten Position in der Liste
     *
     * @param position Position des nächsten Kontos
     * @return nächstes Konto in der Liste
     */
    @Override
    public Object next(int position) {
        Account AccountItem = accounts.get(position);
        return AccountItem;
    }

    /**
     * Prüft, ob es in der Liste ein vorheriges Konto gibt, sodass Nutzer*in nicht
     * weiter zurück gehen kann
     *
     * @param position Position des Kontos in der Liste
     * @return true: es gibt ein vorheriges Konto false: Konto ist an erster Stelle
     * in der Liste
     */
    @Override
    public boolean hasPrev(int position) {
        if (position == 0)
            return false;
        else
            return true;
    }

}
