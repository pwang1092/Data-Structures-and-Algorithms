package DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

import java.util.*;

class Graph {
    private final int V; // number of vertices
    private int E; // number of edges
    private LinkedList<Integer>[] adj; // adjacency lists

    public Graph(int V)
    {
        this.V = V; this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V]; // Create array of lists.
        for (int v = 0; v < V; v++) // Initialize all lists
            adj[v] = new LinkedList<Integer>(); // to empty.
    }

    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v’s list.
        adj[w].add(v); // Add v to w’s list.
        E++;
    }
    public Iterable<Integer> adj(int v)
    { return adj[v]; }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < adj.length; i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(" -> " + adj[i].get(j));
            }
            System.out.println();
        }
    }
}

class Main {
    public static void main(String[] args) {

        // Create the graph
        int V = 16;
        Graph graph = new Graph(V);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 9);
        graph.addEdge(1, 15);
        graph.addEdge(2, 15);
        graph.addEdge(3, 4);
        graph.addEdge(4, 8);
        graph.addEdge(5, 13);
        graph.addEdge(5, 14);
        graph.addEdge(6, 7);
        graph.addEdge(6, 10);
        graph.addEdge(7, 10);
        graph.addEdge(8, 9);
        graph.addEdge(8, 15);
        graph.addEdge(9, 15);
        graph.addEdge(10, 11);
        graph.addEdge(12, 13);
        graph.addEdge(12, 14);
        graph.addEdge(13, 14);

        graph.printGraph();
    }
}