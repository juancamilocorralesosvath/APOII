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

    public TreeNode getMin(){
        return getMin(this.root);
    }

    private TreeNode getMin(TreeNode current){
        if(current.getLeft() == null){
            return current;
        }else {
            return getMin(current.getLeft());
        }
    }

    /*
    * vamos a hacer el metodo de eliminar:
    *
    * vamos a suponer que tenemos la referencia hacia el nodo padre,
    * aun no sabemos como vamos a hacer para tenerlo.
    * estoy en un nodo hoja
    * if(current.left == null && current.right == null){
    *   if(current == root){
    *   root = null;
    * }else if(parent.left == current){
    *   parent.left = null;
    * }else if(parent.right == current){
    *   parent.right = null;
    * }
    *
    *
    * }
    * */

    public void delete(String goal){
        delete(null, this.root, goal);
    }
    private void delete(TreeNode parent,TreeNode current, String goal){

        if(current == null){
            // el nodo no esta en el arbol

        }

        // cuando encontramos el nodo
        if(goal.equals(current.getKey())){
            // el nodo es hoja
            if(current.getLeft() == null && current.getRight() == null){
                // si es la raiz
                if(current == this.root){
                    this.root = null;
                }// si es hijo izquierdo
                else if(parent.getLeft() == current){
                    parent.setLeft(null);
                }// si es hijo derecho
                else if(parent.getRight() == current){
                    parent.setRight(null);
                }


            }// el nodo no es hoja, pero tiene unicamente un hijo izquierdo
            else if(current.getLeft() != null && current.getRight() == null){
                if(parent.getLeft() == current){
                    parent.setLeft(current.getLeft());
                } else if (parent.getRight() == current) {
                    parent.setRight(current.getLeft());
                }
            }// el nodo tiene unicamente un hijo derecho
            else if (current.getRight() != null && current.getLeft() == null) {
                if(parent.getRight() == current){
                    parent.setRight(current.getRight());
                }else if(parent.getLeft() == current){
                    parent.setLeft(current.getRight());
                }
            } // sucesor y predecesor: techo y piso
            // tiene ambos hijos
            else if (current.getLeft() != null && current.getRight() != null) {
                // vamos a obtener el sucesor-> el menor de los mayores:
                TreeNode successor = getMin(current.getRight());

                // vamos a reemplazar los atributos en lugar de las conexiones, puesto que es mas sencillo:
                current.setKey(successor.getKey());

                // vamos a eliminar el successor, de esa manera, actualizamos las conexiones de manera implicita:
                delete(current, current.getRight(), successor.getKey());
            }
        }// cuando aun no lo he econtrado y el valor es menor a mi actual (el nodo que busco debe estar hacia la izquierda)
        else if(goal.compareTo(current.getKey()) < 0){
            delete(current, current.getLeft(), goal);
        } else if (goal.compareTo(current.getKey()) > 0) {
            delete(current, current.getRight(), goal);
        }

    }

}

























