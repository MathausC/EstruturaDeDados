package com.controleProjeto;

public class Projeto {
    private String descricao;
    private String nome;

    String getDescricao() {
        return descricao;
    }
    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }


    Projeto(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
    }

    public String toString() {
        String mensagem = "Projeto: " + getNome() + "\n"
        + "Descricao" + getDescricao();
        return mensagem;
    }
    
}
