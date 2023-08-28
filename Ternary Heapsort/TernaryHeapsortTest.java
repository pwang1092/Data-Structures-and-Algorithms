package DataStructuresAndAlgorithms;

import java.util.*;



public class TernaryHeapsortTest {
    public static void main(String[] args) {
        TernaryHeapsort<Integer> heap = new TernaryHeapsort<>();
        heap.MaxPQ(200);

        // test insertion and the swim method
        System.out.println("Testing insert");
        for (int i = 0; i < 100; i++) {
            heap.insert((int) (Math.random()*100));
        }

        heap.print();
        System.out.println();

        // test heap sort method
        System.out.println("Testing heap sort");
        for (int i = 1; i < 101; i++) {
            heap.set((int)(Math.random()*100), i);
        }
        heap.print();
        heap.heapify();
        heap.print();
    }
}






