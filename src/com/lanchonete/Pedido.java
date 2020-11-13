package com.lanchonete;

public class Pedido {
    private String nomeCliente;
    private String descricao;
    private double preco;

    String getNomeCliente() {
        return nomeCliente;
    }
    private void setNomeCliente(String nome) {
        nomeCliente = nome;
    }

    String getDescricao() {
        return descricao;
    }
    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    double getPreco() {
        return preco;
    }
    private void setPreco(double valor) {
        preco = valor;
    }

    Pedido(String nome, String descricao, double valor) {
        this.setNomeCliente(nome);
        this.setDescricao(descricao);
        this.setPreco(valor);
    }

    public String toString() {
        String mensagem = "Cliente: " + this.getNomeCliente() + "\n"
                        + "Pedido: " + this.getDescricao() + "\n"
                        + "Preço: " + this.getPreco();
        return mensagem;
    }
}
