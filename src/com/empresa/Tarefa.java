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
		Integer t = this.getPrioridade();
		Integer obj = tarefa.getPrioridade();
		return t.compareTo(obj);
	}
	
	public boolean equals(Tarefa tarefa) {
		return this.getDescricao().equalsIgnoreCase(tarefa.getDescricao());
	}

	public String toString() {
		return "Descrição: " + this.getDescricao() + "\n"
				+ "Prioridade: " + this.getPrioridade();
	}
}
