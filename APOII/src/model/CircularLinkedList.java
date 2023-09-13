package model;
import exception.IsEmptyCircularLinkedListException;
import exception.NodeNotFoundException;
import exception.NodeWithSameKeyException;

public class CircularLinkedList {
    // ojo: con el poder de Dios implementar este
    // acercamiento. tener en cuenta que en una lista
    // doblemente enlazada circular, necesito solamente un puntero
    // a la cabeza, porque su anterior sera la cola. y el siguiente del ultimo sera la cabeza
    // sin tener necesariamente un puntero apuntando hacia la cola.
        private Node head;
        private Node tail;

        // todo
        // ojo ojo, revisar este metodo con el repositorio del profesor. de hecho,
        // revisar lo que hicimos la clase de hoy 13 septiembre 2023
        public void addNode(Node node){
            // list is empty
            if(this.head == null){
                this.head = node;
                this.tail = node;
                // Caso de la lista circular
                this.head.setPrevious(tail);
                this.tail.setNext(head);
            }
            // added to first position
            else {
                if( !(this.tail.getKey().equals(node.getKey()))){
                    // connect node
                    this.tail.setNext(node);
                    node.setPrevious(this.tail);
                    // update
                    this.tail = node;

                    // Caso de la lista circular
                    this.head.setPrevious(tail);
                    this.tail.setNext(head);
                }
                else {
                    throw new NodeWithSameKeyException("esta llave ya existe en la lista");
                }
            }
        }

        public String delete(String goal){
            String msj = "";
            try {
                msj = delete(goal, this.head);
            }catch (IsEmptyCircularLinkedListException exception){
                System.out.println("the exception has been caught");
                exception.printStackTrace();
            }catch (NodeNotFoundException ex){
                ex.printStackTrace();
            }
            return msj;
        }

        // método recursivo ---> suceptible de lanzar la excepción
        private String delete(String goal, Node current) throws IsEmptyCircularLinkedListException, NodeNotFoundException{
            String str;

            // Caso base: La lista esta vacia
            if(head == null ){
                throw new IsEmptyCircularLinkedListException("The circular Linked list is empty");
            }
            // Caso Base: El elemento no existe
            // en la lista circular el valor del current nunca será null
            else if(current == tail){
                throw new NodeNotFoundException("This element does not exist");
            }
            // Caso base: estamos en el nodo a eliminar
            else if(current.getKey().equals(goal)){
                // sub Caso Base (Caso borde)
                if(current == this.head){
                    this.head = current.getNext(); // Actualizar el estado de la lista

                    // desconección del elemento
                    current.setNext(null);
                    this.head.setPrevious(null);
                }
                // sub Caso Base (Caso borde)
                else if(current == tail){
                    this.tail = current.getPrevious(); // Actualizar el estado de la lista
                    // desconección del elemento
                    current.setPrevious(null);
                    tail.setNext(null);
                }
                // sub caso
                else {
                    // Actualizar el estado de la lista
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    // desconección del elemento
                    current.setNext(null);
                    current.setPrevious(null);
                }
                str = "The user has been deleted";
            }
            // Caso recursivo
            else {
                str = delete(goal,current.getNext());
            }
            return str;
        }
}
