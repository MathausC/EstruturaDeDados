package com.controleProjeto;
import Lista9.Queue;
import java.util.Scanner;

public class Controle {
    private Queue<Projeto> projetos;
    private Scanner in;

    public Controle() {
        projetos = new Queue<Projeto>();
        in = new Scanner(System.in);
    }

    public void inserirProjeto() {
        System.out.print("Informe o nome do projeto: ");
        String nome = in.nextLine();
        System.out.print("Descreva o projeto: ");
        String descricao = in.nextLine();
        projetos.enQueue(new Projeto(nome, descricao));
        System.out.println("Projeto adicionado,");
    }

    public void removerProjeto() {
        projetos.deQueue();
        System.out.println("Projeto removido.");
    }
}
