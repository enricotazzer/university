import java.util.List;

public class Flotta { //autocarri a disposizione dell'azienda
    List<Autocarro> flotta;

    //MISSION ricerca di almeno un autocarro compatibile al tipo di merce e quantita richiesta
    //@param merce, quantita
    //@return restituisce un autocarro, se esiste, che risulta conforme alle specifiche richieste e disponibile all'uso
    public Autocarro cercaAutocarroAdeguato(Merce merce, int quantita){
        for(Autocarro autocarro : flotta){
            if(autocarro.compatibile(merce, quantita))
                return autocarro;
        }
        return null;
    }
}
