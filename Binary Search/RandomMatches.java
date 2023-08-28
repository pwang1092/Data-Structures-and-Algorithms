package DataStructuresAndAlgorithms;

import java.util.*;

public class RandomMatches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        //run print average for 10^3, 10^4, 10^5, and 10^6
        printAverage(1000, T);
        printAverage(10000, T);
        printAverage(100000, T);
        printAverage(1000000, T);
    }

    public static void printAverage(int size, int T) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        double sum = 0;

        for (int i = 0; i < T; i++) {
            randomFill(array1, size);
            randomFill(array2, size);
            Collections.sort(array1);
            Collections.sort(array2);
            //add number of unique values that appear in both arrays
            sum += numMatches(array1, array2);
        }
        //print size and average number of matches, sum/size
        System.out.println("Array size: " + size + ", Average Frequency: " + ( sum/size));
    }

    public static void randomFill(ArrayList<Integer> array, int T) {
        for (int j = 0; j < T; j++) {
            array.add((int) (Math.random() * 1000000)); //add random 6 digit value
        }
    }

    public static int numMatches(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        int num = 0;
        if (binarySearch(array1.get(0), array2) >= 0) {
            num++;
        }
        for (int i = 1; i < array1.size(); i++) {
            //see if unique numbers in array1 appear in array2
            if (array1.get(i) != array1.get(i-1) && binarySearch(array1.get(i), array2) >= 0) {
                num++;
            }
        }
        return num;
    }

    public static int binarySearch(int key, ArrayList<Integer> array) {
        int first = 0;
        int last = array.size()-1;
        int mid = (first + last)/2;

        while( first <= last ){
            if (array.get(mid) < key ){
                first = mid + 1;
            }
            else if (array.get(mid) == key) {
                return mid;
            }
            else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        return -1;
    }
}
