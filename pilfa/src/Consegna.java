import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Consegna {
    private List<Ordine> ordiniDaEffettuare;
    private Date dataConsegna;
    private int numeroConsegna;

    public Consegna(List<Ordine> ordini, Date dataConsegna){
        this.ordiniDaEffettuare = new ArrayList<>(ordini);
        this.dataConsegna = dataConsegna;
    }

    public Consegna verificaCliente(Cliente cliente) {
        assert (cliente != null): String.format("Cliente deve essere non null");
        Date now = Calendar.getInstance().getTime();
        if(dataConsegna.compareTo(now) >= 0){
            Consegna consegnaCliente = new Consegna(new ArrayList<>(), this.dataConsegna);
            for(Ordine ordine : ordiniDaEffettuare){
                if(ordine.function(cliente)) {
                    consegnaCliente.ordiniDaEffettuare.add(ordine);
                }
            }
        }
        return null;
    }

    public Cliente getClienteOrdine(int id){
        for(Ordine ordine : ordiniDaEffettuare){
            Cliente cliente = ordine.getCliente(id);
            if(cliente != null){
                return cliente;
            }
        }
        return null;
    }

    public int getPrezzoOrdine(int id){
        for(Ordine ordine : ordiniDaEffettuare){
            int prezzo = ordine.getPrezzo(id);
            if(prezzo > 0){
                return prezzo;
            }
        }
        return 0;
    }
}
