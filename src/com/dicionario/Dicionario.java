package com.dicionario;
import Prova4.LDEC;
import java.util.Scanner;

public class Dicionario {
    private LDEC<ListaDeTermos> listasDeTermos;
    private Scanner in;

    public Dicionario() {
        listasDeTermos = new LDEC<ListaDeTermos>();
        in = new Scanner(System.in);
    }

    public void inserirTermo() {
        Termo termo = criaTermo();
        ListaDeTermos l = criaListaDeTermos(termo);
        ListaDeTermos l1 = listasDeTermos.buscarObjeto(l);
        if(l1 == null) {
            listasDeTermos.inserir(l);
        } else {
            l1.getTermos().inserir(termo);
        }
    }

    private Termo criaTermo() {
        System.out.print("Informe um termo: ");
        String termo = in.nextLine();
        termo = termo.toUpperCase();
        int tamanhoTermo = termo.length();
        for(int i = 0; i < tamanhoTermo; i++) {
            if(!Character.isLetter(termo.charAt(i))) {
                System.out.println("O termo deve conter somente letras.");
                System.out.print("Informe um termo: ");
                termo = in.nextLine();
                termo = termo.toUpperCase();
                tamanhoTermo = termo.length();
                i = 0;
            }
        }

        System.out.print("Informe a descrição: ");
        String descricao = in.nextLine();

        return new Termo(termo, descricao);
    }

    private ListaDeTermos criaListaDeTermos(Termo termo) {
        char letra = termo.getNome().charAt(0);
        ListaDeTermos l = new ListaDeTermos(letra);
        l.getTermos().inserir(termo);
        return l;
    }

    public void removerTermo() {
        Termo termo = criaTermoDeBusca();
        ListaDeTermos l1 = buscaListaDoTermo(termo);
        if(l1 == null) {
            System.out.println("Não existe lista com a letra deste termo.");
        } else {
            l1.getTermos().remover(termo);
            if(l1.getTermos().getQtd() == 0) {
                listasDeTermos.remover(l1);
            }
        }
    }

    public void exibirTermo() {
        Termo termo = criaTermoDeBusca();
        ListaDeTermos l1 = buscaListaDoTermo(termo);
        if(l1 == null) {
            System.out.println("Não existe lista com a letra deste termo.");
        } else {
            l1.getTermos().exibirItem(termo);
        }
    }

    public void editaTermo() {
        Termo termo = criaTermoDeBusca();
        ListaDeTermos l1 = buscaListaDoTermo(termo);
        if(l1 == null) {
            System.out.println("Não existe lista com a letra deste termo.");
        } else {
            Termo termoHaAlterar = l1.getTermos().buscarObjeto(termo);
            if(termoHaAlterar == null) {
                System.out.println("Termo não encontrado.");
            } else {
                System.out.println("Informe a nova descrição do termo " + termoHaAlterar.getNome() + ":");
                String descricao = in.nextLine();
                termoHaAlterar.setDescricao(descricao);
                System.out.println("Descrição alterada.");
            }
        }
    }

    private Termo criaTermoDeBusca() {
        System.out.print("Informe o termo: ");
        String termo = in.nextLine();
        termo = termo.toUpperCase();
        int tamanhoTermo = termo.length();
        for(int i = 0; i < tamanhoTermo; i++) {
            if(!Character.isLetter(termo.charAt(i))) {
                System.out.println("O termo deve conter somente letras.");
                System.out.print("Informe um termo: ");
                termo = in.nextLine();
                termo = termo.toUpperCase();
                tamanhoTermo = termo.length();
                i = 0;
            }
        }
        return new Termo(termo, "");
    }

    private ListaDeTermos criaListaDeAcrescimo(Termo termo) {
        char letra = termo.getNome().charAt(0);
        letra = Character.toUpperCase(letra);
        return new ListaDeTermos(letra);
    }

    private ListaDeTermos buscaListaDoTermo(Termo termo) {
        ListaDeTermos l = criaListaDeAcrescimo(termo);
        ListaDeTermos l1 = listasDeTermos.buscarObjeto(l);
        return l1;
    }

    public void exibirTodosOsTermos() {
        listasDeTermos.exibirItens();
    }

    public void exibirTermos() {
        ListaDeTermos l = criaListaDeBusca();
        ListaDeTermos l1 = listasDeTermos.buscarObjeto(l);
        if(l1 == null) {
            System.out.println("Não há nenhum termo com essa letra.");
        } else {
            l1.exibirTermos();
        }
    }

    private ListaDeTermos criaListaDeBusca() {
        System.out.print("Informe a letra: ");
        char letra = in.next().charAt(0); in.nextLine();
        letra = Character.toUpperCase(letra);
        while(!Character.isLetter(letra)) {
            System.out.println("O caracter deve ser uma letra.");
            System.out.print("Informe a letra: ");
            letra = in.next().charAt(0); in.nextLine();
            letra = Character.toUpperCase(letra);
        }
        return new ListaDeTermos(letra);
    }
}
