import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Processo {

    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    
    public static void Reservar(){

        int existe;
        boolean pag = true;
        Cliente c = null;

        if(reservas.size()>=6){
            JOptionPane.showMessageDialog(null, "Infelizmente nossas mesas estão todas reservadas \nmas vamos colocar sua reserva na fila de espera OK!!!"	);
        }

        String nome = JOptionPane.showInputDialog( "Nome:" );     
        
//DEFININDO MÉTODO DE PAGAMENTO E VALIDANDO ERROS        
        String pagamento = JOptionPane.showInputDialog( "Pagamento a vista? [ S / N ]:").toLowerCase();
        if ( (!pagamento.equals("s")) && (!pagamento.equals("n"))){
            pagamento = JOptionPane.showInputDialog( "Insira apenas S, se o pagamento for a vista ou, N se o pagamento for a prazo").toLowerCase();
        }      
        if (pagamento.equals("s")){
             pag = true;
        }else if (pagamento.equals("n")){
            pag = false;
        }

//DEFININDO O TIPO DO CLIENTE E VALIDANDO DUPLICIDADE
        String tipo = JOptionPane.showInputDialog( "Tipo de Cliente? [ F / J ]" ).toLowerCase();            
        if ( (!tipo.equals("f")) && (!tipo.equals("j"))){
            tipo = JOptionPane.showInputDialog( "Insira apenas F, se for cliente físico ou, J se for cliente jurídico").toLowerCase();            
        }       

        if (tipo.equals("f")){
            String cpf = JOptionPane.showInputDialog( "CPF:" );
            existe = verificando(cpf);
                if (existe == -1){
                    PessoaFisica pf = new PessoaFisica(nome,cpf);
                    c= pf;
                    JOptionPane.showMessageDialog(null,"Mesa cadastrada!" +"  😀👍  ");
                }else{
                    JOptionPane.showMessageDialog(null,"CPF já cadastrado!!");
                }
               
        }else if (tipo.equals("j")){
            String cnpj = JOptionPane.showInputDialog( "CNPJ:" );
            existe = verificando(cnpj);
                if (existe == -1){
                    PessoaJuridica pj = new PessoaJuridica(nome,cnpj);
                    c= pj;
                    JOptionPane.showMessageDialog(null,"Mesa cadastrada!" +"  😀👍 ");
                }else{
                    JOptionPane.showMessageDialog(null,"CNPJ já cadastrado!!");               
                } 
        }
        
//ADICIONANDO O CLIENTE NA LISTA         
        Reserva reserva = new Reserva(c,pag);
        reservas.add(reserva);
    }

    public static void PesquisarReserva(){
        String achar = JOptionPane.showInputDialog(null, "Insira o CPF OU CNPJ para consulta: ");
        int existe = verificando(achar);

        if(existe != -1){
            if(existe < 6){
            JOptionPane.showMessageDialog(null, "Reserva Encontrada! \n" +reservas.get(existe).getCliente().toString());
            }else{
                JOptionPane.showMessageDialog(null, "Reserva encontrada, porém na lista de espera! \nCliente: " +reservas.get(existe).getCliente().toString() + "\nPosição na fila: "+ (existe-5)); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "Reserva não encontrada!!");
        }  
    }

   public static void ImprimirReservas(){   
        if(reservas.size()>0){   
            for ( int i =0; i<reservas.size() ; i++){
                if(i<6){
                    JOptionPane.showMessageDialog(null, reservas.get(i));  
                }else{
                    return;
                }       
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma reserva feita!");
        }    
    }
    
    public static void ImprimirListaDeEspera(){
        if(reservas.size()>6){   
            for ( int i=6; i<reservas.size() ; i++){
                JOptionPane.showMessageDialog(null, reservas.get(i) + "\nPosição na fila: " +(i-5));               
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhuma reserva na lista de espera!");
        }    
   

    }
  
    public static void CancelarReserva(){

    String achar = JOptionPane.showInputDialog(null, "Insira o CPF OU CNPJ para consulta: ");

    int existe = verificando(achar);

        if(existe != -1){
            reservas.remove(existe);
            JOptionPane.showMessageDialog(null, "Reserva CANCELADA!");
        
        }else{
            JOptionPane.showMessageDialog(null, "Reserva não encontrada!!");
        }
      
    }

    public static int verificando(String achar){
    int existe = -1;

        for (int i=0; i<reservas.size() ; i++){

            if (reservas.get(i).getCliente() instanceof PessoaFisica){
                PessoaFisica pf = (PessoaFisica) reservas.get(i).getCliente();
                if (pf.getCpf().equals(achar)){  
                    existe = i;                        
                }
            }

            if (reservas.get(i).getCliente() instanceof PessoaJuridica){
                PessoaJuridica pj = (PessoaJuridica) reservas.get(i).getCliente();
                if (pj.getCnpj().equals(achar)){                   
                    existe = i;
                }
            }
        } 
    return existe;    
    }
}

