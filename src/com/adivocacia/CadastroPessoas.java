package com.adivocacia;
import Lista4.LDE;
import java.util.Scanner;

public class CadastroPessoas {
	private LDE<Pessoa> lista;
	private Scanner in;
	
	public CadastroPessoas() {
		lista = new LDE<Pessoa>();
		in = new Scanner(System.in);
	}
	
	public void cadastrarPessoa() {
		lista.incerir(criarPessoa());
	}
	
	public void cancelarCadastroImediato() {
		lista.removerUltimo();
	}	
	
	public void exibirPessoas() {
		lista.exibirLista();
	}
	
	public void verificarPresença() {
		lista.exibirItem(criaPessoaDePesquisa());
	}
	
	public void pessoasPresentes() {
		System.out.println("Quantidade de pessoas no prédio: " + lista.getQtd());
	}
	
	public void removerPessoa() {
		lista.remover(criaPessoaDePesquisa());
	}
	
	private Pessoa criaPessoaDePesquisa() {
		System.out.print("Informe o RG da pessoa: ");
		String rg = in.nextLine();
		while(!validaRg(rg)) {
			System.out.println("O RG deve conter somente sete dígitos e somente digitos.");
			System.out.println("Informe o RG da Pessoa: ");
			rg = in.nextLine();
		}
		return new Pessoa("", rg);
	}
	
	private Pessoa criarPessoa() {
		System.out.println("Informe o nome da pessoa: ");
		String nome = in.nextLine();
		nome = nome.toUpperCase();
		while(!validaNome(nome)) {
			System.out.println("O nome só deverar conter letras e espaços, sem espaços consecutivos.");
			System.out.println("Informe o nome da pessoa: ");
			nome = in.nextLine();
			nome = nome.toUpperCase();
		}
		System.out.println("Informe o RG: ");
		String rg = in.nextLine();
		while(!validaRg(rg)) {
			System.out.println("O RG deve conter somente sete dígitos e somente digitos.");
			System.out.println("Informe o RG: ");
			rg = in.nextLine();
		}
		return new Pessoa(nome, rg);
	}
	
	private boolean validaNome(String nome) {
		int length = nome.length();
		char ant, aux;
		for(int i = 0; i < length; i++) {
			if(!Character.isAlphabetic(nome.charAt(i)) && nome.charAt(i) != ' ') {
				return false;
			}
			if(i > 0) {
				ant = nome.charAt(i-1);
				aux = nome.charAt(i);
				if(ant == ' ' && aux == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean validaRg(String rg) {
		int length = rg.length();
		if(length != 7) {
			return false;
		}
		else {
			for(int i = 0; i < length; i++) {
				if(!Character.isDigit(rg.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}
}
