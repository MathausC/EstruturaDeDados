import Lista8.Stack;

import java.util.Scanner;

public class ConversorBase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char resp;
        int base, numero;
        System.out.println("Vamos converter um numero para outra base.");
        do {
            System.out.print("Informe o número para a conversão: ");
            numero = in.nextInt(); in.nextLine();
            while(numero < 0) {
                System.out.println("O número não pode ser negativo.");
                System.out.print("Informe o número para a conversão: ");
                numero = in.nextInt(); in.nextLine();
            }

            System.out.print("Informe a base para a conversão: ");
            base = in.nextInt(); in.nextLine();
            while(base < 2 || base > 9) {
                System.out.println("Base inválida deve ser de 2 a 9.");
                System.out.print("Informe a base para a conversão: ");
                base = in.nextInt(); in.nextLine();
            }

            converteBase(numero, base);
            System.out.print("Deseja converter novamente? (S - sim | N - não) ");
            resp = in.next().charAt(0);
            resp = Character.toUpperCase(resp);
            while (resp != 'S' && resp != 'N') {
                System.out.println("Resposta inválida.");
                System.out.print("Deseja converter novamente? (S - sim | N - não) ");
                resp = in.next().charAt(0);
                resp = Character.toUpperCase(resp);
            }
        }while(resp == 'S');
    }

    private static void converteBase(int numero, int novaBase) {
        Stack<Integer> stack = new Stack<Integer>();
        int n;
        while(true) {
            if(numero/novaBase == 0) {
                n = numero % novaBase;
                stack.push(n);
                break;
            }
            n = numero % novaBase;
            stack.push(n);
            numero = numero / novaBase;

        }
        while(!stack.isEmpty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
        System.out.println();
    }
}
