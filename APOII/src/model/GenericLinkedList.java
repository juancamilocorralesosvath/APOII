package model;

public class GenericLinkedList<T> {
    private GenericNode<T> head;
    private GenericNode<T> tail;

    public GenericLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public GenericNode<T> getHead() {
        return head;
    }

    public void setHead(GenericNode<T> head) {
        this.head = head;
    }

    public GenericNode<T> getTail() {
        return tail;
    }

    public void setTail(GenericNode<T> tail) {
        this.tail = tail;
    }
    public void add(T item){
        GenericNode<T> helper = new GenericNode<>(item);
        add(helper);
    }
    // LIFO approach
    private void add(GenericNode<T> node){
        // when list is empty
        if (this.head == null){
            this.head = node;
            this.tail = node;
        } else {
            // el siguiente de mi nodo sera el que
            // hasta ahora era la cabeza.
            node.setNext(this.head);
            // el previo de la anterior cabeza sera el nuevo nodo.
            this.head = node;

        }
    }
    public String printList(){
        return printList(this.head);
    }
    private String printList(GenericNode<T> current){
        String str = "";
        // dos casos base: cuando la lista esta vacia
        // y cuando llego al final de la lista
        // list is empty
        if(this.head == null){
            str = "list is empty";
        } else if (current.getNext() == null) {
            str += "" + current.getItem();
        }else {
            str += current.getItem() + " " + printList(current.getNext());
        }
        return str;
    }
}
