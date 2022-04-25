import java.util.ArrayList;

public class Reserva {
    
    Cliente cliente;
    boolean pagamentoAVista;

    public Cliente getCliente() {
        return cliente;
    }

    

    @Override
    public String toString() {
    
        return "{Nome: " +cliente.getNome() + ", Cliente " + ", pagamento " ;
    }

}
