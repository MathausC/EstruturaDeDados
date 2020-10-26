package Lista7;

public class LDENode<T extends Comparable<T>> {
    private LDENode<T> ant;
    private LDENode<T> prox;
    private T info;

    public LDENode<T> getAnt() {
        return ant;
    }
    void setAnt(LDENode<T> node) {
        ant = node;
    }

    public LDENode<T> getProx() {
        return prox;
    }
    void setProx(LDENode<T> node) {
        prox = node;
    }

    public T getInfo() {
        return info;
    }
    private void setInfo(T info) {
        this.info = info;
    }

    LDENode(T info) {
        setInfo(info);
    }
}
