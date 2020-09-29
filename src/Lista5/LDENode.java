package Lista5;

public class LDENode<T extends Comparable<T>> {
	private LDENode<T> ant;
	private LDENode<T> prox;
	private T info;
	
	LDENode<T> getAnt() {
		return this.ant;
	}
	void setAnt(LDENode<T> node) {
		this.ant = node;
	}
	
	LDENode<T> getProx() {
		return this.prox;
	}
	void setProx(LDENode<T> node) {
		this.prox = node;
	}
	
	public T getInfo() {
		return this.info;
	}
	void setInfo(T obj) {
		this.info = obj;
	}
	
	LDENode(T obj) {
		this.setInfo(obj);
	}
}
