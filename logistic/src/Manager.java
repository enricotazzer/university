import java.util.*;

public class Manager extends Exception{
    Flotta flotta;
    List<Viaggio> viaggiPrenotati;
    /*public enum Data{
        PARTENZA, ARRIVO
    }*/
    public Viaggio prenotaViaggio(Citta origine, Citta destinazione, Merce merceRiciesta, int quantitaMerce, Date partenza){
        Autocarro autocarro = flotta.cercaAutocarroAdeguato(merceRiciesta, quantitaMerce);
        assert (autocarro != null): String.format("Nessun autocarro compatibile o disponibile trovato");

        Percorso tragitto = new Percorso(origine, destinazione);
        Spedizione spedizione = new Spedizione(autocarro, tragitto, partenza);
        Viaggio nuovoViaggo = new Viaggio(spedizione);
        viaggiPrenotati.add(nuovoViaggo);
        return nuovoViaggo;
    }
    /*public Viaggio prenotaViaggio(Citta origine, Citta destinazione, Merce merceRiciesta, int qunantitaMerce, Date arrivo){
        return null;
    }*/
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

    public void reinstradaViaggio(Spedizione spedizione, Percorso nuovoPercorso){
        Viaggio viaggioDaReinstradare = cercaViaggio(spedizione);
        assert(viaggioDaReinstradare != null): String.format("Nessun viaggio prenotato risulta avere il percoros inserito");

        Spedizione nuovaSpedizione = spedizione.modificaPercorso(nuovoPercorso);
        viaggioDaReinstradare.reinstrda(nuovaSpedizione);
    }

    private Viaggio cercaViaggio(Spedizione spedizione) {
        for(Viaggio viaggio : viaggiPrenotati){
            if(viaggio.controllaSpedizione(spedizione)){
                return viaggio;
            }
        }
        return null;
    }
}
