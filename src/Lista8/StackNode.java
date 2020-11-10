package Lista8;

class StackNode<T extends Comparable<T>> {
    private StackNode<T> prox;
    private T info;

    T getInfo() {
        return info;
    }
    private void setInfo(T info) {
        this.info = info;
    }

    StackNode<T> getProx() {
        return prox;
    }
    void setProx(StackNode<T> node) {
        prox = node;
    }

    StackNode(T info) {
        this.setInfo(info);
    }
}
