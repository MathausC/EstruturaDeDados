package com.adivocacia;

class Pessoa implements Comparable<Pessoa> {
	private String nome;
	private String rg;
	
	String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	String getRg() {
		return rg;
	}
	private void setRg(String rg) {
		this.rg = rg;
	}
	
	Pessoa(String nome, String rg) {
		this.setNome(nome);
		this.setRg(rg);
	}
	
	@Override
	public int compareTo(Pessoa p) {
		return this.getRg().compareTo(p.getRg());
	}
	
	@Override
	public String toString() {
		String mensagem = "Nome: " + this.getNome() + "\n"
				+ "RG: " + this.getRg();
		return mensagem;
	}
	
}
