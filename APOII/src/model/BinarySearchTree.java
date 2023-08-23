package model;

public class BinarySearchTree {
    /*
        vamos a hacerlo siempre de manera ordenada
        el primer nodo que agrego sera mi raiz.
        al agregar cualquier otro nodo, voy a preguntar si es mayor o menor que mi raiz,
        si es menor va hacia la izquierda, si es mayor va hacia la derecha.
        ALTURA ..> todos los niveles que tiene el arbol
        PROFUNDIDAD--> podemos contar desde la raiz o desde los hijos de la raiz.




    if(nodoQueQuieroAgregar > miRaiz){
        if(miRaiz.right == null){
            miRaiz.right = nodoQueQuieroAgregar;
        }else{
            addNodeToTree(nodoQueQuieroAgregar, miRaiz.right)
        }
    }else {
        if(miRaiz.left == null){
            miRaiz.left = nodoQueQuieroAgregar;
        } else{
            addNodeToTree(nodoQueQuieroAgregar, miRaiz.left)
        }
    }



  public void addNodeToTree(Node nodoQueQuieroAgregar, current) {

      if(nodoQueQuieroAgregar > current){
        if(current.right == null){
            current.right = nodoQueQuieroAgregar;
        }else{
            addNodeToTree(nodoQueQuieroAgregar, current.right)
        }
    }else {
        if(current.left == null){
            current.left = nodoQueQuieroAgregar;
        } else{
            addNodeToTree(nodoQueQuieroAgregar, current.left)
        }
    }
    }

     */
}
