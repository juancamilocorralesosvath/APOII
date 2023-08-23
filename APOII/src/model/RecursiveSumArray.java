package model;

public class RecursiveSumArray {
    static int[] array = {12, -1, 15, 2, 4, 14};

    public int sumArray(int[] array, int n){
        int result = 0;
        // pregunta, por que el caso base es si n es menor o igual a cero?
        if(n <= 0){
            // por que en el caso base le sumo cero?
            result += 0;
        } else {
            result += sumArray(array, n-1) + array[n];
        }
        return result;
    }

    public static void main(String[] args){

        RecursiveSumArray r = new RecursiveSumArray();
        // por que cuando paso como parametro array.length-1 y en el metodo hago + array[n] no me da lo mismo?
        int result = r.sumArray(array, array.length-1);
        System.out.println(result);
    }

}
