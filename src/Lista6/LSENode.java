package Lista6;

class LSENode<T extends Comparable<T>> {
    private T info;
    private LSENode<T> prox;

    LSENode(T info) {
        setInfo(info);
    }

    T getInfo() {
        return info;
    }
    LSENode<T> getProx() {
        return prox;
    }
    protected void setInfo(T info) {
        this.info = info;
    }
    void setProx(LSENode<T> node) {
        prox = node;
    }
}
