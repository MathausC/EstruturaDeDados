import java.util.Scanner;
import com.estacao.ControleDeCarros;

public class LinhaDosTrens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ControleDeCarros c = new ControleDeCarros();
        char resp;
        String codigo, descricao;
        System.out.println("Vamos organizar a linha dos trens.");
        do {
            menu();
            resp = in.next().charAt(0); in.nextLine();
            switch (resp) {
                case '1': c.inserirCarro(); break;
                case '2': c.removerCarro(); break;
                case '0': System.out.println("Obrigado e até mais.");
            }
        } while(resp != '0');
    }

    private static void menu() {
        String menu = "Informe uma das opções abaixo.\n" +
                    "1 - Inserir carros no trilho\n" +
                    "2 - Remover carro do trilho\n" +
                    "0 - Encerra.\n" +
                    "Opção: ";
        System.out.print(menu);
    }
}
