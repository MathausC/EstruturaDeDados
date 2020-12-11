import Prova5.Tree;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Tree<Character>arvoreInt = new Tree<Character>();
        Scanner in = new Scanner(System.in);
        int resp;
        Character i;
        do {
            menu();
            resp = in.nextInt(); in.nextLine();
            switch(resp) {

                case 1:
                    System.out.print("Inteiro: ");
                    i = in.next().charAt(0); in.nextLine();
                    arvoreInt.inserir(i);
                    break;
                case 2:
                    System.out.print("Inteiro a procurar: ");
                    i = in.next().charAt(0); in.nextLine();
                    System.out.println("Quantidade " + arvoreInt.buscaValor(i));
                    break;
                case 3:
                    System.out.println("O menor nó tem indereço " + arvoreInt.buscaMenorNode());
                    break;
                case 0:
                    System.out.println("Até mais");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }while (resp != 0);
        in.close();
    }

    private static void menu() {
        String menu = "1 - Inserir\n"
                    + "2 - Contar\n"
                    + "3 - Pegar nó\n"
                    + "0 - Encerrar\n"
                    + "Opção: ";
        System.out.print(menu);
    }
}
