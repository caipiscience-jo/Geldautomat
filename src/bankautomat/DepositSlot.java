package bankautomat;

/**
 * Simuliert das Fach, in welchen das einzuzahlende Geld gelegt wird
 */
public class DepositSlot {
    /**
     * Überprüft, ob Geld eingelegt wurde
     *
     * @return Einzahlungsslot immer true, weil es sich nur um eine Simulation handelt
     */
    public boolean isEnvelopeReceived() {
        return true;
    }
}