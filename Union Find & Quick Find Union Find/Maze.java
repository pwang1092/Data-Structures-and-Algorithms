package DataStructuresAndAlgorithms;

import java.lang.reflect.Array;
import java.util.*;

public class Maze {
    public static void main(String[] args) {
        int r = 15; // rows
        int c = 15; // columns
        UnionFind maze = new UnionFind(r*c);
        ArrayList<Wall> walls = new ArrayList<>(); // num walls excluding outside border is (r-1)*c + (c-1)*r
        ArrayList<Wall> leftoverWalls = new ArrayList<>(); // arraylist to store walls that won't be deleted

        generateWalls(walls, r, c);

        while (!allSquaresConnected(maze, r*c) && walls.size() > 0) {
            int index = (int) (Math.random()*walls.size());
            Wall randomWall = walls.get(index);
            if (maze.connected(randomWall.getX(), randomWall.getY())) {
                // if the two squares next to randomWall are connected, save the randomWall to print later
                leftoverWalls.add(randomWall);
            }
            else {
                // if not already connected, connect the squares by finding roots and union-ing them
                maze.union(randomWall.getX(), randomWall.getY());
            }
            walls.remove(index); // remove randomWall from wall so it isn't randomly selected again
        }

        printWalls(leftoverWalls, r, c);
    }

    public static void generateWalls(ArrayList<Wall> walls, int numRows, int numColumns) {
        int index = 0;
        for (int i = 0; i < numRows * numColumns-1; i++) { //loop excludes last square (bottom right corner) as no new walls to be formed
            if ( (i+1) % numColumns == 0) {
                // if the cell is on the right edge get wall between it and cell below. Bottom right corner won't be reached so no worries about that
                walls.add(new Wall(i, i+numColumns));
            }
            else if (i >= (numRows-1)*numColumns) {
                // if the cell is on the last row just get wall between it and cell to right.
                walls.add(new Wall(i, i+1));
            }
            else {
                //all other squares, get wall between square and square below as well as wall between square and square to the right
                walls.add(new Wall(i, i+1));
                walls.add(new Wall(i, i+numColumns));
            }
        }
    }
    public static void printWalls(ArrayList<Wall> walls, int r, int c) {
        // format to get (x,y) coordinates
        for (Wall w: walls) {
            System.out.println("(" + w.getX()/c + "," + w.getX()%c + ") (" + w.getY()/c + "," + w.getY()%c + ")");
        }
    }

    public static boolean allSquaresConnected(UnionFind uf, int length) {
        for (int i = 0; i < length; i++) {
            if (!uf.connected(0, i))
                return false;
        }
        return true;
    }
}

