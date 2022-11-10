import java.util.*;

public class RegistroOrdini {
    List<Consegna> consegne;

    public RegistroOrdini(){
        this.consegne = new ArrayList<>();
    }

    //MISSION cerco nell'elenco di ordini quelli corrispondenti al cliente che non sono ancora stati effetutati
    //@param  cliente not null
    //@return restituisce un nuovo registro di ordini contenente solo gli ordini del cliente specificato
    public RegistroOrdini search(Cliente cliente){
        assert (cliente != null): String.format("Parametro cliente non valido \n Deve essere non null");

        RegistroOrdini ordiniDelCliente = new RegistroOrdini();
        for(Consegna consegna : consegne){
            Consegna consegnaCliente = consegna.verificaCliente(cliente);
            if(consegnaCliente != null){
                ordiniDelCliente.consegne.add(consegnaCliente);
            }
        }
        return ordiniDelCliente;
    }

    public Cliente estraiCliente(int identificativoOrdine) {
        assert (identificativoOrdine > 0): String.format("Identificativo non valido");
        for(Consegna consegna : consegne){
            Cliente cliente = consegna.getClienteOrdine(identificativoOrdine);
            return cliente;
        }
        return null;
    }

    public int estraiPrezzoArticoli(int identificativoOrdine) {
        assert (identificativoOrdine > 0): String.format("Identificativo non valido");
        for(Consegna consegna : consegne){
            int prezzoArticoli = consegna.getPrezzoOrdine(identificativoOrdine);
            return prezzoArticoli;
        }
        return 0;
    }
}
