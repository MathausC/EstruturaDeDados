package Prova1;

public class LSE<T extends Comparable<T>> {
	private LSENode<T> inicio;
	private LSENode<T> fim;
	private int qtd;
	
	public LSENode<T> getInicio() {
		return inicio;
	}
	private void setInicio(LSENode<T> node) {
		inicio = node;
	}
	
	public LSENode<T> getFim() {
		return fim;
	}
	private void setFim(LSENode<T> node) {
		fim = node;
	}
	
	private boolean isEmpty() {
		return inicio == null && fim == null;
	}
	
	public void incerirNó(T obj) {
		LSENode<T> node = new LSENode<T>(obj);
		if(isEmpty()) {
			this.setInicio(node);
			this.setFim(node);
		}
		else {
			if(inicio.getInfo().compareTo(obj) >= 0) {
				node.setProx(inicio);
				this.setInicio(node);
			}
			else if(fim.getInfo().compareTo(obj) < 0) {
				fim.setProx(node);
				this.setFim(node);
			}
			else {
				LSENode<T> ant = inicio;
				LSENode<T> aux = ant.getProx();
				while(true) {
					if(aux.getInfo().compareTo(obj) >= 0) {
						node.setProx(aux);
						ant.setProx(node);
						break;
					}
					ant = aux;
					aux = aux.getProx();
				}
			}
		}
		qtd++;
	}
	
}
