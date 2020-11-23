package Lista10;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> raiz;

    public TreeNode<T> getRaiz() {
        return raiz;
    }
    private void setRaiz(TreeNode<T> ramo) {
        raiz = ramo;
    }
    
    public boolean isEmpty() {
        return raiz == null;
    }
    public boolean isFull() {
        return false;
    }

    public void inserirRecursivo(T obj) {
        TreeNode<T> ramo = new TreeNode<T>(obj);
        if(isEmpty()) {
            setRaiz(ramo);
        } else {
            setRaiz(getRaiz().inserirRecursivo(ramo));
        }
    }

    public void inserirNaoRecursivo(T obj) {
        TreeNode<T> ramo = new TreeNode<T>(obj);
        if(isEmpty()) {
            setRaiz(ramo);
        } else  {
            TreeNode<T> aux = raiz;
            while(true) {
                if(aux.getInfo().compareTo(ramo.getInfo()) < 0) {
                    if(aux.getEsq() != null) {
                        aux = aux.getEsq();
                    } else {
                        aux.setEsq(ramo);
                        break;
                    }
                } else if(aux.getInfo().compareTo(ramo.getInfo()) > 0) {
                    if(aux.getDir() != null) {
                        aux = aux.getDir();
                    } else {
                        aux.setDir(ramo);
                        break;
                    }
                } else {
                    System.out.println("Valor já existe.");
                    break;
                }
            }
        }
    }
}
