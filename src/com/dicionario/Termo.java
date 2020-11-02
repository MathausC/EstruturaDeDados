package com.dicionario;

class Termo implements Comparable<Termo>{
    private String nome;
    private String descricao;

    String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    String getDescricao() {
        return descricao;
    }
    void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    Termo(String nome, String descricao) {
        this.setNome(nome);
        this.setDescricao(descricao);
    }
    @Override
    public String toString() {
        return "Termo: " + this.getNome() + "\n" +
                "Descrição: " + this.getDescricao();
    }

    public int compareTo(Termo termo) {
        return this.getNome().compareTo(termo.getNome());
    }
}
