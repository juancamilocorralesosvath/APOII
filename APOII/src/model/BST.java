package model;

public class BST {

    private TreeNode root;

    // trigger method
    public void add(String key, TreeNode current){
        TreeNode node = new TreeNode(key);
        if(root == null){
            root = node;
        } else{
            add(node, root);
        }
    }

    private void add(TreeNode node, TreeNode current){
        // si me surgen dudas en cuanto a esta linea,
        // buscar en google la documentacion
        // de oracle en cuanto al metodo comparable->compareTo
        // si el valor que quiero agregar es menor
        if(node.getKey().compareTo(current.getKey()) < 0){
            if(current.getLeft() == null){
                current.setLeft(node);
            }else {
                add(node, current.getLeft());
            }
        } // si el valor que quiero agregar es mayor.
        else if (node.getKey().compareTo(current.getKey()) > 0) {
            if(current.getRight() == null){
                current.setRight(node);
            } else{
                add(node, current.getRight());
            }
        } else{
            // caso en el que los valores de los nodos son iguales
        }
    }

    /*
    *
    * Ojo manito:
    * el metodo inorder, lo que significa es que voy a recorrer el arbol
    * o imprimirlo desde el menor valor hasta el mayor valor.
    * */
    public String inOrder(){
        if(root == null){
            return "tree is empty";
        }else {
            return inOrder(this.root);
        }
    }

    private String inOrder(TreeNode current){
        if(current == null){
            return " null ";
        }else{ // darle un repaso a esto... por favor.
            return inOrder(current.getLeft()) + " " + current.getKey() + " " + inOrder(current.getRight());
        }
    }

    public String getMin(){
        return getMin(this.root);
    }

    private String getMin(TreeNode current){
        if(current.getLeft() == null){
            return current.getKey();
        }else {
            return getMin(current.getLeft());
        }
    }
}
