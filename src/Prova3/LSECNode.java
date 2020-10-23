package Prova3;

class LSECNode<T extends Comparable<T>> {
    private LSECNode<T> prox;
    private T info;

    LSECNode(T info) {
        this.setInfo(info);
    }

    LSECNode<T> getProx() {
        return prox;
    }
    void setProx(LSECNode<T> node) {
        prox = node;
    }

    private void setInfo(T info) {
        this.info = info;
    }
    T getInfo() {
        return info;
    }
}
