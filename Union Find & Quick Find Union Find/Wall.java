package DataStructuresAndAlgorithms;

import java.util.*;

public class Wall {
    //x and y represent two squares in the maze
    private int x;
    private int y;

    public Wall (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}