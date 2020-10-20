package com.escola;

import Lista6.LSEC;

import java.util.Scanner;

public class CadastroAlunos {
    private LSEC<Aluno> alunos;

    public CadastroAlunos() {
        alunos = new LSEC<Aluno>();
    }

    private Aluno criarAluno() {
        String nome, matricula;
        double media;
        int faltas;
        Scanner in = new Scanner(System.in);

        System.out.print("Informe o nome do aluno: ");
        nome = in.nextLine();
        boolean valido;
        do{
            valido = true;
            int length = nome.length();
            for(int i = 0; i < length; i++) {
                if(!Character.isLetter(nome.charAt(i)) && !Character.isSpaceChar(nome.charAt(i))) {
                    valido = false;
                    break;
                }
            }
            if(!valido) {
                System.out.println("Nome inválido.");
                System.out.print("Informe um nome somente com letras e espaços em branco: ");
                nome = in.nextLine();
            }
        }while (!valido);

        System.out.println("Infome a matricula do aluno");
        matricula = in.nextLine();

        media = criaMedia();

        faltas = criaFaltas();

        return new Aluno(nome, matricula, media, faltas);
    }

    public void cadastrarAluno() {
        System.out.println("Vamos cadastrar um novo aluno.");
        alunos.inserir(criarAluno());
    }

    public void exibirAlunos() {
        alunos.exibirItems();
    }

    private Aluno consultarAluno() {
        return alunos.buscaItem(criaAlunoDePesquisa());
    }

    private Aluno criaAlunoDePesquisa() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe a matricula do aluno: ");
        String matricula = in.nextLine();
        return new Aluno("", matricula, 0,0);
    }

    public void alterarMediaFinal() {
        Aluno aluno = consultarAluno();
        if(aluno == null) {
            System.out.println("Aluno não encontrado");
        }
        else {
            aluno.setMedia(criaMedia());
        }
    }


    public void alterarFaltas() {
        Aluno aluno = consultarAluno();
        if(aluno == null) {
            System.out.println("Aluno não encontrado");
        }
        else {
            aluno.setFaltas(criaFaltas());
        }
    }

    public void exibeAluno() {
        alunos.exibirItem(criaAlunoDePesquisa());
    }

    public void removerAluno() {
        alunos.remover(criaAlunoDePesquisa());
    }

    private double criaMedia() {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe a nova média: ");
        double media = in.nextDouble(); in.nextLine();
        while(media < 0 || media > 10) {
            System.out.println("Média inválida");
            System.out.print("Informe uma média de 0 a 10: ");
            media = in.nextDouble(); in.nextLine();
        }
        return media;
    }

    private int criaFaltas() {
        Scanner in = new Scanner(System.in);
        int faltas;
        System.out.print("Informe a quantidade de faltas do aluno: ");
        faltas = in.nextInt(); in.nextLine();
        while(faltas < 0) {
            System.out.println("Quantidade inválida.");
            System.out.print("Informe a quantidade de faltas do aluno com valor positivo: ");
            faltas = in.nextInt(); in.nextLine();
        }
        return faltas;
    }
}
