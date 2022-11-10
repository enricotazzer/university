public class Autocarro {
    private Merce merce; // tipologia di merce compatibile con l'autocarro
    private int caricoMassimo;
    private boolean disponibile = true;
    private int id;

    public boolean compatibile(Merce merceRichiesta, int quantita) { // lanciare eccezione se quantita > carico massimo
        assert (quantita > 0): String.format("Quantita:%d non valida", quantita);
        if(merce.compareMerce(merceRichiesta) && quantita <= caricoMassimo && disponibile)
            return true;
        return false;
    }


    public boolean equal(Autocarro autocarro) {
        return this.merce.equal(autocarro.merce);
    }
}
