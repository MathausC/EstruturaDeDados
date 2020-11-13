package Lista9;

public class Queue<T> {
    private QueueNode<T> inicio;
    private QueueNode<T> fim;
    private int qtd;

    QueueNode<T> getInicio() {
        return inicio;
    }
    private void setInicio(QueueNode<T> node) {
        inicio = node;
    }

    QueueNode<T> getFim() {
        return fim;
    }
    private void setFim(QueueNode<T> node) {
        fim = node;
    }

    public boolean isEmpty() {
        return this.getInicio() == null && this.getFim() ==  null;
    }

    public boolean isFull() {
        return false;
    }

    public void enQueue(T obj) {
        QueueNode<T> node = new QueueNode<T>(obj);
        if(!this.isFull()){
            if(this.isEmpty()) {
                this.setInicio(node);
                this.setFim(node);
                this.getInicio().setProx(this.getFim());
                qtd++;
            } else {
                this.getFim().setProx(node);
                this.setFim(node);
                qtd++;
            }
        } else {
            System.out.println("Fila cheia");
        }
    }

    public T deQueue() {
        if(this.isEmpty()) {
            return null;
        }        
        T item = this.getInicio().getInfo();
        if(qtd == 1) {
            this.setInicio(null);
            this.setFim(null);
        } else {
            this.setInicio(this.getInicio().getProx());
        }
        qtd--;
        return item;
    }
}