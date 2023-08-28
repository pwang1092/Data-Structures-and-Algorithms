package DataStructuresAndAlgorithms;

import java.util.*;
import java.io.*;

public class StorageManager {
    private class Pair {
        int start;
        int numUnits;

        Pair(int start, int numUnits) {
            this.start = start;
            this.numUnits = numUnits;
        }
    }
    int N;
    int[] storageUnits;
    LinkedList<Pair> allocationList = new LinkedList<>();
    LinkedList<Pair> freeList = new LinkedList<>();

    public StorageManager(int N) {
        storageUnits = new int[N];
        freeList.addLast(new Pair(0, N));
    }

    public int addRequest(int numUnits) {
        // get best fit - smallest element in free list with >= units than numunits
        // first scan until find a freeList element with enough space, assign to best fit
        Pair bestFit = null;
        int i;
        for (i = 0; i < freeList.size(); i++) {
            if (freeList.get(i).numUnits > numUnits) {
                bestFit = freeList.get(i);
                break;
            }
        }
        // if there is a freeList element with enough space, try to find a better fit
        int j = 0;
        if (bestFit != null) {
            for (j = i + 1; j < freeList.size(); j++) {
                if (freeList.get(j).numUnits > numUnits && freeList.get(j).numUnits < bestFit.numUnits) {
                    bestFit = freeList.get(j);
                }
            }
        }
        // if bestFit exists,  update allocation list and free list
        if (bestFit != null) {
            allocationList.add(new Pair(bestFit.start, numUnits));
            int difference = bestFit.numUnits - numUnits;
            // if there is space left over, add new updated freeList
            if (difference > 0) {
                freeList.add(new Pair(bestFit.start + numUnits, difference));
            }
            // delete previous freeList
            freeList.remove(bestFit);
            return bestFit.start + numUnits;
        }
        // otherwise return -1
        return -1;
    }

    public void delete(int start, int numUnits) {
         Pair frontAdjacent = frontAdjacent(start);
         Pair backAdjacent = backAdjacent(start, numUnits);

         //delete customer's storage
         for (int i = 0; i < allocationList.size(); i++) {
             if (allocationList.get(i).start == start) {
                 allocationList.remove(i);
             }
         }

         //update freeList accordingly
         if (frontAdjacent != null && backAdjacent != null) {
             freeList.remove(frontAdjacent);
             freeList.remove(backAdjacent);
             freeList.add(new Pair(frontAdjacent.start, backAdjacent.start + backAdjacent.numUnits));
         }
         else if (frontAdjacent != null) {
            freeList.remove(frontAdjacent);
            freeList.add(new Pair(frontAdjacent.start, frontAdjacent.numUnits + numUnits));
         }
         else if (backAdjacent != null) {
             freeList.remove(backAdjacent);
             freeList.add(new Pair(start, numUnits + backAdjacent.numUnits));
         }
         else {
             freeList.add(new Pair(start, numUnits));
         }
    }
    // if pair we want to delete is adjacent to 0 in front, return the free-pair adjacent at front
    private Pair frontAdjacent(int start) {
        for (int i = 0; i < freeList.size(); i++) {
            Pair p = freeList.get(i);
            if (p.start + p.numUnits == start) {
                return p;
            }
        }
        return null;
    }
    // if pair we want to delete is adjacent to 0 in back, return the free-pair adjacent at back
    private Pair backAdjacent(int start, int numUnits) {
        for (int i = 0; i < freeList.size(); i++) {
            Pair p = freeList.get(i);
            if (p.start == start + numUnits) {
                return p;
            }
        }
        return null;
    }


    public void printFreeList() {
        System.out.print("FreeList: ");
        for (Pair n: freeList) {
            System.out.print("(" + n.start + "," + n.numUnits + ") ");
        }
        System.out.println();
    }

    public void printAllocationList() {
        System.out.print("Allocation list: ");
        for (Pair n: allocationList) {
            System.out.print("(" + n.start + "," + n.numUnits + ") ");
        }
        System.out.println();
    }
}

