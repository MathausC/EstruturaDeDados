package Prova4;

class LDENode<T extends Comparable<T>> {
    private LDENode<T> ant;
    private LDENode<T> prox;
    private T info;

    LDENode<T> getAnt() {
        return ant;
    }
    void setAnt(LDENode node) {
        ant = node;
    }

    LDENode<T> getProx() {
        return prox;
    }
    void setProx(LDENode<T> node) {
        prox = node;
    }

    T getInfo() {
        return info;
    }
    private void setInfo(T info) {
        this.info = info;
    }

    LDENode(T info) {
        this.setInfo(info);
    }
}
