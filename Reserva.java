import java.util.ArrayList;

public class Reserva implements Pagamento {
    
    Cliente cliente;
    boolean pagamentoAVista;
   
    public Reserva(Cliente cliente, boolean pagamentoAVista) {
        this.cliente = cliente;
        this.pagamentoAVista = pagamentoAVista;
    }

    public Cliente getCliente() {
        return cliente;
    }
 
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
    String TPpagamento;    
    String tppessoa;
    
        if (pagamentoAVista == true){
            TPpagamento = "Pagamento a Vista";
        }else{
            TPpagamento = "Pagamento a Prazo";
        }

        if(cliente instanceof PessoaFisica){
            tppessoa = "Pessoa Física";
        } else{
            tppessoa = "Pessoa Jurídica"; 
        }

        return "Cliente: " +cliente.getNome() + "\n" +tppessoa  +"\n" +TPpagamento;
    }

    @Override
    public double calcularPagamento() {
        if (pagamentoAVista == true){
            return 3200 * 0.9;
        }
        return 3200 ;
    }

}
