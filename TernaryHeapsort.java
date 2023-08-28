package DataStructuresAndAlgorithms;

import java.util.*;



public class TernaryHeapsort<Key extends Comparable<Key>> {
    private Key[] pq; // heap-ordered ternary tree
    private int N = 0; // in pq[1..N] with pq[0] unused

    public void MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public void insert(Key v)
    {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax()
    {
        Key max = pq[1]; // Retrieve max key from top.
        exch(1, N--); // Exchange with last item.
        pq[N+1] = null; // Avoid loitering.
        sink(1); // Restore heap property.
        return max;
    }

    public void heapify()
    {
        for (int k = (N+1)/3; k >= 1; k--)
            sink(k);
        while (N > 1) {
            exch(1, N--);
            sink(1);
        }
    }

    public void set(Key k, int i) {
        pq[i] = k;
    }

    public void print() {
        for (int i = 1; i < pq.length; i++) {
            if (pq[i] == null) {
                break;
            }
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 1;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        // check parent node, (k+1)/3
        // swap until current node is smaller than parent
        while (k > 1 && less((k + 1) / 3, k)) {
            exch(k, (k + 1) / 3);
            k = (k + 1) / 3;
        }
    }

    private void sink(int k) {
        // three children of node are k*3-1. k*3. k*3+1
        while (3*k-1 <= N) {
            // get child with largest value
            int max = max(k*3-1, k*3, k*3+1);
            // swap node with child node if child is larger
            if (less(k, max))
                exch(k, max);
            // go down and keep sinking
            k = max;
        }
    }

    private int max(int i, int j, int k) {
        //three cases where k<N, j<N, or otherwise
        if (k <= N) {
            if (pq[i].compareTo(pq[j]) >= 0 && pq[i].compareTo(pq[k]) >= 0) {
                return i;
            }
            // if pq[j] is the greatest
            else if (pq[j].compareTo(pq[i]) >= 0 && pq[j].compareTo(pq[k]) >= 0) {
                return j;
            }
            // otherwise return k
            else {
                return k;
            }
        }
        else if (j <= N) {
            if (pq[i].compareTo(pq[j]) < 0) {
                return j;
            }
            else return i;
        }
        else {
            return i;
        }
    }
}






