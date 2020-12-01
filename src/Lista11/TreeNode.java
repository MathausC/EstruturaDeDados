package Lista11;

class TreeNode<T extends Comparable<T>> {
    private T info;
    private TreeNode<T> esq;
    private TreeNode<T> dir;

    T getInfo(){
        return info;
    }
    private void setInfo(T info) {
        this.info = info;
    }

    TreeNode<T> getEsq() {
        return esq;
    }
    void setEsq(TreeNode<T> node) {
        esq = node;
    }

    TreeNode<T> getDir() {
        return dir;
    }
    void setDir(TreeNode<T> node) {
        dir = node;
    }

    TreeNode(T info) {
        setInfo(info);
    }
}