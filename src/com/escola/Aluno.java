package com.escola;

class Aluno implements Comparable<Aluno> {
    private String nome;
    private String matricula;
    private double media;
    private int faltas;

    String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    String getMatricula() {
        return matricula;
    }
    private void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    double getMedia() {
        return media;
    }
    void setMedia(double media) {
        this.media = media;
    }

    int getFaltas() {
        return faltas;
    }
    void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    Aluno(String nome, String matricula, double media, int faltas) {
        setNome(nome);
        setMatricula(matricula);
        setMedia(media);
        setFaltas(faltas);
    }

    public int compareTo(Aluno aluno) {
        return this.matricula.compareToIgnoreCase(aluno.matricula);
    }

    @Override
    public String toString() {
        String mensagem;
        mensagem =  "Matricula: " + matricula + "\n" +
                    "Nome: " + nome + "\n" +
                    "Média: " + media + "\n" +
                    "Faltas: " + faltas + "\n";
        return mensagem;
    }
}
