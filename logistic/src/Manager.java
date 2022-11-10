import java.util.*;

public class Manager{
    //
    //
    //
    Flotta flotta;
    List<Viaggio> viaggiPrenotati;
    /*public enum Data{
        PARTENZA, ARRIVO
    }*/
    //MISSION: crea un viaggio con i parametri inseriti
    //@param origine, destinazione sono i punti rispettivamente di inizio e fine del tragitto, non devono essere null
    //       merceRichiesta e quantita merce, criteri di ricerca di almeno un autocarro compatibile al viaggio da eseguire, quantita merce >0, merce non null
    //       data di partenza del viaggio non null
    //@return restituisce un viaggio con i parametri inseriti in input e viene aggiunto alla lista di viaggi prenotati
    //        eccezione se quantitaMerce <= 0, assert ogni parametro valido, cioe non null
    public Viaggio prenotaViaggio(Citta origine, Citta destinazione, Merce merceRiciesta, int quantitaMerce, Date partenza)throws QuantityRequiredToBePositiveException{
        if(quantitaMerce <= 0){
            throw new QuantityRequiredToBePositiveException("Quantita inserita non valida");
        } else {
            Autocarro autocarro = flotta.cercaAutocarroAdeguato(merceRiciesta, quantitaMerce);
            assert (autocarro != null) : String.format("Nessun autocarro compatibile o disponibile trovato");

            Percorso tragitto = new Percorso(origine, destinazione);
            Spedizione spedizione = new Spedizione(autocarro, tragitto, partenza);
            Viaggio nuovoViaggo = new Viaggio(spedizione);
            viaggiPrenotati.add(nuovoViaggo);
            return nuovoViaggo;
        }
    }
    /*public Viaggio prenotaViaggio(Citta origine, Citta destinazione, Merce merceRiciesta, int qunantitaMerce, Date arrivo){
        return null;
    }*/
    //MISSION: restituisce i viaggi prenotati con una certa data di partenza
    //@param  dataPartenza nel formato gg/mm/yyyy non null
    //@return restituisce i viaggi prenotati che hanno come data di partenza la data inserita, se non esistono resituisco null
    public List<Viaggio> estraiViaggiPrenotati(Date dataPartenza){
        List<Viaggio> viaggiConformi = new ArrayList<>();
        for(Viaggio viaggio : viaggiPrenotati){
            if(viaggio.controllaDataPartenza(dataPartenza)) {
                viaggiConformi.add(viaggio);
            }
        }
        return viaggiConformi;
    }

    //stessa cosa con data di arrivo e altre richieste

    //MISSION: cambia il percorso di un viaggio
    //@param spedizione: cerca il viaggio specifico della spedizione (se esiste), non null
    //@return cambio del percorso del viaggio scelto, inserendo come percorso nuovoPercorso
    public void reinstradaViaggio(Spedizione spedizione, Percorso nuovoPercorso){
        Viaggio viaggioDaReinstradare = cercaViaggio(spedizione);
        assert(viaggioDaReinstradare != null): String.format("Nessun viaggio prenotato risulta avere il percorso inserito");

        Spedizione nuovaSpedizione = spedizione.modificaPercorso(nuovoPercorso);
        viaggioDaReinstradare.reinstrda(nuovaSpedizione);
    }

    //MISSION: cerca un viaggio nell'elenco data una specifica spedizione
    //@param spedizione non null
    //@return restituisce il viaggio che ha come spedizione la spedizione scelta se non esiste restituisco null
    private Viaggio cercaViaggio(Spedizione spedizione) {
        for(Viaggio viaggio : viaggiPrenotati){
            if(viaggio.controllaSpedizione(spedizione)){
                return viaggio;
            }
        }
        return null;
    }
}
