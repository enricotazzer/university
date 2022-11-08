public class Autocarro {
    private Merce merce; // tipologia di merce compatibile con l'autocarro
    private int caricoMassimo;
    private boolean disponibile = true;

    public boolean compatibile(Merce merceRichiesta, int quantita){ // lanciare eccezione se quantita > carico massimo
         if(merce.compareMerce(merceRichiesta) && quantita <= caricoMassimo && disponibile)
            return true;
        return false;
    }


    public boolean equal(Autocarro autocarro) {
        return this.merce.equal(autocarro.merce);
    }
}
