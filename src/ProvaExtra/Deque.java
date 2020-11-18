//DEQUE/LDE

package ProvaExtra;

public class Deque<T> {
    private DequeNode<T> inicio;
    private DequeNode<T> fim;
    private int qtd;

    DequeNode<T> getInicio() {
        return inicio;
    }
    private void setInicio(DequeNode<T> node) {
        inicio = node;
    }

    DequeNode<T> getFim() {
        return fim;
    }
    private void setFim(DequeNode<T> node) {
        fim = node;
    }

    public boolean isEmpty() {
        return qtd == 0;
    }

    public boolean isFull() {
        return false;
    }

    public void push(T obj) {
        DequeNode<T> node = new DequeNode<T>(obj); 
        if(isEmpty()) {
            this.setInicio(node);
            this.setFim(node);
            qtd++;
        } else {
            node.setProx(this.getInicio());
            this.getInicio().setAnt(node);
            this.setInicio(node);
            qtd++;
        }
    }

    public T pop() {
        if(isEmpty()) {
            return null;
        }

        T var = this.getInicio().getInfo();
        if(qtd == 1) {
            this.setInicio(null);
            this.setFim(null);
            qtd = 0;
        } else {
            this.setInicio(this.getInicio().getProx());
            this.getInicio().setAnt(null);
            qtd--;
        }
        return var;
    }

    public void inject(T obj) {
        DequeNode<T> node = new DequeNode<T>(obj);
        if(isEmpty()) {
            this.setInicio(node);
            this.setFim(node);
            qtd++;
        } else {
            this.getFim().setProx(node);
            node.setAnt(this.getFim());
            this.setFim(node);
            qtd++;
        }
    }

    public T eject() {
        if(isEmpty()) {
            return null;
        }

        T var = this.getFim().getInfo();
        if(qtd == 1) {
            this.setInicio(null);
            this.setFim(null);
            qtd = 0;
        } else {
            this.setFim(this.getFim().getAnt());
            this.getFim().setProx(null);
            qtd--;
        }
        return var;
    }
}
