package DataStructuresAndAlgorithms;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Fibonacci {
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }
    public static void main(String[] args) {
        long iterationStartTime;
        long iterationDuration;

        for (int N = 0; N < 100; N++) {
            iterationStartTime = System.currentTimeMillis(); //update iteration start time
            System.out.print(N + " " + F(N));

            iterationDuration = System.currentTimeMillis() - iterationStartTime;
            System.out.println(". Iteration duration: " + iterationDuration);
            if (iterationDuration > 60*60*1000) { //number of milliseconds in a second
                break;
            }
        }
        System.out.println("Program completed");
    }
}
