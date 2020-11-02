import com.dicionario.Dicionario;

import java.util.Scanner;

public class AplicacaoDicionario {
    public static void main(String[] args) {
        Dicionario d = new Dicionario();
        Scanner in = new Scanner(System.in);
        int resp;
        System.out.println("Vamos começar a usar o nosso dicionario");
        do {
            menu();
            resp = in.nextInt(); in.nextLine();

            switch (resp) {
                case 1: d.inserirTermo(); break;
                case 2: d.removerTermo(); break;
                case 3: d.exibirTermo(); break;
                case 4: d.editaTermo(); break;
                case 5: d.exibirTodosOsTermos(); break;
                case 6: d.exibirTermos(); break;
                case 0: System.out.println("Até mais!"); break;
                default: System.out.println("Opção inválida"); break;
            }
        } while(resp != 0);
    }

    private static void menu() {
        String menu =
            "Informe uma das opções abaixo.\n" +
            "1 - Adicionar um termo ao dicionário\n" +
            "2 - Remover um termo do dicionário\n" +
            "3 - Exibir a definição de um termo\n" +
            "4 - Editar definição de um termo\n" +
            "5 - Exibir todos os termos\n" +
            "6 - Exibir todos os termos começando com uma letra\n" +
            "0 - Encerrar\n" +
            "Opção: "
        ;
        System.out.print(menu);
    }
}
