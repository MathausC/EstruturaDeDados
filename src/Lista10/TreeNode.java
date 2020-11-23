package Lista10;

class TreeNode<T extends Comparable<T>> {
        private T info;
        private TreeNode<T> esq;
        private TreeNode<T> dir;

        T getInfo() {
            return info;
        }
        private void setInfo(T info) {
            this.info = info;
        }

        TreeNode<T> getEsq() {
            return esq;
        }
        void setEsq(TreeNode<T> ramo) {
            esq = ramo;
        }

        TreeNode<T> getDir() {
            return dir;
        }
        void setDir(TreeNode<T> ramo) {
            dir = ramo;
        }

        TreeNode(T info) {
            setInfo(info);
        }

        TreeNode<T> inserirRecursivo(TreeNode<T> ramo) {
            if(this.getInfo().compareTo(ramo.getInfo()) < 0) {

                if(esq == null) {
                    setEsq(ramo);
                } else {
                    setEsq(getEsq().inserirRecursivo(ramo));
                }

            } else if(this.getInfo().compareTo(ramo.getInfo()) > 0){

                if(dir == null) {
                    setDir(ramo);
                } else {
                    setDir(getDir().inserirRecursivo(ramo));
                }

            }
            return this;            
        }
}
