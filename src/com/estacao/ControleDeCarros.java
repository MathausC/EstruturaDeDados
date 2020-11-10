package com.estacao;
import Lista8.Stack;
import java.util.Scanner;

public class ControleDeCarros {
    private Scanner in = new Scanner(System.in);
    private Stack<Carro> linhaDeTrens;

    public ControleDeCarros() {
        linhaDeTrens = new Stack<Carro>();
    }

    public void inserirCarro() {
        System.out.print("Informe o código do carro: ");
        String c = in.nextLine();
        System.out.print("Informe a descricao da carga: ");
        String d = in.nextLine();
        Carro carro = new Carro(c, d);
        inserir(carro);
    }

    private void inserir(Carro t) {
        Stack<Carro> linhaAux = new Stack<Carro>();
        if(linhaDeTrens.isFull()) {
            System.out.println("A linha está cheia.");
        } else {
            while(true) {
                if(!linhaDeTrens.isEmpty()) {
                    if(linhaDeTrens.peek().compareTo(t) > 0) {
                        linhaDeTrens.push(t);
                        while(!linhaAux.isEmpty() && !linhaDeTrens.isFull()) {
                            linhaDeTrens.push(linhaAux.pop());
                        }
                        break;
                    } else if(linhaDeTrens.peek().compareTo(t) == 0) {
                        System.out.println("Carro já está na linha.");
                        break;
                    } else {
                        if(!linhaDeTrens.isEmpty() && !linhaAux.isFull()) {
                            linhaAux.push(linhaDeTrens.pop());
                        } else {
                            linhaDeTrens.push(t);
                            while(!linhaAux.isEmpty() && !linhaDeTrens.isFull()) {
                                linhaDeTrens.push(linhaAux.pop());
                            }
                            break;
                        }
                    }
                } else {
                    linhaDeTrens.push(t);
                    while(!linhaAux.isEmpty() && !linhaDeTrens.isFull()) {
                        linhaDeTrens.push(linhaAux.pop());
                    }
                    break;
                }
            }
        }
    }

    public void removerCarro() {
        System.out.println("Informe o código do carro.");
        String c = in.nextLine();
        Carro carro = new Carro(c, "");
        remover(carro);
    }

    private void remover(Carro t) {
        if(linhaDeTrens.isEmpty()) {
            System.out.println("Linha está vazia.");
        } else {
            Stack<Carro> linhaAux = new Stack<Carro>();
            while(true) {
                if(!linhaDeTrens.isEmpty()) {
                    if(linhaDeTrens.peek().compareTo(t) == 0) {
                        linhaDeTrens.pop();
                        while(!linhaAux.isEmpty() && !linhaDeTrens.isFull()) {
                            linhaDeTrens.push(linhaAux.pop());
                        }
                        break;
                    } else {
                        if(!linhaDeTrens.isEmpty() && !linhaAux.isFull()) {
                            linhaAux.push(linhaDeTrens.pop());
                        } else {
                            System.out.println("Trem não encontrado.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Carro não encontrado.");
                    break;
                }
            }
        }
    }
}
