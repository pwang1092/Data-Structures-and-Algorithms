package DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

public class Kosaraju {
    private boolean[] marked; // reached vertices
    private int[] id; // component identifiers
    private int count; // number of strong components

    public Kosaraju(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());

        Stack n = (Stack) order.reversePost();
        int i; //next int to be popped from stack
        while (n.size() > 0) {
            i = (int) n.pop();
            if (!marked[i]) {
                dfs(G, i);
                count++;
            }
        }
    }
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w]; }
    public int id(int v) {
        return id[v]; }
    public int count() {
        return count;
    }
    public void printSCC() {
        //print strongly connected components together in parenthesis
        for (int i = 0; i < count; i++) {
            System.out.print("( ");
            for (int j = 0; j < id.length; j++) {
                if (id[j] == i) {
                    System.out.print(j + " ");
                }
            }
            System.out.println(")");
        }
    }
}
