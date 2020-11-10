import java.util.Scanner;

import Lista8.Stack;

public class AplicacaoFormacao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char resp;
        String s;
        boolean validade;
        System.out.println("Vamos verificar se a string está bem formada.");
        do{
            System.out.print("Digite a string: ");
            s = in.nextLine();
            validade = validaSFormacaoString(s);
            if(validade) {
                System.out.println("A String " + s + " está bem formada.");
            } else {
                System.out.println("A String " + s + " não está bem formada.");
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
        } while(resp == 'S');
    }

    public static boolean validaSFormacaoString(String string) {
        if (!string.isEmpty()) {
            Stack<Character> stack = new Stack<Character>();
            int length = string.length();
            for (int i = length - 1; i >= 0; i--) {
                char c = string.charAt(i);
                if (c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')') {
                    stack.push(c);
                }
            }
            if (!stack.isEmpty()) {
                if(stack.size() % 2 != 0) {
                    return false;
                }
                Stack<Character> stack1 = new Stack<Character>();
                while(!stack.isEmpty()) {
                    if(stack1.isEmpty()) {
                        stack1.push(stack.pop());
                        if(stack.isEmpty() && !stack1.isEmpty()) {
                            return false;
                        }
                    }else {
                        if(stack1.peek() == '(' && stack.peek() == ')') {
                            stack.pop();
                            stack1.pop();
                        } else if (stack1.peek() == '{' && stack.peek() == '}') {
                            stack.pop();
                            stack1.pop();
                        } else if (stack1.peek() == '[' && stack.peek() == ']') {
                            stack.pop();
                            stack1.pop();
                        } else if (stack1.peek() == ')' || stack1.peek() == '}' || stack1.peek() == ']'){
                            return false;
                        } else if (stack.peek() == ')' || stack.peek() == '}' || stack.peek() == ']') {
                            return false;
                        }
                        else {
                            stack1.push(stack.pop());
                            if(stack.isEmpty() && !stack1.isEmpty()) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
