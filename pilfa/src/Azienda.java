import java.security.InvalidParameterException;
import java.util.*;

public class Azienda {
    private RegistroOrdini registroOrdini;
    private Flotta veicoli;
    private CruscottoInformativo cruscottoInformativo;
    private Comune sede;

    //MISSION: cercare le consegne prenotate da un determinato cliente
    //@param: Cliente not null
    //@return restituisce un elenco di consegne, ancora non portate a termine del cliente inserito in input
    public RegistroOrdini estraiConsegneCliente(Cliente cliente) throws InvalidParameterException {
        if(cliente == null){
            throw new InvalidParameterException();
        }
        RegistroOrdini ordiniDelCliente = registroOrdini.search(cliente);
        return ordiniDelCliente;
    }

    //MISSION: determinare il costo di un'ordine (dato il numero identificativo dell'ordine) per un cliente
    //@param   ordine/consegna non null -> ordine/consegna di cui vogliamo sapere il costo
    //@return restituisce il prezzo (float) in base al costo degli articoli, la distanza da percorrere per la consegna
    //        e dagli sconti (se validi)
    public double determinaCostoConsegna(int identificativoOrdine) throws InvalidParameterException {
        if(identificativoOrdine <= 0){
            throw new InvalidParameterException();
        }
        double costoConsegna = 0;
        Cliente cliente = registroOrdini.estraiCliente(identificativoOrdine);
        assert (cliente != null): String.format("Cliente non trovato, identificativo ordine non valido");
        double distanzaDalCliente = sede.calcolaDistanza(cliente);
        int costoOrdine = registroOrdini.estraiPrezzoArticoli(identificativoOrdine);
        assert (costoOrdine > 0):String.format("Costo ordine ambiguo");
        float sconto = controllaSconti();
        costoConsegna = Math.floor(distanzaDalCliente)/2 + costoOrdine - sconto;
        return costoConsegna;
    }

    public float controllaSconti() {
    //ricerca nella base dati se ci sono presenti degli sconti validi nella data in cui è stato eseguito l'ordine
        return 0;
    }

    public CruscottoInformativo aggiornaCruscotto(){

        return null;
    }

}
