import java.util.Date;

public class Spedizione { //oggetto immutabile
    private Percorso tragitto;
    private Autocarro autocarro;
    private Date partenza;

    public Spedizione(Autocarro autocarro, Percorso tragitto, Date partenza) {
        this.autocarro = autocarro;
        this.tragitto = tragitto;
        this.partenza = partenza;
    }

    public Spedizione(Percorso nuovoPercorso) {

    }

    public boolean checkDate(Date partenza){
        return this.partenza.compareTo(partenza) == 0 ? true : false;
    }

    public Spedizione modificaPercorso(Percorso nuovoPercoso){
        return new Spedizione(this.autocarro, nuovoPercoso, this.partenza);
    }

    public boolean equal(Spedizione spedizione) {
        return (this.autocarro.equal(spedizione.autocarro) && this.tragitto.equal(spedizione.tragitto) && checkDate(spedizione.partenza));
    }
}
