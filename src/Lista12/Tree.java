package Lista12;

import Lista8.Stack;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> raiz;

    public TreeNode<T> getRaiz() {
        return raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }
    
    public boolean isFull() {
        return false;
    }

    public int contaNodeRecursivo () {
        return contaNode(raiz, 0);
    }

    private int contaNode(TreeNode<T> node, int i) {
        i++;
        if(node.getEsquerda() != null) {
            i = contaNode(node.getEsquerda(), i);
        }
        if(node.getDireito() != null) {
            i = contaNode(node.getDireito(), i);
        }
        return i;
    }

    public int contaNodeNaoRecursivo() {
        int i = 0;
        TreeNode<T> aux = raiz;
        Stack<TreeNode<T>> pilha = new Stack<TreeNode<T>>();
        while(true) {
            if(aux != null) {
                i++;
                pilha.push(aux);
                aux = aux.getEsquerda();
            } else {
                if(pilha.isEmpty()) {
                    return i;
                }
                aux = pilha.pop().getDireito();                
            }
        }
    }

    public int contaNumeroDeFolhas() {
        if(isEmpty())  {
            return 0;
        }
        return contaFolhasRecursivo(raiz, 0);
    }

    private int contaFolhasRecursivo(TreeNode<T> node, int i) {
        if(node.getEsquerda() == null && node.getDireito() == null) {
            i++;
        } else {
            if(node.getEsquerda() != null) {
                i = contaFolhasRecursivo(node.getEsquerda(), i);
            }
            if(node.getDireito() != null) {
                i = contaFolhasRecursivo(node.getDireito(), i);
            }
        }
        return i;
    }

    public int contaFolhasNaoRecursivo() {
        TreeNode<T> aux = raiz;
        int i = 0;
        Stack<TreeNode<T>> pilha = new Stack<TreeNode<T>>();
        while(true) {
            if(aux.getEsquerda() != null) {
                pilha.push(aux);
                aux = aux.getEsquerda();
            } else if(aux.getDireito() != null) {
                aux = aux.getDireito();
            } else {
                i++;
                if(!pilha.isEmpty()) {
                    aux = pilha.pop().getDireito();
                    while(aux == null && !pilha.isEmpty()) {
                        aux = pilha.pop().getDireito();
                    }
                    if(aux == null) {
                        return i;
                    }
                } else {
                    return i;
                }
            }
        }
    }

    public int conaNaoTerminais() {
        if(isEmpty()) {
            return 0;
        } else {
            return contaNaoTerminaisRecursivo(raiz, 0);
        }
    }

    private int contaNaoTerminaisRecursivo(TreeNode<T> node, int i) {        
        if(node.getDireito() != null || node.getEsquerda() != null) {        
            i++;
            if(node.getEsquerda() !=  null) {                
                i = contaNaoTerminaisRecursivo(node.getEsquerda(), i);
            }
            if(node.getDireito() != null) {
                i = contaNaoTerminaisRecursivo(node.getDireito(), i);                
            }
        }
        return i;
    }

    public int contaNaoTerminaisNaoRecursivo() {
        TreeNode<T> aux = raiz;
        Stack<TreeNode<T>> pilha = new Stack<TreeNode<T>>();
        int i = 0;
        while(true) {
            if(aux.getDireito() != null || aux.getEsquerda() != null) {
                i++;
            }
            if(aux.getEsquerda() != null)  {
                pilha.push(aux);
                aux = aux.getEsquerda();
            } else if(aux.getDireito() != null) {
                aux = aux.getDireito();
            } else {                
                if(!pilha.isEmpty()) {
                    aux = pilha.pop().getDireito();
                    while(aux == null && !pilha.isEmpty()) {
                        aux = pilha.pop().getDireito();
                    }
                    if(aux == null) {
                        return i;
                    }
                } else {
                    return i;
                }
            }
            
        }
    }

    public int alturaDaArvore() {
        if(isEmpty()) {
            return 0;
        } else {
            return alturaDaArvoreRecursiva(raiz, 0);
        }
    }

    private int alturaDaArvoreRecursiva(TreeNode<T> node, int i) {
        return 0;

    }
}