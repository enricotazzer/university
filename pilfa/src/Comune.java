public class Comune {
    private double x,y ; // coordinate geografiche del comune
    private String nome;


    public double calcolaDistanza(Cliente cliente) {
        Comune sedeCliente = cliente.getLocazione();
        double distanza = Math.sqrt(Math.pow(Math.abs(sedeCliente.x - this.x), 2) + Math.pow(Math.abs(sedeCliente.y - this.y), 2));
        return distanza;
    }
}
