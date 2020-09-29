package com.empresa;

class Tarefa implements Comparable<Tarefa> {

	private String descricao;
	private int prioridade;

	String getDescricao() {
		return descricao;
	}

	private void setDescricao(String des) {
		descricao = des;
	}

	int getPrioridade() {
		return prioridade;
	}

	void setPrioridade(int prio) {
		prioridade = prio;
	}

	Tarefa(String descricao, int prioridade) {
		setDescricao(descricao);
		setPrioridade(prioridade);
	}

	@Override
	public int compareTo(Tarefa tarefa) {
		//Se tiver mesma descricao retorna zero;
		if (this.getDescricao().compareToIgnoreCase(tarefa.getDescricao()) == 0) {
			return 0;
		} else {
			//Se tiver mesma prioridade em prioridade maior por chegada.
			if (this.getPrioridade() - tarefa.getPrioridade() != 0) {
				return this.getPrioridade() - tarefa.getPrioridade();
			} else {
				return 1;
			}
		}
	}

	public String toString() {
		return "Descrição: " + this.getDescricao() + "\n"
				+ "Prioridade: " + this.getPrioridade();
	}
}
