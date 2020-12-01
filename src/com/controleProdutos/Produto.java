package com.controleProdutos;

class Produto implements Comparable<Produto>{
    private String codigo;
    private String descricao;
    private String fornecedor;
    private double preco;
    private int estoque;

    String getCodigo() {
        return codigo;
    }
    private void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    String getDescricao() {
        return descricao;
    }
    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    String getFornecedor() {
        return fornecedor;
    }
    private void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    double getPreco() {
        return preco;
    }
    void setPreco(double valor) {
        preco = valor;
    }

    int getEstoque() {
        return estoque;
    }
    void setEstoque(int quantidade) {
        estoque = quantidade;
    }

    Produto(String codigo, String descricao, String fornecedor, double preco, int estoque) {
        setCodigo(codigo);
        setDescricao(descricao);
        setFornecedor(fornecedor);
        setPreco(preco);
        setEstoque(estoque);
    }

    public int compareTo(Produto p) {
        return this.getCodigo().compareTo(p.getCodigo());
    }

    public String toString() {
        String mensagem;
        mensagem  = "Código: " + codigo + "\n" +
                    "Descricao: " + descricao + "\n" +
                    "Fornecedor: " + fornecedor + "\n" +
                    "Preco: " + preco + "\n" +
                    "Estoque: " + estoque;
        return mensagem;
    }
}
