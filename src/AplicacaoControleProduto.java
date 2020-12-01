import java.util.Scanner;
import com.controleProdutos.Cadastro;

public class AplicacaoControleProduto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cadastro c = new Cadastro();
        char resp;
        do {
            menu();
            resp = in.next().charAt(0); in.nextLine();
            switch(resp) {
                case '1': c.cadastrarProduto(); break;
                case '2': c.exibirProdutos(); break;
                case '3': c.alterarPreco(); break;
                case '4': c.alterarEstoque(); break;
                case '5': c.exibeProduto(); break;
                case '0': System.out.println("Até mais!"); break;
                default : System.out.println("Opção inválida."); break;
            }
        } while(resp != '0');
    }

    private static void menu() {
        String menu =   "Informe uma das opções abaixo.\n" +
                        "1 - Cadastrar produto\n" +
                        "2 - Exibir produtos\n" + 
                        "3 - Alterar preço\n" + 
                        "4 - Alterar estoque\n" + 
                        "5 - Exibir produto\n" + 
                        "0 - Encerrar\n" + 
                        "Opção: ";
        System.out.print(menu);
    }
}
