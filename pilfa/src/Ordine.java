import java.util.*;
//enumerazione sulla tipologia di ordine stand adhoc o periodica
public class Ordine {
    private List<Articolo> ordine;
    private Cliente cliente;
    private int prezzo;
    private int numeroOrdine;

    public boolean function(Cliente cliente){
        return this.cliente.equals(cliente)? true : false;
    }

    public Cliente getCliente(int id){
        if(this.numeroOrdine == id){
            return this.cliente;
        }
        else return null;
    }


    public int getPrezzo(int id) {
        if(this.numeroOrdine == id){
            return this.prezzo;
        }
        return 0;
    }
}
