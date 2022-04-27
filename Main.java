import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        String comando;

        do{
        comando = JOptionPane.showInputDialog(opcoes());
            try{   
                if("".equals(comando)){               
                }else if ("1".equals(comando)){
                    Processo.Reservar();
                }else if ("2".equals(comando)){
                    Processo.PesquisarReserva();
                }else if ("3".equals(comando)){
                    Processo.ImprimirReservas();
                }else if ("4".equals(comando)){
                    Processo.ImprimirListaDeEspera();
                }else if ("5".equals(comando)){
                    Processo.CancelarReserva();
                }else if ("6".equals(comando)){
                    break;
                }else {
                    JOptionPane.showMessageDialog(null,"Comando inválido! \nDigite um numero entre 1 e 6");
                    throw new UnsupportedOperationException();
                }
            
                }  catch (UnsupportedOperationException e) {
                        e.printStackTrace();
                }
        }while (comando != "6");

    }
    
    public static String opcoes(){
        String aux="Restaurante SABOR SOFISTICADO";
            aux+="\n1.Reservar mesa";
            aux+="\n2.Pesquisar reserva";
            aux+="\n3.Imprimir reservas";
            aux+="\n4.Imprimir lista de espera";
            aux+="\n5.Cancelar reserva";
            aux+="\n6.Finalizar";
    return aux;    
    }

}    


