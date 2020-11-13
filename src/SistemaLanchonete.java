import com.lanchonete.Atendimento;
import java.util.Scanner;

public class SistemaLanchonete {
    public static void main(String[] args) {
        Atendimento a = new Atendimento();
        Scanner in = new Scanner(System.in);
        System.out.print("Bem vindo a lanchote.");
        int resp;
        do {
            menu();
            resp = in.nextInt();
            switch (resp) {
                case 1: a.inserirPedido(); break;
                case 2: a.atenderPedido(); break;
                case 0: System.out.println("Adeus."); break;
                default: System.out.println("Opção inválida."); break;
            }
        } while (resp != 0);
    }

    private static void menu() {
        String menu = "\nInforme uma das opções abaixo.\n"
                    + "1 - Inserir um pedido;\n"
                    + "2 - Atender um cliente\n"
                    + "0 - Encerrar\n"
                    + "Opção: ";
        System.out.print(menu);
    }
}
