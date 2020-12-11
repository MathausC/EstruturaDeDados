package Lista12;

class TreeNode<T extends Comparable<T>> {
    
    private T info;
    private TreeNode<T> esquerda;
    private TreeNode<T> direita;

    T getInfo() {
        return info;
    }

    TreeNode<T> getDireito() {
        return direita;
    }
    void setDireita(TreeNode<T> node) {
        direita = node;
    }

    TreeNode<T> getEsquerda() {
        return esquerda;
    }
    void setEsquerda(TreeNode<T> node) {
        esquerda = node;
    }
    
    TreeNode(T obj) {
        info = obj;
    }
}
