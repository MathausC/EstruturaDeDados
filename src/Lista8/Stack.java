package Lista8;

public class Stack<T extends Comparable<T>>{
    private StackNode<T> top;
    private int qtd;

    public StackNode<T> getTop() {
        return top;
    }
    private void setTop(StackNode<T> node) {
        top = node;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return false;
    }

    public void push(T obj) {
        StackNode<T> node = new StackNode<T>(obj);
        if (!this.isEmpty()) {
            node.setProx(this.getTop());
        }
        this.setTop(node);
        qtd++;
    }

    public T pop() {
        if (!this.isEmpty()) {
            T val = this.getTop().getInfo();
            this.setTop(this.getTop().getProx());
            return val;
        }
        return null;
    }

    public T top() {
        if(!this.isEmpty()) {
            return this.getTop().getInfo();
        }
        return null;
    }

    public int size() {
        return this.qtd;
    }
}
