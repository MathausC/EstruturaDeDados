package Lista5;

public class LDEOrdenada<T extends Comparable<T>> {

	private LDENode<T> inicio;
	private LDENode<T> fim;
	private int qtd;

	public LDENode<T> getInicio() {
		return this.inicio;
	}

	private void setInicio(LDENode<T> node) {
		this.inicio = node;
	}

	public LDENode<T> getFim() {
		return this.fim;
	}

	private void setFim(LDENode<T> node) {
		this.fim = node;
	}

	private boolean isEmpty() {
		return this.inicio == null;
	}

	public int getQtd() {
		return this.qtd;
	}

	public void incerir(T obj) {
		LDENode<T> node = new LDENode<T>(obj);
		if (isEmpty()) {
			this.setInicio(node);
			this.setFim(node);
			this.qtd++;
			System.out.println("Item incerido.");
		} else {
			LDENode<T> index = buscarItem(obj);
			if (index != null) {
				LDENode<T> inicio = this.getInicio();
				LDENode<T> fim = this.getFim();
				if (inicio.getInfo().compareTo(obj) < 0) {
					node.setProx(inicio);
					inicio.setAnt(node);
					this.setInicio(node);
				} else if (fim.getInfo().compareTo(obj) >= 0) {
					fim.setProx(node);
					node.setAnt(fim);
					this.setFim(node);
				} else {
					LDENode<T> aux = fim;
					while (aux.getInfo().compareTo(obj) < 0) {
						if (aux.getInfo().compareTo(obj) >= 0) {
							aux.getProx().setAnt(node);
							node.setProx(aux.getProx());
							aux.setProx(node);
							node.setAnt(aux);
							break;
						}
					}
					this.qtd++;
				}
			}
		}
	}

	public void removerPrimeiro() {
		if (!isEmpty()) {
			if (qtd == 1) {
				this.setInicio(null);
				this.setFim(null);
				qtd--;
				System.out.println("Item removido.");
			} else {
				LDENode<T> prox = this.getInicio().getProx();
				prox.setAnt(null);
				this.setInicio(prox);
				qtd--;
				System.out.println("Item cancelado.");
			}
		} else {
			System.out.println("Não há itens a serem cancelados.");
		}
	}

	public void exibirLista() {
		if (!isEmpty()) {
			LDENode<T> aux = this.getInicio();
			while (aux != null) {
				System.out.println(aux.getInfo());
				aux = aux.getProx();
			}
		} else {
			System.out.println("Não a itens a serem exibidos.");
		}
	}

	public void exibirItem(T obj) {
		LDENode<T> index = buscarItem(obj);
		if (index == null) {
			System.out.println("Item não encontrado.");
		} else {
			System.out.println(index.getInfo());
		}
	}

	public void remover(T obj) {
		if (!isEmpty()) {
			LDENode<T> index = buscarItem(obj);
			if (index == null) {
				System.out.println("Item não pertence a lista.");
			} else {
				if (qtd == 1) {
					this.setInicio(null);
					this.setFim(null);
				} else if (inicio.getInfo().compareTo(index.getInfo()) == 0) {
					this.setInicio(inicio.getProx());
					inicio.setAnt(null);
				} else if (fim.getInfo().compareTo(index.getInfo()) == 0) {
					this.setFim(fim.getAnt());
					fim.setProx(null);
				} else {
					index.getAnt().setProx(index.getProx());
					index.getProx().setAnt(index.getAnt());
				}
				System.out.println("Item removido.");
				this.qtd--;
			}
		} else {
			System.out.println("Nao a itens a serem removidos.");
		}
	}

	private LDENode<T> buscarItem(T obj) {
		LDENode<T> index = this.getInicio();
		while (index != null) {
			if (index.getInfo().equals(obj)) {
				break;
			}
			index = index.getProx();
		}
		return index;
	}

	public T buscarObjeto(T obj) {
		LDENode<T> index = this.getInicio();
		while (index != null) {
			if (index.getInfo().equals(obj)) {
				break;
			}
			index = index.getProx();
		}
		return index.getInfo();
	}

	public int quantidadeObjetos(T obj) {
		int val = 0;
		LDENode<T> aux = this.getInicio();
		while (aux != null) {
			if (aux.getInfo().compareTo(obj) == 0) {
				return val;
			}
			val++;
		}
		return -1;
	}
}
