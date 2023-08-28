package DataStructuresAndAlgorithms;

import java.util.*;
import java.io.*;

public class KosarajuClient{
    public static void main(String[] args) throws Exception {
        Digraph digraph = new Digraph(12);

        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(1, 3);
        digraph.addEdge(1, 4);
        digraph.addEdge(2, 5);
        digraph.addEdge(4, 1);
        digraph.addEdge(4, 5);
        digraph.addEdge(4, 6);
        digraph.addEdge(5, 2);
        digraph.addEdge(5, 7);
        digraph.addEdge(6, 7);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 10);
        digraph.addEdge(8, 6);
        digraph.addEdge(9, 8);
        digraph.addEdge(10, 11);
        digraph.addEdge(11, 9);

        Kosaraju StronglyConnectedComponents = new Kosaraju(digraph);
        StronglyConnectedComponents.printSCC();
    }
}

