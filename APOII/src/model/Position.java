public class Position {

    // mostrarle al profesor el metodo.
    public int positionInArray(int[] array, int number, int initializer){
        // mis casos bases se producen cuando
        // 1) encuentro el numero que estoy buscando dentro del arreglo
        // 2) o bien cuando ese numero no se encuentra y ya busque en todas
        // las posiciones en el arreglo
        // 1) int n = 0;
        // array[n] == number;
        // 2) n > array.length


        int result = -1;
        // comentarle al profesor! no me estaba quedando bien y la verdad
        // pude llegar a esta forma de pura chepa
        if(array[initializer] == number){
            // System.out.println("que esta pasando aqui?" + initializer);
            result = initializer;
        } else {
            System.out.println("inicializador: " + initializer);
            result = positionInArray(array, number, ++initializer);
        }
        return result;
    }

    public static void main(String[] args){
        int[] array = {1, 15, 8, 19, 21, 40, -4, 10};

        Position p = new Position();

        int result = p.positionInArray(array, 19, 0);

        System.out.println("Index: " + result);
    }
}
