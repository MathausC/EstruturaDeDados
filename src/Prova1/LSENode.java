package Prova1;

class LSENode<T extends Comparable<T>> {
	private LSENode<T> prox;
	private T info;
	
	T getInfo() {
		return info;
	}
	private void setInfo(T info) {
		this.info = info;
	}
	
	LSENode<T> getProx() {
		return prox;
	}
	void setProx(LSENode<T> node) {
		prox = node;
	}
	
	LSENode(T obj) {
		setInfo(obj);
	}
}
