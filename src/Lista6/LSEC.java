package Lista6;

public class LSEC<T extends Comparable<T>> {
    private LSENode<T> inicio;
    private LSENode<T> fim;
    private int qtd;

    public LSENode<T> getInicio() {
        return inicio;
    }
    private void setInicio(LSENode<T> node) {
        inicio = node;
    }

    public LSENode<T> getFim() {
        return fim;
    }
    private void setFim(LSENode<T> node) {
        fim = node;
    }

    private boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public void inserir(T obj) {
        LSENode<T> node = new LSENode<T>(obj);
        if(isEmpty()) {
            this.setInicio(node);
            this.setFim(node);
            this.getInicio().setProx(this.getFim());
            this.getFim().setProx(this.getInicio());
            qtd++;
        }
        else {
            if(!existeNaLista(obj)){
                this.getFim().setProx(node);
                node.setProx(this.getInicio());
                this.setFim(node);
                qtd++;
            }
            else {
                System.out.println("Item já existe na lista");
            }
        }
    }

    private boolean existeNaLista(T obj) {
        boolean flag = false;
        LSENode<T> aux = this.getInicio();
        while(true) {
            if(aux.getInfo().compareTo(obj) == 0) {
                return true;
            }
            aux = aux.getProx();
            if(aux.getProx() == this.getInicio()) {
                flag = true;
            }
            if(aux != this.getFim() && flag) {
                return false;
            }
        }
    }

    public void exibirItems() {
        if(isEmpty()) {
            System.out.println("Não a itens a serem exibidos.");
        }
        else if(qtd == 1){
            System.out.println(this.getInicio().getInfo());
        }
        else {
            LSENode<T> aux = this.getInicio();
            boolean flag = false;
            while(true) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
                if(aux.getProx() == this.getInicio()){
                    flag = true;
                }
                if(aux != this.getFim() && flag) {
                    break;
                }
            }
        }
    }

    public T buscaItem(T obj) {
        if(isEmpty()) {
            return null;
        }
        else {
            LSENode<T> aux = this.getInicio();
            boolean flag = false;
            while(true) {
                if(aux.getInfo().compareTo(obj) == 0) {
                    return aux.getInfo();
                }
                aux = aux.getProx();
                if(aux.getProx() == this.getInicio()) {
                    flag = true;
                }
                if(aux != this.getFim() && flag) {
                    return null;
                }
            }
        }
    }

    public void remover(T obj) {
        if(isEmpty()) {
            System.out.println("Não há itens a serem removidos.");
        }
        else if(qtd == 1) {
            if(this.getInicio().getInfo().compareTo(obj) == 0) {
                this.setInicio(null);
                this.setFim(null);
                qtd = 0;
            }
        }
        else {

            if(this.getInicio().getInfo().compareTo(obj) == 0) {
                this.getFim().setProx(this.getInicio().getProx());
                this.setInicio(this.getFim().getProx());
                qtd--;
            }
            else if(this.getFim().getInfo().compareTo(obj) == 0) {
                LSENode<T> aux = this.getInicio();
                while(true) {
                    if(aux.getProx() == this.getFim()) {
                        aux.setProx(this.getFim().getProx());
                        this.setFim(aux);
                        qtd--;
                        return;
                    }
                }
            }
            else {
                LSENode<T> ant = inicio;
                LSENode<T> aux = ant.getProx();
                while(true) {
                    if(aux.getInfo().compareTo(obj) == 0) {
                        ant.setProx(aux.getProx());
                        break;
                    }
                    if(aux.getProx() == inicio) {
                        System.out.println("Item não foi encontrado na lista.");
                        break;
                    }
                    ant = aux;
                    aux = aux.getProx();
                }
            }
        }
    }

    public void exibirItem(T obj) {
        if(isEmpty()) {
            System.out.println("Nenhum item a exibir.");
        }
        else {
            if(qtd == 1) {
                if(this.getInicio().getInfo().compareTo(obj) == 0) {
                    System.out.println(this.getInicio().getInfo());
                }
                else {
                    System.out.println("Intem não encontrado.");
                }
            }
            else {
                boolean flag = false;
                LSENode<T> aux = this.getInicio();
                while(true) {
                    if(aux.getInfo().compareTo(obj) == 0) {
                        System.out.println(aux.getInfo());
                        return;
                    }
                    aux = aux.getProx();
                    if(aux.getProx() == this.getInicio()) {
                        flag = true;
                    }
                    if(aux != this.getFim() && flag) {
                        System.out.println("Item não encontado.");
                        return;
                    }
                }
            }
        }
    }
}
