package DataStructuresAndAlgorithms;

import java.util.*;
import java.lang.*;

public class RedBlackTreeClient {
    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> RBTree = new RedBlackTree<>();
        for (int i = 1; i <= 60; i++) {
            RBTree.put(i, 0); // value (second parameter) doesn't matter for this HW so I left it as 0
        }
        RBTree.print();

        System.out.println();

        for (int i = 1; i < 20; i++) {
            RBTree.delete(i);
        }
        RBTree.print();
    }
}
