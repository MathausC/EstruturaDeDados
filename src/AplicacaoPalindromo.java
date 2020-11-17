import java.util.Scanner;

import Lista8.Stack;

public class AplicacaoPalindromo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s, a;
        boolean validade;
        char resp;
        System.out.println("Vamos verificar se a String é um plalindromo.");
        do{
            System.out.print("Digite a string: ");
            s = in.nextLine();
            while(!validaString(s)) {
                System.out.println("String inválida.");
                System.out.print("Digite a string: ");
                s = in.nextLine();
            }
            a = s.toUpperCase();
            validade = éUmPalindromo(a);
            if(validade) {
                System.out.println("A String " + s + " é um palindromo.");
            } else {
                System.out.println("A String " + s + " não é um palindromo.");
            }
            System.out.print("Deseja informar outra String? (S - sim | N - não) ");
            resp = in.next().charAt(0); in.nextLine();
            resp = Character.toUpperCase(resp);
            while(resp != 'S' && resp != 'N') {
                System.out.println("Resposta inválida.");
                System.out.print("Deseja informar outra String? (S - sim | N - não) ");
                resp = in.next().charAt(0); in.nextLine();
                resp = Character.toUpperCase(resp);
            }
        }while(resp == 'S');
    }

    private static boolean validaString(String s) {
        String a = s.toUpperCase();
        int length = s.length();
        for(int i = 0; i < length; i++) {
            if(!Character.isLetter(a.charAt(i)) && !Character.isSpaceChar(a.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean éUmPalindromo(String string) {
        if(!string.isEmpty()) {
            int length = string.length();
            if(length != 1) {
                Stack<Character> stack = new Stack<Character>();
                Stack<Character> stack1 = new Stack<Character>();
                for(int i = length - 1; i >= 0; i--) {
                    if(Character.isLetter(string.charAt(i))) {
                        stack.push(string.charAt(i));
                        stack1.push(string.charAt((length -1) - i));
                    }
                }
                while(!stack.isEmpty() && !stack1.isEmpty()) {
                    if(stack.top() != stack1.top()) {
                        return false;
                    }
                    stack.pop();
                    stack1.pop();
                }
            }
        }
        return true;
    }
}
