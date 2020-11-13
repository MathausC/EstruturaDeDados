package com.lanchonete;
import Lista9.Queue;
import java.util.Scanner;

public class Atendimento {
    Queue<Pedido> filaPedidos;
    Scanner in;

    public Atendimento() {
        in = new Scanner(System.in);
        filaPedidos = new Queue<Pedido>();
    }

    public void inserirPedido() {
        System.out.print("Informe o nome do cliente: ");
        String nome = in.nextLine();
        System.out.print("Informe o pedido: ");
        String descricao = in.nextLine();
        System.out.print("Informe  valor do pedido: ");
        double valor = in.nextDouble(); in.nextLine();
        while(valor <= 0) {
            System.out.println("O valor deve ser maior que zero.");
            System.out.print("Informe  valor do pedido: ");
            valor = in.nextDouble(); in.nextLine();
        }
        Pedido p = new Pedido(nome, descricao, valor);
        if(!filaPedidos.isFull()) {
            filaPedidos.enQueue(p);
            System.out.println("Pedido inserido.");
        } else {
            System.out.println("Fila cheia.");
        }
    }

    public void atenderPedido() {
        Pedido p = filaPedidos.deQueue();
        if(p == null) {
            System.out.println("\nNão há pedidos a serem atendidos.\n");
        } else {
            System.out.println(p);
            System.out.println("Pedido atendido.\n");
        }
    }
}