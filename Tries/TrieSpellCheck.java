package DataStructuresAndAlgorithms;
import java.io.*;
import java.util.*;

public class TrieSpellCheck {
    public static void main(String[] args) throws Exception {
        File words = new File("C://users//plwdr//Documents//Java//src//DataStructuresAndAlgorithms//words.txt");
        Scanner textFile = new Scanner(words);
        Scanner input = new Scanner(System.in);

        // create a trie and put all the strings in word.txt in it
        int val = 0;
        Trie<Integer> trie = new Trie<>();
        while (textFile.hasNext()) {
            trie.put(textFile.next(), val++);
        }

        // prompt user to type characters one at a time and to terminate by typing 0
        System.out.println("Type characters one at a time, type 0 to finish: ");
        String str = "";
        char ch = input.next().charAt(0);
        while (ch != '0') {
            str = str + ch;
            Queue<String> stringsWithPrefix = (Queue) trie.keysWithPrefix(str);
            if (stringsWithPrefix.size() == 1) {
                System.out.println(stringsWithPrefix.peek());
                break;
            }
            else if (stringsWithPrefix.size() <= 5) {
                for (String s: stringsWithPrefix) {
                    System.out.println(s);
                }
            }
            ch = input.next().charAt(0);
        }
    }

}

class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }

    // a linked-list iterator
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

