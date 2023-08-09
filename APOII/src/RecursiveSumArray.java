public class RecursiveSumArray {
    static int[] array = {12, -1, 15, 2, 4, 14};

    public int sumArray(int[] array, int n){
        int result = 0;
        if(n <= 0){
            result += 0;
        } else {
            result += sumArray(array, n-1) + array[n-1];
        }
        return result;
    }

    public static void main(String args[]){

        RecursiveSumArray r = new RecursiveSumArray();
        int result = r.sumArray(array, array.length);
        System.out.println(result);
    }

}
