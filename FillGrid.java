package DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

public class FillGrid {

    public static void main(String[] args) {
        int[][] grid = new int[15][15];
        // parallel arrayLists to hold the Row and Column number of each '0' in the grid
        ArrayList<Integer> zerosRowNum = new ArrayList<Integer>();
        ArrayList<Integer> zerosColNum = new ArrayList<Integer>();
        // parallel arrayLists to hold the Row and Column number of each '1' in the grid
        ArrayList<Integer> onesRowNum = new ArrayList<Integer>();
        ArrayList<Integer> onesColNum = new ArrayList<Integer>();

        // generate a random grid and print it
        GenerateGrid(grid, zerosRowNum, zerosColNum, onesRowNum, onesColNum);
        PrintGrid(grid);

        // choose a random 0 in the grid and fill adjacent cluster with '1's
        fillRandomZero(grid, zerosRowNum, zerosColNum);
        PrintGrid(grid);

        // choose a random 1 in the grid and fill adjacent cluster with '1's
        fillRandomOne(grid, onesRowNum, onesColNum);
        PrintGrid(grid);
    }

    // generate random grid
    public static void GenerateGrid(int[][] grid, ArrayList<Integer> zerosRowNum, ArrayList<Integer> zerosColNum,
                                    ArrayList<Integer> onesRowNum, ArrayList<Integer> onesColNum) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int rand = (int) (Math.random()*2);
                grid[i][j] = rand;
                // put coordinates of '0' in parallel arraylist
                if (rand == 0) {
                    zerosRowNum.add(i);
                    zerosColNum.add(j);
                }
                // put coordinates of '1' in parallel arraylist
                else {
                    onesRowNum.add(i);
                    onesColNum.add(i);
                }
            }
        }
    }

    public static void PrintGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void fillRandomZero(int[][] grid, ArrayList<Integer> zerosRowNum, ArrayList<Integer> zerosColNum) {
        int rand = (int) (Math.random() * zerosRowNum.size());
        int rowNum = zerosRowNum.remove(rand);
        int colNum = zerosColNum.remove(rand);

        System.out.println("Filling 0 at " + rowNum + ", " + colNum);
        dfs(grid, 0, rowNum, colNum);
    }

    public static void fillRandomOne(int[][] grid, ArrayList<Integer> onesRowNum, ArrayList<Integer> onesColNum) {
        int rand = (int) (Math.random() * onesRowNum.size());
        int rowNum = onesRowNum.remove(rand);
        int colNum = onesColNum.remove(rand);

        System.out.println("Filling 1 at " + rowNum + ", " + colNum);
        dfs(grid, 1, rowNum, colNum);
    }

    private static void dfs(int[][] grid, int value, int row, int col) {
        // if the value at row, col does not match value, return
        if (grid[row][col] != value) {
            return;
        }
        // if value matches, reverse the bit
        else {
            grid[row][col] = 1-value;
        }

        // dfs to search cell to right, cell to left, cell below, and cell above
        if (row != grid.length-1)
            dfs(grid, value, row+1, col);
        if (row != 0)
            dfs(grid, value, row-1, col);
        if (col != grid[0].length-1)
            dfs(grid, value, row, col+1);
        if (col != 0) {
            dfs (grid, value, row, col-1);
        }
    }
}

