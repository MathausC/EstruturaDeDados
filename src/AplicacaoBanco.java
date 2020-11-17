import com.banco.ControleSenha;
import java.util.Scanner;

public class AplicacaoBanco {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ControleSenha c = new ControleSenha();
        char resp;
        System.out.println("Bem vindo ao banco só dinheiro.");
        do {
            menu();
            resp = in.next().charAt(0); in.nextLine();
            switch(resp) {
                case '1': c.fornecerSenha(); break;
                case '2': c.atenderCliente(); break;
                case '0': System.out.println("Até mais."); break;
                default: System.out.println("Opção inválida."); break;
            }
        } while(resp != '0');        
    }
    
    private static void menu() {
        String menu = "Informe uma opção.\n"
                    + "1 - Fornecer senha\n"
                    + "2 - Atender cliente\n"
                    + "0 - Encerrar\n"
                    + "Opção: ";
        System.out.println(menu);
    }
}