import java.util.Scanner;
import com.controleProjeto.Controle;

public class AplicacaoControleProjetos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Controle c = new Controle();
        int resp;

        System.out.println("Bem vindo ao controle de projetos.");
        do {
            menu();
            resp = in.nextInt(); in.nextLine();
            switch (resp) {
                case 1: c.inserirProjeto(); break;
                case 2: c.removerProjeto(); break;
                case 0: System.out.println("Até mais"); break;
                default: System.out.println("Opção inválida."); break;
            }
        } while(resp != 0);
    }

    private static void menu() {
        String menu = "Informe uma das opções. \n" + 
                      "1 - Inserir um projeto\n" +
                      "2 - Remover projeto\n" + 
                      "0 - Encerrar\n" + 
                      "Opção: ";
        System.out.print(menu);
    }
}