package DataStructuresAndAlgorithms;

import java.util.*;
import java.lang.*;

public class RedBlackTree<Key extends Comparable<Key>, Value>
{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    // private class for Node with two children
    private class Node
    {
        Key key;
        Value val; // associated data
        Node left, right; // subtrees
        int N; // # nodes in this subtree
        boolean color; // color of link from
        // parent to this node
        Node(Key key, Value val, int N, boolean color)
        {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }
    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return x.color == RED;
    }
    public Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left)
                + size(h.right);
        return x;
    }
    public Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    public void flipColors(Node h)
    {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    private int size(Node x)
    {
        if (x == null) return 0;
        else return x.N;
    }

    public void put(Key key, Value val)
    { // Search for key. Update value if found; grow table if new.
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val)
    {
        if (h == null) // Do standard insert, with red link to parent.
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    /** methods for delete */
    private Node moveRedLeft(Node h)
    { // Assuming that h is red and both h.left and h.left.left
        // are black, make h.left or one of its children red.
        complementColors(h);
        if (isRed(h.right.left))
        {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }
    private Node moveRedRight(Node h)
    { // Assuming that h is red and both h.right and h.right.left
        // are black, make h.right or one of its children red.
        complementColors(h);
        if (!isRed(h.left.left))
            h = rotateRight(h);
        return h;
    }

    public void deleteMin()
    {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if (root.N > 0) root.color = BLACK;
    }
    private Node deleteMin(Node h)
    {
        if (h.left == null)
            return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public Node balance(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private Node min(Node x) {
        while(x.left != null)
            x = x.left;
        return x;
    }

    private void complementColors(Node h) {
        if (h.color == RED) {
            h.color = BLACK;
        } else {
            h.color = RED;
        }
        if (h.left.color == RED) {
            h.left.color = BLACK;
        } else {
            h.left.color = RED;
        }
        if (h.right.color == RED) {
            h.right.color = BLACK;
        } else {
            h.right.color = RED;
        }
    }

    public void delete(Key key)
    {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delete(root, key);
        if (root.N > 0) root.color = BLACK;
    }
    private Node delete(Node h, Key key)
    {
        if (key.compareTo(h.key) < 0)
        {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else
        {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0)
            {
                // h.val = get(h.right, min(h.right).key); (val doesn't matter for this HW problem so I didn't bother creating the get method)
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);
    }

    public void print() {
        print(root);
    }
    private void print(Node n) {
        if (n == null) {
            return;
        }

        if (n.left == null && n.right == null) {
            System.out.println(n.key + " " + n.color);
        }
        else if (n.left == null) {
            System.out.println(n.key + " " + n.color + ", right: " + n.right.key);
        }
        else if (n.right == null) {
            System.out.println(n.key + " " + n.color + " left: " + n.left.key);
        }
        else {
            System.out.println(n.key + " " + n.color + " left: " + n.left.key + ", right: " + n.right.key);
        }
        Node left = n.left;
        Node right = n.right;
        print(left);
        print(right);
    }
}
