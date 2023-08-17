public class DoubleLinkedList {
    private Node head;
    private Node tail;

    // constructor
    public DoubleLinkedList(){}

    // getters & setters
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    //---------

    public void addNodeToHead(Node node){
        // when list is empty
        if (this.head == null){
            this.head = node;
            this.tail = node;
        } else {
            // el siguiente de mi nodo sera el que
            // hasta ahora era la cabeza. su anterior
            // es null, por lo que no tengo que hacer algo ahi
            node.setNext(this.head);
            // el previo de la anterior cabeza sera el nuevo nodo.
            this.head.setPrevious(node);
            this.head = node;

        }
    }

    public void addNodeToTail(Node node){
        // if list is empty
        if (this.head == null){
            this.head = node;
            this.tail = node;
        }else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
        }
    }

    // sobreescritura de metodos : metodo de activacion
    public String delete(String goal){
        return delete(goal, this.head);
    }

    // metodo recursivo
    // aqui ya no pasamos un previous como parametro
    // porque ya tenemos referencia al anterior
    // en la clase nodo
    private String delete(String goal, Node current){
        String str = "";

        // cas base: la lista esta vacia
        if(this.head == null){
            str = "list is empty";

        } // el elemento no existe

        else if (current == null) {
            str = "this element does not exist";
        } // estamos en el nodo a eliminar
        else if ( current.getKey().equals(goal) ) {
            // si se trata de la cabeza
            if(current.getKey().equals(this.head.getKey())){
                // actuializamos el estado de la lista
                this.head = current.getNext();
                // desconectamos el elemento
                current.setNext(null);
                this.head.setPrevious(null);

            }// si se trata de la cola
            else if (current.getKey().equals(tail.getKey())) {
                // actuializamos el estado de la lista
                this.tail = current.getPrevious();
                // desconectamos el elemento
                current.setPrevious(null);
                this.tail.setNext(null);
            }   // caso de un nodo intermedio
            else {
                // actualizamos el estado de la lista
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                // desconeccion del elemento
                current.setNext(null);
                current.setPrevious(null);
            }
            str = "the user has been deleted";
        } // caso recursivo
        else {
            delete(goal, current.getNext());
        }
        return str;
    }

}


















