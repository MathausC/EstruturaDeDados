package Lista7;

public class LDEC<T extends Comparable<T>> {
    private LDENode<T> inicio;
    private LDENode<T> fim;
    private int qtd;

    public LDENode<T> getInicio() {
        return inicio;
    }
    private void setInicio(LDENode<T> node) {
        inicio = node;
    }

    public LDENode<T> getFim() {
        return fim;
    }
    private void setFim(LDENode<T> node) {
        fim = node;
    }

    private boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public void inserirNoFinal(T obj) {
        LDENode<T> node = new LDENode<T>(obj);
        if(isEmpty()) {
            this.setInicio(node);
            this.setFim(node);
            this.getInicio().setProx(this.getFim());
            this.getInicio().setAnt(this.getFim());
            this.getFim().setProx(this.getInicio());
            this.getFim().setAnt(this.getInicio());
            this.qtd++;
        } else {
            this.getFim().setProx(node);
            node.setAnt(this.getFim());
            node.setProx(this.getInicio());
            this.getInicio().setAnt(node);
            this.setFim(node);
            qtd++;
        }
    }

    public void concatenar(LDEC lista) {
        if(lista.isEmpty()) {
            System.out.println("Não há itens a serem concatenados.");
        } else if(this.isEmpty()) {
            this.setInicio(lista.getInicio());
            this.setFim(lista.getFim());
            this.qtd = lista.qtd;
            lista.setInicio(null);
            lista.setFim(null);
            lista.qtd = 0;
        } else {
            this.getFim().setProx(lista.getInicio());
            lista.getInicio().setAnt(this.getFim());
            lista.getFim().setProx(this.getInicio());
            this.getInicio().setAnt(lista.getFim());
            this.setFim(lista.getFim());
            this.qtd += lista.qtd;
            lista.setInicio(null);
            lista.setFim(null);
            lista.qtd = 0;
        }
    }

    public LDEC<T> dividir() {
        if(this.isEmpty()) {
            System.out.println("Não há itens a serem divididos.");
            return null;
        } else if(this.qtd == 1) {
            System.out.println("Não há itens suficientes para a divisão.");
            return null;
        } else {
            LDEC<T> listaNova = new LDEC<T>();
            LDENode<T> aux = this.getInicio();
            int i;
            for(i = 0; i < this.qtd/2; i++) {
                aux = aux.getProx();
            }
            int novoQtd = this.qtd - i;

            listaNova.setInicio(aux);
            listaNova.setFim(this.getFim());
            listaNova.getInicio().setAnt(listaNova.getFim());
            listaNova.getFim().setAnt(listaNova.getInicio());
            listaNova.qtd = novoQtd;

            this.setFim(aux.getAnt());
            this.getFim().setProx(this.getInicio());
            this.getInicio().setAnt(this.getFim());
            this.qtd = i;

            return listaNova;
        }
    }
}
