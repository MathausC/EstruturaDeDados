package com.estacao;


class Carro implements Comparable<Carro>{

    private String codigoDeIdentificacao;
    private String descricaoCaga;

    String getCodigoDeIdentificacao() {
        return codigoDeIdentificacao;
    }
    private void setCodigoDeIdentificacao(String codigo) {
        codigoDeIdentificacao = codigo;
    }

    String getDescricaoCaga() {
        return descricaoCaga;
    }
    private void setDescricaoCaga(String descricao) {
        descricaoCaga = descricao;
    }

    Carro(String codigo, String descricao) {
        setCodigoDeIdentificacao(codigo);
        setDescricaoCaga(descricao);
    }

    @Override
    public int compareTo(Carro o) {
        return this.getCodigoDeIdentificacao().compareTo(o.getCodigoDeIdentificacao());
    }
}
