package bankautomat;

/**
 * Schnittstelle für das Iterator-Muster
 */
public interface Iterator {

    /**
     * Vorlage zur Überprüfung, ob es ein nächstes Konto gibt
     *
     * @param position Position des aktuellen Kontos im Datenbestand
     * @return
     */
    boolean hasNext(int position);

    /**
     * Vorlage um zum nächsten Konto zu springen
     *
     * @param position Position des aktuellen Kontos im Datenbestand
     * @return
     */
    Object next(int position);

    /**
     * Vorlage zur Überprüfung, ob es ein vorheriges Konto gibt
     *
     * @param position
     * @return Position des aktuellen Kontos im Datenbestand
     */
    boolean hasPrev(int position);

}
