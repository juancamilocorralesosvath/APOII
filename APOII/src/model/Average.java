public class Average {

    public int recursiveAverage(int[] array, int n){

        int result = 0;

        if(n <= 0){

            result += 0;

        } else {

            result += recursiveAverage(array, n-1) + array[n-1];

        }

        return result;
    }

    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5, 6};

        Average a = new Average();

        double result = (double) a.recursiveAverage(array, array.length) / array.length;

        System.out.println(result);
    }
}
