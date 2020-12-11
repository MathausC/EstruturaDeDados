package Prova5;

import javax.xml.transform.Source;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> raiz;

    public boolean isEmpty() {
        return raiz == null;
    }

    public void inserir(T obj) {
        TreeNode<T> node = new TreeNode<T>(obj);
        if(isEmpty()) {
            raiz = node;
        } else {
            raiz = inserirNode(raiz, node);
        }
    }

    private TreeNode<T> inserirNode(TreeNode<T> node, TreeNode<T> novoNode){
        if(node.getInfo().compareTo(novoNode.getInfo()) > 0) {
            if(node.getEsq() == null) {
                node.setEsq(novoNode);
            } else {
                node.setEsq(inserirNode(node.getEsq(),novoNode));
            }
        } else if(node.getInfo().compareTo(novoNode.getInfo()) <= 0) {
            if(node.getDir() == null) {
                node.setDir(novoNode);
            } else {
                node.setDir(inserirNode(node.getDir(),novoNode));
            }
        }
        return node;
    }


    public int buscaValor(T obj) {        
        if(isEmpty() || obj == null) {
            System.out.println("1");
            return 0;
        } else {
            System.out.println("2");
            return buscaValorRecursivo(raiz, obj, 0);
        }
    }

    private int buscaValorRecursivo(TreeNode<T> node, T obj, int i) {
        if(node.getEsq() != null) {
            i = buscaValorRecursivo(node.getEsq(), obj, i);
        }
        if(node.getInfo().compareTo(obj) == 0) {
            i++;
        }
        if(node.getDir() != null) {
            i = buscaValorRecursivo(node.getDir(), obj, i);
        }
        return i;
    }

    public TreeNode<T> buscaMenorNode() {
        if(isEmpty()) {
            return null;
        } else {
            return buscaMenorNodeRecursivo(raiz);
        }
    }

    private TreeNode<T> buscaMenorNodeRecursivo(TreeNode<T> node) {
        if(node.getEsq() != null) {
            return buscaMenorNodeRecursivo(node.getEsq());
        } else {
            return node;
        }
    }  

}
