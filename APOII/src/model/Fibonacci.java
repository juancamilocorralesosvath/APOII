package model;

public class Fibonacci {
    public Fibonacci() {
        // sn = sn-1 + sn-2 teniendo n1= 1 n2= 2
    }

    public int[] op() {
        // sn = sn-1 + sn-2 teniendo n1= 1 n2= 2
        int n1 = 1;
        int n2 = 1;
        int n = 2;
        int SIZE = 100;
        int[] intArray = new int[SIZE];
        intArray[0] = 1;
        intArray[1] = 1;
        int j = 0;
        while (n < 99) {
            intArray[n] = intArray[j] + intArray[j + 1];
            n++;
            j++;
        }
        return intArray;
    }

    public void printArray() {
        int[] array = op();
        for (int j : array) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        // sn = sn-1 + sn-2 teniendo n1= 1 n2= 2
        Fibonacci fb = new Fibonacci();
        fb.printArray();
        System.out.println("hello World!");
    }
}
