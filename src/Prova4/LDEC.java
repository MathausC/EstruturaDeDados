package Prova4;

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
    private void setFim(LDENode<T> node ) {
        fim = node;
    }

    private boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public int getQtd() {
        return qtd;
    }

    public void inserir(T obj) {
        LDENode<T> node = new LDENode<T>(obj);
        if(isEmpty()) {
            this.setInicio(node);
            this.setFim(node);
            this.getFim().setProx(this.getInicio());
            this.getInicio().setProx(this.getFim());
            this.getInicio().setAnt(this.getFim());
            this.getFim().setAnt(this.getInicio());
            qtd++;
            System.out.println("Item inserido.");
        } else {
            if(this.getInicio().getInfo().compareTo(obj) > 0) {
                node.setProx(this.getInicio());
                node.setAnt(this.getFim());
                this.getFim().setProx(node);
                this.getInicio().setAnt(node);
                this.setInicio(node);
                qtd++;
                System.out.println("Item inserido.");
            } else if(this.getFim().getInfo().compareTo(obj) < 0) {
                node.setAnt(this.getFim());
                node.setProx(this.getInicio());
                this.getFim().setProx(node);
                this.getInicio().setAnt(node);
                this.setFim(node);
                qtd++;
                System.out.println("Item inserido.");
            } else {
                LDENode<T> aux = this.getInicio();
                while (true){
                    if(aux.getInfo().compareTo(obj) > 0) {
                        node.setProx(aux);
                        node.setAnt(aux.getAnt());
                        aux.getAnt().setProx(node);
                        aux.setAnt(node);
                        qtd++;
                        System.out.println("Item inserido.");
                        break;
                    } else if(aux.getInfo().compareTo(obj) == 0) {
                        System.out.println("Item já pertence a lista.");
                        break;
                    } else {
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    public void remover(T obj) {
        if(isEmpty()) {
            System.out.println("Não há itens a serem removidos.");
        } else if(this.getInicio().getInfo().compareTo(obj) > 0 || this.getFim().getInfo().compareTo(obj) < 0) {
                System.out.println("O item não pertence a lista.");
        } else if(this.getInicio().getInfo().compareTo(obj) == 0) {
            removeNode(this.getInicio());
            this.setInicio(this.getInicio().getProx());
            System.out.println("Item removido.");
        } else if(this.getFim().getInfo().compareTo(obj) == 0) {
            removeNode(this.getFim());
            this.setFim(this.getFim().getAnt());
            System.out.println("Item removido.");
        } else {
            boolean find = false;
            boolean fim = false;
            LDENode<T> aux = this.getInicio().getProx();
            while(true) {
                if(aux.getInfo().compareTo(this.getFim().getInfo()) == 0) {
                    fim = true;
                }

                if(aux.getInfo().compareTo(obj) == 0) {
                    removeNode(aux);
                    find = true;
                    System.out.println("Item removido.");
                    break;
                } else if(aux.getInfo().compareTo(obj) > 0) {
                    break;
                } else {
                    aux = aux.getProx();
                }

                if(fim) {
                    break;
                }
            }
            if(!find) {
                System.out.println("O item não pertence a lista.");
            }
        }
    }

    private void removeNode(LDENode<T> node) {
        node.getProx().setAnt(node.getAnt());
        node.getAnt().setProx(node.getProx());
        qtd--;
    }

    public void exibirItem(T obj) {
        if(isEmpty()) {
            System.out.println("Não há itens na lista.");
        } else if(this.getInicio().getInfo().compareTo(obj) > 0 || this.getFim().getInfo().compareTo(obj) > 0) {
            System.out.println("O item não pertence a lista.");
        } else {
            boolean find = false;
            boolean fim = false;
            LDENode<T> aux = this.getInicio();
            while(true) {
                if(aux.getInfo().compareTo(this.getFim().getInfo()) == 0) {
                    fim = true;
                }

                if(aux.getInfo().compareTo(obj) == 0) {
                    System.out.println(aux.getInfo());
                    find = true;
                    break;
                } else if(aux.getInfo().compareTo(obj) > 0){
                    break;
                }
                else {
                    aux = aux.getProx();
                }

                if(fim) {
                    break;
                }
            }
            if(!find) {
                System.out.println("O item não pertence a lista.");
            }
        }
    }

    public T buscarObjeto(T obj) {
        if(isEmpty()) {
            return null;
        } else if(this.getInicio().getInfo().compareTo(obj) > 0 || this.getFim().getInfo().compareTo(obj) < 0) {
            return null;
        } else {
            LDENode<T> aux = this.getInicio();
            boolean fim = false;
            while(true) {
                if(aux.getInfo().compareTo(this.getFim().getInfo()) == 0) {
                    fim = true;
                }

                if(aux.getInfo().compareTo(obj) == 0) {
                    return aux.getInfo();
                } else if(aux.getInfo().compareTo(obj) > 0) {
                    return null;
                }
                else {
                    aux = aux.getProx();
                }

                if(fim) {
                    return null;
                }
            }
        }
    }

    public void exibirItens() {
        if(isEmpty()) {
            System.out.println("Não há itens a serem exibidos.");
        } else {
            boolean end = false;
            LDENode<T> aux = this.getInicio();
            while(true) {
                if(aux.getInfo().compareTo(this.getFim().getInfo()) == 0) {
                    end = true;
                }
                System.out.println(aux.getInfo());
                aux = aux.getProx();
                if(end) {
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        String mensagem = "";
        if(!isEmpty()) {
            LDENode<T> aux = this.getInicio();
            for(int i = 0; i < qtd; i++){
                mensagem += aux.getInfo().toString() + "\n";
                aux = aux.getProx();
            }
        }
        return mensagem;
    }
}
