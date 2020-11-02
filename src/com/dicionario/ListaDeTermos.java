package com.dicionario;
import Prova4.LDEC;

class ListaDeTermos implements Comparable<ListaDeTermos>{
    private char letra;
    private LDEC<Termo> termos;

    char getLetra() {
        return letra;
    }
    private void setLetra(char letra) {
        this.letra = letra;
    }

    LDEC<Termo> getTermos() {
        return termos;
    }

    ListaDeTermos(char letra) {
        this.setLetra(letra);
        termos = new LDEC<Termo>();
    }

    void exibirTermos() {
        termos.exibirItens();
    }

    public int compareTo(ListaDeTermos listaDeTermos) {
        return this.getLetra() - listaDeTermos.getLetra();
    }

    public String toString() {
        return  "Letra: " + this.getLetra() + "\n"
                            + termos.toString();
    }
}
