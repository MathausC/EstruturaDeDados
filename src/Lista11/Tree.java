package Lista11;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> raiz;

    public TreeNode<T> getRaiz() {
        return raiz;
    }
    private void setRaiz(TreeNode<T> node) {
        raiz = node;
    }

    public boolean isEmpty() {
        return raiz == null;
    }
    public boolean isFull() {
        return false;
    }

    public void inserir(T obj) {
        TreeNode<T> node = new TreeNode<T>(obj);
        if(isEmpty()) {
            setRaiz(node);
        } else {
            setRaiz(inserirNode(raiz, node));
        }
    }

    private TreeNode<T> inserirNode(TreeNode<T> node, TreeNode<T> novoNode){
        if(node.getInfo().compareTo(novoNode.getInfo()) > 0) {
            if(node.getEsq() == null) {
                node.setEsq(novoNode);
            } else {
                node.setEsq(inserirNode(node.getEsq(),novoNode));
            }
        } else if(node.getInfo().compareTo(novoNode.getInfo()) < 0) {
            if(node.getDir() == null) {
                node.setDir(novoNode);
            } else {
                node.setDir(inserirNode(node.getDir(),novoNode));
            }
        }
        return node;
    }

    public void exibirTodos() {
        if(isEmpty()){
            System.out.println("Não há itens a serem exibidos.");
        } else {
            passeio(raiz);
        }
    }

    private void passeio(TreeNode<T> node) {
        if(node.getEsq() != null) {
            passeio(node.getEsq());
        }
        System.out.println(node.getInfo());
        if(node.getDir() != null) {
            passeio(node.getDir());
        }
    }

    public T buscar(T obj) {
        if(isEmpty()) {
            return null;
        }
        return passeioBusca(raiz, obj);
    }

    private T passeioBusca(TreeNode<T> node, T obj){
        if(node.getInfo().compareTo(obj) < 0) {
            return passeioBusca(node.getDir(), obj);
        } else if(node.getInfo().compareTo(obj) > 0) {
            return passeioBusca(node.getEsq(),obj);
        } else {
            return node.getInfo();
        }
    }
}
