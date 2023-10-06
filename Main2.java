import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        if(size % 2 == 0) return;

        String input = scanner.nextLine();

        String[] stringArray = input.split(" ");
        int[] intArray = new int[size];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        int[] sortedArray = insertionSort(intArray);
        System.out.println(sortedArray[sortedArray.length / 2]);
    }
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
