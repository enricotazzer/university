import java.util.Date;
import java.util.List;

public class Viaggio {
    private Spedizione spedizione;
    //enumerazione sullo stato del viaggio
    List<Cliente> clienti; // 1 o piu

    public Viaggio(Spedizione spedizione){
        this.spedizione = spedizione;
    }


    public boolean controllaDataPartenza(Date partenza){
        return this.spedizione.checkDate(partenza);
    }

    public void reinstrda(Spedizione nuovaspedizione) {
        this.spedizione = nuovaspedizione;
    }

    public boolean controllaSpedizione(Spedizione spedizione){
        return this.spedizione.equal(spedizione);
    }
}
