//DEQUENODE/LDENODE

package ProvaExtra;

class DequeNode<T> {
    private T info;
    private DequeNode<T> prox;
    private DequeNode<T> ant;

    T getInfo() {
        return info;
    }
    private void setInfo(T obj) {
        info = obj;
    }

    DequeNode<T> getProx() {
        return prox;
    }
    void setProx(DequeNode<T> node) {
        prox = node;
    }

    DequeNode<T> getAnt() {
        return ant;
    }
    void setAnt(DequeNode<T> node) {
        ant = node;
    }

    DequeNode(T obj) {
        setInfo(obj);
    }
}
