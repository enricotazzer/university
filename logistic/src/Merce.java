public class Merce {
    private int quantita;
    private String tipologia;

    public boolean compareMerce(Merce merceRichiesta) {
        return tipologia.equals(merceRichiesta.tipologia);
    }

    public boolean equal(Merce merce) {
        return this.tipologia.equals(merce.tipologia) && this.quantita == merce.quantita;
    }
}
