package Prova5;

class TreeNode<T extends Comparable<T>> {
    private T info;
    private TreeNode<T> esq;
    private TreeNode<T> dir;

    T getInfo() {
        return info;
    }

    void setEsq(TreeNode<T> node) {
        esq = node;
    }
    TreeNode<T> getEsq() {
        return esq;
    }

    void setDir(TreeNode<T> node) {
        dir = node;
    }
    TreeNode<T> getDir() {
        return dir;
    }

    TreeNode(T obj) {
        info = obj;
    }
}
