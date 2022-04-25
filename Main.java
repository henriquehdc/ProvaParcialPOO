import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int comando;

        do{
            comando = Integer.parseInt(JOptionPane.showInputDialog(opcoes()));
            if(comando < 1 || comando > 6){
                JOptionPane.showMessageDialog(null, "Por favor digite uma opção entre 1 e 6!");
            } else{
                switch(comando){
                    case 1: 
                        Processo.Reservar();
                        break;
                    case 2:
                        Processo.PesquisarReserva();
                        break;
                    case 3:
                        Processo.ImprimirReservas();
                        break;
                    case 4:
                        Processo.ImprimirListaDeEspera();
                        break;
                    case 5:
                        Processo.CancelarReserva();
                }
           }
        }while (comando != 6);    
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
