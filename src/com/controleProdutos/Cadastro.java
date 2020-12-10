package com.controleProdutos;
import Lista11.Tree;
import java.util.Scanner;

public class Cadastro {
    Tree<Produto> arvoreProdutos;

    public Cadastro() {
        arvoreProdutos = new Tree<Produto>();
    }

    public void cadastrarProduto(){
        if(!arvoreProdutos.isFull()) {
            Produto p = criaProduto();
            arvoreProdutos.inserir(p);
        } else {
            System.out.println("A arvore está cheia.");
        }
    }

    private Produto criaProduto() {
        Scanner in = new Scanner(System.in);
        System.out.print("Infome o código do produdo: ");
        String codigo = in.nextLine();
        System.out.print("Infome a descrição do produto: ");
        String descricao = in.nextLine();
        System.out.print("Informe o fornecedor: ");
        String fornecedor = in.nextLine();
        System.out.print("Informe o preço: ");
        double preco = criaPreco();
        System.out.print("Informe a quantidade em estoque: ");
        int estoque  = criaEstoque();
        return new Produto(codigo, descricao, fornecedor, preco, estoque);
    }

    public void exibirProdutos() {
        //arvoreProdutos.exibirTodos();
        //arvoreProdutos.passeioEmOrdem();
        arvoreProdutos.passeioPreOrdem();
    }

    public void alterarPreco() {
        Produto p = criaProdutoBusca();
        p = arvoreProdutos.buscar(p);
        if(p == null) {
            System.out.println("Produto não encontrado.");
        } else {
            double preco = criaPreco();
            p.setPreco(preco);
        }
    }

    public void alterarEstoque() {
        Produto p = criaProdutoBusca();
        p = arvoreProdutos.buscar(p);
        if(p == null) {
            System.out.println("Produto não encontrado.");
        } else {
            int estoque = criaEstoque();
            p.setEstoque(estoque);
        }
    }

    public void exibeProduto() {
        Produto p = criaProduto();
        p = arvoreProdutos.buscar(p);
        if(p == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println(p);
        }
    }

    private Produto criaProdutoBusca() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o código do produto: ");
        String codigo = in.nextLine();
        return new Produto(codigo, "", "", 0, 0);
    }

    private double criaPreco() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o preço do produto: ");
        double preco = in.nextDouble(); in.nextLine();
        while(preco <= 0) {
            System.out.println("O preço deve ser maior que zero(0).");
            System.out.print("Informe o preço do produto: ");
            preco = in.nextDouble(); in.nextLine();
        }
        return preco;
    }

    private int criaEstoque() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o estoque do produto: ");
        int estoque = in.nextInt(); in.nextLine();
        while(estoque < 0) {
            System.out.println("O estoque não pode ser negativo.");
            System.out.print("Informe o estoque do produto: ");
            estoque = in.nextInt(); in.nextLine();
        }
        return estoque;
    }
}
