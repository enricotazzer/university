import java.util.List;

public class Flotta { //autocarri a disposizione dell'azienda
    List<Autocarro> flotta;

    public Autocarro cercaAutocarroAdeguato(Merce merce, int quantita){
        for(Autocarro autocarro : flotta){
            if(autocarro.compatibile(merce, quantita))
                return autocarro;
        }
        return null;
    }
}
