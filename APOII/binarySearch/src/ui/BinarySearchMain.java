package ui;

import model.BinarySearch;

import java.util.ArrayList;
public class BinarySearchMain {

    /*
    * OJO:
    * Para poder hacer busqueda binaria el arreglo debe estar ordenado (podemos usar los metodos que hemos visto en clase)
    * */
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-2);
        arr.add(0);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        arr.add(9);

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(arr, 5));

        System.out.println("gracias Dios si esto funciona: ");
        System.out.println(binarySearch.binaryRecursion(arr, 5));
        System.out.println("Gracias Dios!");

    }
}
