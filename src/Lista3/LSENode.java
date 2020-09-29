package Lista3;

public class LSENode<T extends Comparable<T>> {
	private T info;
	private LSENode<T> prox;

	void setInfo(T obj) {
		this.info = obj;
	}

	public T getInfo() {
		return this.info;
	}

	void setProx(LSENode<T> prox) {
		this.prox = prox;
	}

	public LSENode<T> getProx() {
		return this.prox;
	}

	public LSENode(T obj) {
		setInfo(obj);
	}
}
