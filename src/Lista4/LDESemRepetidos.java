package Lista4;

public class LDESemRepetidos<T extends Comparable<T>> {
	
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
		}
		else {
			if (this.getInicio().getInfo().compareTo(obj) == 0) {
				System.out.println("Item já existe na lista.");
			}
			else {
				this.getFim().setProx(node);
				node.setAnt(this.getFim());
				this.setFim(node);
				this.qtd++;
				System.out.println("Item incerido.");
			}
		}
	}
	
	public void removerUltimo() {
		if(!isEmpty()) {
			if(qtd == 1) {
				this.setInicio(null);
				this.setFim(null);
				this.qtd--;
				System.out.println("Item cancelado.");
			}
			else {
				this.setFim(this.getFim().getAnt());
				this.getFim().setProx(null);
				qtd--;
				System.out.println("Item cancelado.");
			}
		}
		else {
			System.out.println("Não há itens a serem cancelados.");
		}
	}
	
	public void exibirLista() {
		if(!isEmpty()) {
			LDENode<T> aux = this.getInicio();
			while(aux != null) {
				System.out.println(aux.getInfo());
				aux = aux.getProx();
			}
		}
		else {
			System.out.println("Não a itens a serem exibidos.");
		}
	}
	
	public void exibirItem(T obj) {
		LDENode<T> index = buscarItem(obj);
		if(index == null) {
			System.out.println("Item não encontrado.");
		}
		else {
			System.out.println(index.getInfo());
		}
	}
	
	public void remover(T obj) {
		if(!isEmpty()) {
			LDENode<T> index = buscarItem(obj);
			if(index == null) {
				System.out.println("Item não pertence a lista.");
			}
			else {
				if(this.qtd == 1) {
					this.setInicio(null);
					this.setFim(null);
				}
				else if(this.getInicio().getInfo().compareTo(index.getInfo()) == 0) {
					this.setInicio(this.getInicio().getProx());
					this.getInicio().setAnt(null);
				}
				else if(this.getFim().getInfo().compareTo(index.getInfo()) == 0) {
					this.setFim(this.getFim().getAnt());
					this.getFim().setProx(null);
				}
				else {
					index.getAnt().setProx(index.getProx());
					index.getProx().setAnt(index.getAnt());
				}
				System.out.println("Item removido.");
				this.qtd--;
			}
		}
		else {
			System.out.println("Nao a itens a serem removidos.");
		}
	}
	
	private LDENode<T> buscarItem(T obj) {
		LDENode<T> index = this.getInicio();		
		while(index != null) {
			if(index.getInfo().compareTo(obj) == 0) {
				break;
			}
		}
		return index;
	}
}
