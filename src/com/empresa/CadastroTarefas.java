package com.empresa;

import Lista5.*;
import java.util.Scanner;

public class CadastroTarefas {
	private LDEOrdenada<Tarefa> tarefas;
	private Scanner in;

	public CadastroTarefas() {
		tarefas = new LDEOrdenada<Tarefa>();
		in = new Scanner(System.in);
	}

	public void cadastrarTarefa() {
		Tarefa t = criaTarefa();
		tarefas.incerir(t);
	}

	public void exibirQuantidadePrioritaria() {
		Tarefa t = criaTarefaDeBusca();
		int quantidadeTarefas = tarefas.quantidadeObjetos(t);
		if (quantidadeTarefas == -1) {
			System.out.println("Tarefa não encontrada");
		} else {
			System.out.println("Existem " + quantidadeTarefas + " tarefas com maior prioridade.");
		}
	}
	
	public void executarTarefa() {
		tarefas.removerPrimeiro();
	}
	
	public void cancelarExecucao() {
		Tarefa t = criaTarefaDeBusca();
		tarefas.remover(t);
	}
	
	public void exibirPorPrioridade() {
		System.out.print("Informe a prioridade de 0(zero) a 10(dez): ");
		int p = in.nextInt(); in.nextLine();
		while (p < 0 || p > 10) {
			System.out.println("Prioridade inválida.");
			System.out.print("Informe a prioridade de 0(zero) a 10(dez): ");
			p = in.nextInt(); in.nextLine();
		}
		int val = 0;
		LDENode<Tarefa> aux = tarefas.getInicio();
		while(aux != null) {
			if(aux.getInfo().getPrioridade() == p) {
				System.out.println(aux.getInfo());
				val++;
			}
		}
		System.out.println("Total de item com prioridade " + p + ": " + val + ".");
	}
	
	public void exibirTarefas() {
		tarefas.exibirLista();
	}
	
	public void alterarPrioridade() {
		Tarefa t = criaTarefaDeBusca();
		t = tarefas.buscarObjeto(t);
		System.out.print("Informe a prioridade de 0(zero) a 10(dez): ");
		int p = in.nextInt(); in.nextLine();
		while (p < 0 || p > 10) {
			System.out.println("Prioridade inválida.");
			System.out.print("Informe a prioridade de 0(zero) a 10(dez): ");
			p = in.nextInt(); in.nextLine();
		}
		t.setPrioridade(p);
		tarefas.remover(t);
		tarefas.incerir(t);
	}

	private Tarefa criaTarefaDeBusca() {
		System.out.println("Informe a descrição da tarefa: ");
		String descricao = in.nextLine();
		return new Tarefa(descricao, 0);
	}

	private Tarefa criaTarefa() {
		System.out.print("Informe a descrição da tarefa: ");
		String descricao = in.nextLine();
		System.out.print("Informe a prioridade de 0(zero) a 10(dez): ");
		int prioridade = in.nextInt();
		in.nextLine();
		while (prioridade < 0 || prioridade > 10) {
			System.out.println("Prioridade inválida.");
			System.out.print("Informe a prioridade de 0(zero) a 10(dez): ");
			prioridade = in.nextInt();
			in.nextLine();
		}
		return new Tarefa(descricao, prioridade);
	}
}
