package Prova3;

public class LSEC<T extends Comparable<T>> {
    private LSECNode<T> inicio;
    private LSECNode<T> fim;
    private int qtd;

    private boolean isEmpty() {
        return qtd == 0;
    }

    public LSECNode<T> getInicio() {
        return inicio;
    }
    private void setInicio(LSECNode<T> node) {
        inicio = node;
    }

    public LSECNode<T> getFim() {
        return fim;
    }
    private void setFim(LSECNode<T> node) {
        fim = node;
    }

    public void concatenarLista(LSEC<T> lista) {
        if(lista.isEmpty()) {
            System.out.println("Não há elementos na lista a serem concatenados.");
        }
        else if(this.isEmpty()) {
            this.setInicio(lista.getInicio());
            this.setFim(lista.getFim());
            this.getFim().setProx(this.getInicio());
            this.qtd = lista.qtd;
            lista.setInicio(null);
            lista.setFim(null);
            lista.qtd = 0;
        }
        else {
            this.getFim().setProx(lista.getInicio());
            this.setFim(lista.getFim());
            this.getFim().setProx(this.getInicio());
            this.qtd += lista.qtd;
            lista.setInicio(null);
            lista.setFim(null);
            lista.qtd = 0;
        }
    }
}
