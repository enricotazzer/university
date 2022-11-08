import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Percorso {
    List<Citta> tappe; // prima occorrenza orgine, ultima destinazione


    public Percorso(Citta origine, Citta destinazione) {
        tappe = new ArrayList<>();
        tappe.add(origine);
        //aggiunta tappe intermedie
        //...
        tappe.add(destinazione);


    }

    public boolean equal(Percorso tragitto) {
        if(this.tappe.size() != tragitto.tappe.size()){
            return false;
        }else{
            for(int i = 0; i < this.tappe.size(); i++) {
                if (!this.tappe.get(i).equals(tragitto.tappe.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
