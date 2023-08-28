package DataStructuresAndAlgorithms;

import java.util.*;
import java.io.*;


public class SentinelAlarmCompany {

    public static void main(String[] args) {

        // create EdgeWeightedGraph with all the edges
        EdgeWeightedGraph graph = new EdgeWeightedGraph(50);
        graph.addEdge(new Edge(0, 1, 33));
        graph.addEdge(new Edge(0, 2, 30));
        graph.addEdge(new Edge(0, 6, 17));
        graph.addEdge(new Edge(0, 9, 25));
        graph.addEdge(new Edge(1, 4, 25));
        graph.addEdge(new Edge(1, 5, 13));
        graph.addEdge(new Edge(1, 6, 18));
        graph.addEdge(new Edge(2, 3, 15));
        graph.addEdge(new Edge(2, 9, 20));
        graph.addEdge(new Edge(2, 10, 35));
        graph.addEdge(new Edge(2, 12, 27));
        graph.addEdge(new Edge(3, 8, 15));
        graph.addEdge(new Edge(3, 9, 31));
        graph.addEdge(new Edge(3, 12, 23));
        graph.addEdge(new Edge(3, 14, 15));
        graph.addEdge(new Edge(3, 21, 20));
        graph.addEdge(new Edge(4, 5, 20));
        graph.addEdge(new Edge(4, 7, 31));
        graph.addEdge(new Edge(4, 16, 40));
        graph.addEdge(new Edge(5, 6, 20));
        graph.addEdge(new Edge(5, 7, 15));
        graph.addEdge(new Edge(5, 8, 30));
        graph.addEdge(new Edge(6, 8, 25));
        graph.addEdge(new Edge(6, 9, 21));
        graph.addEdge(new Edge(7, 8, 35));
        graph.addEdge(new Edge(7, 16, 25));
        graph.addEdge(new Edge(7, 17, 20));
        graph.addEdge(new Edge(7, 32, 30));
        graph.addEdge(new Edge(8, 9, 16));
        graph.addEdge(new Edge(8, 21, 35));
        graph.addEdge(new Edge(8, 32, 32));
        graph.addEdge(new Edge(10, 12, 22));
        graph.addEdge(new Edge(10, 13, 28));
        graph.addEdge(new Edge(11, 43, 35));
        graph.addEdge(new Edge(11, 45, 21));
        graph.addEdge(new Edge(11, 47, 33));
        graph.addEdge(new Edge(11, 48, 44));
        graph.addEdge(new Edge(12, 14, 22));
        graph.addEdge(new Edge(12, 15, 30));
        graph.addEdge(new Edge(13, 15, 28));
        graph.addEdge(new Edge(13, 20, 40));
        graph.addEdge(new Edge(14, 15, 36));
        graph.addEdge(new Edge(14, 19, 23));
        graph.addEdge(new Edge(14, 20, 35));
        graph.addEdge(new Edge(14, 21, 16));
        graph.addEdge(new Edge(15, 20, 25));
        graph.addEdge(new Edge(16, 17, 30));
        graph.addEdge(new Edge(16, 22, 35));
        graph.addEdge(new Edge(16, 27, 50));
        graph.addEdge(new Edge(17, 22, 28));
        graph.addEdge(new Edge(17, 23, 25));
        graph.addEdge(new Edge(17, 28, 38));
        graph.addEdge(new Edge(17, 32, 15));
        graph.addEdge(new Edge(18, 21, 20));
        graph.addEdge(new Edge(18, 23, 30));
        graph.addEdge(new Edge(18, 24, 30));
        graph.addEdge(new Edge(18, 29, 40));
        graph.addEdge(new Edge(18, 32, 15));
        graph.addEdge(new Edge(19, 20, 30));
        graph.addEdge(new Edge(19, 21, 30));
        graph.addEdge(new Edge(19, 24, 35));
        graph.addEdge(new Edge(19, 25, 25));
        graph.addEdge(new Edge(19, 26, 40));
        graph.addEdge(new Edge(20, 26, 30));
        graph.addEdge(new Edge(21, 24, 45));
        graph.addEdge(new Edge(21, 32, 26));
        graph.addEdge(new Edge(22, 27, 35));
        graph.addEdge(new Edge(22, 28, 30));
        graph.addEdge(new Edge(23, 28, 18));
        graph.addEdge(new Edge(23, 29, 32));
        graph.addEdge(new Edge(23, 32, 30));
        graph.addEdge(new Edge(24, 25, 25));
        graph.addEdge(new Edge(24, 29, 15));
        graph.addEdge(new Edge(25, 26, 30));
        graph.addEdge(new Edge(25, 30, 30));
        graph.addEdge(new Edge(25, 31, 21));
        graph.addEdge(new Edge(25, 37, 50));
        graph.addEdge(new Edge(26, 31, 20));
        graph.addEdge(new Edge(26, 38, 55));
        graph.addEdge(new Edge(27, 28, 43));
        graph.addEdge(new Edge(27, 34, 25));
        graph.addEdge(new Edge(27, 42, 26));
        graph.addEdge(new Edge(28, 29, 42));
        graph.addEdge(new Edge(28, 34, 30));
        graph.addEdge(new Edge(28, 35, 25));
        graph.addEdge(new Edge(29, 30, 35));
        graph.addEdge(new Edge(29, 35, 30));
        graph.addEdge(new Edge(29, 36, 37));
        graph.addEdge(new Edge(30, 36, 33));
        graph.addEdge(new Edge(30, 37, 20));
        graph.addEdge(new Edge(31, 37, 35));
        graph.addEdge(new Edge(31, 38, 40));
        graph.addEdge(new Edge(33, 37, 35));
        graph.addEdge(new Edge(33, 38, 25));
        graph.addEdge(new Edge(33, 39, 25));
        graph.addEdge(new Edge(33, 46, 30));
        graph.addEdge(new Edge(33, 49, 20));
        graph.addEdge(new Edge(34, 35, 33));
        graph.addEdge(new Edge(34, 41, 25));
        graph.addEdge(new Edge(34, 42, 20));
        graph.addEdge(new Edge(34, 43, 37));
        graph.addEdge(new Edge(35, 36, 43));
        graph.addEdge(new Edge(35, 40, 35));
        graph.addEdge(new Edge(35, 41, 30));
        graph.addEdge(new Edge(36, 37, 28));
        graph.addEdge(new Edge(36, 39, 25));
        graph.addEdge(new Edge(36, 40, 30));
        graph.addEdge(new Edge(37, 38, 25));
        graph.addEdge(new Edge(37, 39, 30));
        graph.addEdge(new Edge(38, 49, 45));
        graph.addEdge(new Edge(39, 40, 40));
        graph.addEdge(new Edge(39, 46, 20));
        graph.addEdge(new Edge(40, 41, 27));
        graph.addEdge(new Edge(40, 45, 20));
        graph.addEdge(new Edge(40, 46, 28));
        graph.addEdge(new Edge(41, 43, 14));
        graph.addEdge(new Edge(41, 45, 23));
        graph.addEdge(new Edge(42, 43, 34));
        graph.addEdge(new Edge(42, 44, 24));
        graph.addEdge(new Edge(42, 47, 36));
        graph.addEdge(new Edge(43, 45, 30));
        graph.addEdge(new Edge(43, 47, 15));
        graph.addEdge(new Edge(44, 47, 26));
        graph.addEdge(new Edge(45, 46, 30));
        graph.addEdge(new Edge(45, 48, 33));
        graph.addEdge(new Edge(46, 48, 15));
        graph.addEdge(new Edge(46, 49, 35));
        graph.addEdge(new Edge(48, 49, 32));


        int[] towers = new int[]{7, 14, 25, 28, 40};

        // run EagerPrims on the graph
        DijkstraModified dijaska = new DijkstraModified(graph, towers);

        // print minimum response times for each node
        double[] distTo = dijaska.distArray();
        for (int i = 0; i < distTo.length; i++) {
            System.out.println(i + "  " + distTo[i]);
        }

        // print path nodes to each customer
        Edge[] edgeTo = dijaska.edgeToArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int node = 0; node < 50; node++) {
            System.out.print(node + ":  ");
            // continue if the node is a tower
            if (isTower(node)) {
                System.out.println();
                continue;
            }
            // otherwise find path to tower
            int currentNode = edgeTo[node].other(node);
            // loop and set currentNode to the vertice at other end of edge until reach a tower
            while (!isTower(currentNode)) {
                System.out.print(currentNode + " ");
                currentNode = edgeTo[currentNode].other(currentNode);
            }
            System.out.println(currentNode);
        }

        // test each of the 5 field stations and see which one should be chosen to minimize total travel time 
        DijkstraModified tower7 = new DijkstraModified(graph, 7); 
        System.out.println("tower 7: " + totalWeight(tower7.distArray()));
        DijkstraModified tower14 = new DijkstraModified(graph, 7);
        System.out.println("tower 14: " + totalWeight(tower14.distArray()));
        DijkstraModified tower25 = new DijkstraModified(graph, 25);
        System.out.println("tower 25: " + totalWeight(tower25.distArray()));
        DijkstraModified tower28 = new DijkstraModified(graph, 28);
        System.out.println("tower 28: " + totalWeight(tower28.distArray()));
        DijkstraModified tower40 = new DijkstraModified(graph, 40);
        System.out.println("tower 40: " + totalWeight(tower40.distArray()));
    }

    public static boolean isTower(int i) {
        if (i != 7 && i != 14 && i != 25 && i != 28 && i != 40) {
            return false;
        }
        return true;
    }
    
    public static double totalWeight(double[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
