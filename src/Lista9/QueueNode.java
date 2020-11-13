package Lista9;

class QueueNode<T> {
    private T info;
    private QueueNode<T> prox;

    T getInfo() {
        return info;
    }
    private void setInfo(T info) {
        this.info = info;
    }

    QueueNode<T> getProx() {
        return prox;
    }
    void setProx(QueueNode<T> node) {
        prox = node;
    }

    QueueNode(T info) {
        setInfo(info);
    }
}