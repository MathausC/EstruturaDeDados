//APLICAÇÃO 

import java.util.Scanner;
import ProvaExtra.Deque;

public class AplicacaoDeque {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> d = new Deque<Integer>();
        char resp;
        int num;

        System.out.println("Vamos começar nosso Deque de inteiros");
        do {
            menu();
            resp = in.next().charAt(0); in.nextLine();
            switch (resp) {
                case '1':
                    if(d.isFull()) {
                        System.out.println("Não há espaço para inserir o inteiro.");
                    } else {
                        System.out.print("Informe um número inteiro: ");
                        num = in.nextInt(); in.nextLine();
                        d.push(num);
                        System.out.println("O número " + num + " foi adicionado no começo do Deque.");
                    }
                    break;
                case '2':
                    if(d.isEmpty()){
                        System.out.println("Não há inteiros a serem removidos.");
                    } else {
                        num = d.pop();
                        System.out.println("O número " + num + " foi retirado do começo do Deque.");
                    }                        
                    break;
                case '3':
                    if(d.isFull()) {
                        System.out.println("Não há espaço para inserir o inteiro.");
                    } else {
                        System.out.print("Informe um número inteiro: ");
                        num = in.nextInt(); in.nextLine();
                        d.inject(num);
                        System.out.println("O número " + num + " foi adicionado no fim do Deque.");
                    }
                    break;
                case '4':
                    if(d.isEmpty()) {
                        System.out.println("Não há inteiros a serem removidos.");
                    } else {
                        num = d.eject();
                        System.out.println("O número " + num + " foi retirado do fim do Deque.");
                    }
                    break;
                case '0':
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while(resp != '0');
        in.close();
    }

    private static void menu() {
        String menu = "Informe uma opção.\n"
                    + "1 - inserir no começo\n"
                    + "2 - inserir no fim\n"
                    + "3 - remover do começo\n"
                    + "4 - remover do fim\n"
                    + "0 - encerrar\n"
                    + "Opção: ";
        System.out.print(menu);
    }
}
