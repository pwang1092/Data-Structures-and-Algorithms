package DataStructuresAndAlgorithms;

import java.util.*;



public class ThreeWayQuickSort {
    public static void main(String[] args) {
        double[] thousand = new double[1000];
        generateArr(thousand);
        double[] tenThousand = new double[10000];
        generateArr(tenThousand);
        double[] hundredThousand = new double[100000];
        generateArr(hundredThousand);
        double[] million = new double[1000000];
        generateArr(million);

        getAverageRunTime(thousand);
        getAverageRunTime(tenThousand);
        getAverageRunTime(hundredThousand);
        getAverageRunTime(million);
    }

    public static void sort(double[] a, int lo, int hi, int cutoff)
    {
        if (hi <= lo) return;
        if (hi - lo <= cutoff) {
            insertionSort(a, lo, hi);
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        double pivot = a[getPivot(lo, hi)]; // get pivot
        while (i <= gt)
        {
            // three way partition based on pivot
            if (a[i] < pivot) exch(a, lt++, i++);
            else if (a[i] > pivot) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1, cutoff);
        sort(a, gt + 1, hi, cutoff);
    }

    public static void insertionSort(double[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && a[j] < a[j-1]; j--)
                exch(a, j, j - 1);
        }
    }

    public static void exch(double[] a, int index1, int index2) {
        double temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static int getPivot(int lo, int hi) {
        // I decided to use first element as in assignment (i).
        return 0;
    }

    public static void generateArr(double[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random()*10;
        }
    }

    public static void getAverageRunTime(double[] a) {
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 30; i++) {
            double[] arr = a;
            long startTime = calendar.getTimeInMillis();
            sort(arr, 0, a.length-1, i);
            long time = calendar.getTimeInMillis() - startTime;
            System.out.print(time + " ");
        }
        System.out.println();
    }
}






