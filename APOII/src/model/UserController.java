package model;

public class UserController {
    private User head;

    private User tail;

    public UserController(){}

    public User getHead() {
        return head;
    }

    public User getTail() {
        return tail;
    }

    public void addFirstUser(User user){
        // when list is empty
        if(this.head == null){
            this.head = user;
            this.tail = user;
        }// already has users. add to the beginning.
        else{
            user.setNext(this.head);
            this.head = user;
        }
    }

    public void addLastUser(User user){

        if(this.head == null){
            this.head = user;
            this.tail = user;
        }else {
            this.tail.setNext(user);
            this.tail = user;
        }
    }
    public String print(){
        return print(this.head);
    }
    private String print(User current){
        String str = "";
        if(this.head == null){
            str = "list is empty";
        } else if (current.getNext() == null) {
            str += " " + current.getId();
        }else {
           str += current.getId() + " " + print(current.getNext());
        }
        return str;
    }

    // sobreescritura de metodos : metodo de activacion
    public String delete(int goal){
        return delete(goal, this.head, null);
    }

    // metodo recursivo
    private String delete(int goal, User current, User previous){
        String str = "";

        // cas base: la lista esta vacia
        if(head == null){
            str = "list is empty";

        } // el elemento no existe

        else if (current == null) {
            str = "this element does not exist";
        } // estamos en el nodo a eliminar
        else if ( current.getId() == goal ) {
            // sub caso base (caso borde)+
            if(current.getId() == this.head.getId()){
                // actuializamos el estado de la lista
                this.head = current.getNext();
                // desconectamos el elemento
                current.setNext(null);
            } else if (current.getId() == tail.getId()) {
                // sub caso base (caso borde)+
                // actuializamos el estado de la lista
                this.tail = previous;
                // desconectamos el elemento
                previous.setNext(null);
            } else {
                // caso de un nodo intermedio
                previous.setNext(current.getNext());
                current.setNext(null);
            }
        } // caso recursivo
        else {
            delete(goal, current.getNext(), current);
        }
        return str;
    }
}























