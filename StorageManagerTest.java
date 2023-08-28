package DataStructuresAndAlgorithms;

import java.util.*;
import java.io.*;

public class StorageManagerTest {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        StorageManager sm = new StorageManager(10);
        System.out.println("Add 2");
        sm.addRequest(2);
        sm.printAllocationList();
        sm.printFreeList();

        System.out.println("\nAdd 3");
        sm.addRequest(3);
        sm.printAllocationList();
        sm.printFreeList();

        System.out.println("\nAdd 1");
        sm.addRequest(1);
        sm.printAllocationList();
        sm.printFreeList();

        System.out.println("\nDelete (0, 2)");
        sm.delete(0, 2);
        sm.printAllocationList();
        sm.printFreeList();

        System.out.println("\nAdd 1");
        sm.addRequest(1);
        sm.printAllocationList();
        sm.printFreeList();

        System.out.println("\nAdd 3");
        sm.addRequest(3);
        sm.printAllocationList();
        sm.printFreeList();

        System.out.println("\nDelete (2, 3)");
        sm.delete(2, 3);
        sm.printAllocationList();
        sm.printFreeList();

        System.out.println("\nDelete (5, 1)");
        sm.delete(5, 1);
        sm.printAllocationList();
        sm.printFreeList();
    }
}

