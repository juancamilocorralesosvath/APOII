package model;

import exception.EmptyBSTException;

public class BST {

    private TreeNode root;

    // trigger method
    public void add(Integer key){
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
    public String inOrder() {
        String result = "";
        try{
            result = inOrder(this.root);
        }catch (EmptyBSTException e){
            System.out.println("exception has been catched");
        }

        return result;
    }

    // este metodo inorder lo podemos usar como base
    // para armar un arreglo ordenado y luego
    // hacer un arbol balanceado con el metodo add in group. de la manera como esta en el comentario:
    private String inOrder(TreeNode current) throws EmptyBSTException{
        if(this.root == null){
            throw new EmptyBSTException("tree is empty");
        }else if(current == null){
            return " null ";
        }else{
            //metodo para generar un arreglo ordenado:
            // llamado por la izquierda
            // agregar al arreglo
            // llamado por la derecha
            // return array
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

    public void delete(Integer goal){
        try{
            return delete(null, this.root, goal);
        }catch (EmptyBSTException e){

        }

    }
    // el metodo es suceptible de lanzar la excepcion.
    private void delete(TreeNode parent,TreeNode current, Integer goal) {

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

    /*
    * ojo: con el poder de Dios preguntarle al profesor acerca del metodo de calcular el ancho,
    * mi idea era esta:
    *  public String inOrder(){
        if(root == null){
            return "tree is empty";
        }else {
            return inOrder(this.root);
        }
    }

    private String inOrder(TreeNode current){
        if(current == null){
            return "";
        }else{
            return inOrder(current.getLeft()) + " " + current.getKey() + " " + inOrder(current.getRight());
        }
    }
    public int getWidth(){
        String mensaje = "Los nodos hoja son los siguientes: ";
        int contador = 0;
        return getWidth(this.root, contador, mensaje);
    }
    private int getWidth(TreeNode current, int contador, String cadena){
        // necesito implementar la suma izquierda y la suma derecha
        // de cada uno de los nodos, pero no se como implementar esto.
        return 1;
    }
    private int sumaIzquierda(TreeNode current, int contador){
        if(current.getLeft() == null && current.getRight()==null){
            contador++;
        }
        if (current == null){
            return contador;
        } else{
            return sumaIzquierda(current.getLeft(), contador);
        }
    }

    private int sumaDerecha(TreeNode current, int contador){
        if(current.getLeft() == null && current.getRight()==null){
            contador++;
        }
        if (current == null){
            return contador;
        } else{
            return sumaDerecha(current.getRight(), contador);
        }
    }
    * */

    /*
    * el metodo addingroup toma un arreglo
    * y a partir de el genera un arbol balanceado.
    * ojo: el arreglo debe estar ordenado de menor a mayor.
    * */
    public void addInGroup(Integer[] arr){
        int start = 0;
        int end = arr.length-1;

    }

    private void addInGroup(Integer[] arr, int start, int end){
        if(start <= end){
            int mid = (start + end) / 2;
            add(arr[mid]);

            // left
            addInGroup(arr, start, mid-1);

            // right
            addInGroup(arr, mid+1, end);
        }
    }

}

























