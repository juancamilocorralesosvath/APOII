
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        String input = scanner.nextLine();

        String[] stringArray = input.split(" ");
        int[] intArray = new int[size];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

     /*   System.out.println("arreglo sin ordenar:");
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }*/

        int[] sortedArray = insertionSort(intArray);
/*
        System.out.println("arreglo ordenado: ");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }*/

        // para hallar la menor diferencia absoluta
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sortedArray.length - 1; i++) {
            int diff = Math.abs(sortedArray[i] - sortedArray[i + 1]);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        // cuando ya tengo la menor diferencia absoluta, encuentro las parejas que tengan dicha diferencia
        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (Math.abs(sortedArray[i] - sortedArray[i + 1]) == minDiff) {
                System.out.print( sortedArray[i] + " " + sortedArray[i + 1] +" ");
            }
        }

    }
    // metodo que hicimos en clase
    public static int[] insertionSort(int[] listToSort){
        for (int i = 1; i < listToSort.length; i++) {
            int current = listToSort[i];
            int j = i - 1;
            while (j >= 0 && current < listToSort[j]){
                listToSort[j+1] =  listToSort[j];
                --j;
            }
            listToSort[j+1] = current;
        }
        return listToSort;
    }
}