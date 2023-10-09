package model;

import java.util.ArrayList;

public class BinarySearch {
    public int binarySearch(ArrayList<Integer> array, int goal){
        int left = 0;
        int right = array.size() - 1;
        int mid =  (left + right)/2;

        while (left <= right){
            if (array.get(mid) == goal){
                return mid;
            } else if (array.get(mid) > goal) {
                left = left;
                right = mid - 1;
            } else if (array.get(mid) < goal) {
                left = mid + 1;
                right = right;
            }
            mid = (left + right) / 2;
        }
        // si el objetivo no esta realmente en el arreglo
        return -1;
    }
    public int binaryRecursion(ArrayList<Integer> array, int goal){
        int left = 0;
        int right = array.size() - 1;
        int mid =  (left + right)/2;

        // si el objetivo no esta realmente en el arreglo
        if(left > right){
           return -1;
        }else if (array.get(mid) == goal){
            return mid;
        } else if (array.get(mid) > goal) {
            left = left;
            right = mid - 1;
        } else if (array.get(mid) < goal) {
            left = mid + 1;
            right = right;
        }
        mid = (left + right) / 2;

       return binaryRecursion( array,  goal,  left,  right,  mid);
    }
    private int binaryRecursion(ArrayList<Integer> array, int goal, int left, int right, int mid){
        // si el objetivo no esta realmente en el arreglo
        if(left > right){
            return -1;
        }else if (array.get(mid) == goal){
            return mid;
        } else if (array.get(mid) > goal) {
            left = left;
            right = mid - 1;
        } else if (array.get(mid) < goal) {
            left = mid + 1;
            right = right;
        }
        mid = (left + right) / 2;
        return binaryRecursion( array,  goal,  left,  right,  mid);
    }
}
