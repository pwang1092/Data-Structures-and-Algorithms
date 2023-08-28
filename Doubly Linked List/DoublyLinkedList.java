package DataStructuresAndAlgorithms;

import java.util.*;

public class DoublyLinkedList <I> {
    private Node first = null; // first item in list
    private Node last = null; // last item in list
    private int n; //size of list

    // node class for linked list implementation of stack
    private class Node {
        I item;
        Node previous;
        Node next;
    }

    public void print() {
        Node nextNode = first;
        while (nextNode != null) {
            System.out.print(nextNode.item + " ");
            nextNode = nextNode.next;
        }
        System.out.println();
    }

    public void addFirst(I item) {
        Node newNode = new Node();
        newNode.item = item;

        if(first == null) { // if list is empty
            //The newNode is pointed by both head or tail
            first = newNode;
            last = newNode;
        }
        else { // if list is not empty
            Node oldFirst = first;
            first = newNode; // update last
            first.next = oldFirst; // update next for first
            oldFirst.previous = first; // update previous for node after first
        }
    }

    public void addLast(I item) { // add to end of DoublyLinkedList
        Node newNode = new Node();
        newNode.item = item;

        if(first == null) { // if list is empty
            //The newNode is pointed by both head or tail
            first = newNode;
            last = newNode;
        }
        else { // if list is not empty
            Node oldLast = last;
            last = newNode; // update last
            last.previous = oldLast; // update previous for last
            oldLast.next = last; // update next for node before last
        }
    }

    public void removeFirst() {
        if (first != null) {
            first = first.next;
            first.previous = null;
        }
    }

    public void removeLast() {
        if (last != null) {
            last = last.previous;
            last.next = null;
        }
    }

    public void addBefore(I key, I item) { // insert item before occurrence of key
        Node nodeWithKey = first;

        while (nodeWithKey != null && !nodeWithKey.item.equals(key)) { // find where the key is
            nodeWithKey = nodeWithKey.next;
        }

        if (nodeWithKey == null) { // if the key is not found, add to the end of the list
            addLast(item);
        }

        else { // add item before first occurrence of key
            Node newNode = new Node();
            newNode.item = item;
            newNode.previous = nodeWithKey.previous; // set newNode 'previous' to the node before nodeWithKey
            newNode.next = nodeWithKey; // set newNode 'next' to nodeWithKey
            newNode.previous.next = newNode; // set 'next' pointer in node before newNode to newNode
            newNode.next.previous = newNode;  // set 'previous' pointer in node after nodeWithKey to newNode
        }
    }

    public void addAfter(I key, I item) { // insert item after occurrence of key
        Node nodeWithKey = first;

        while (nodeWithKey != null && !nodeWithKey.item.equals(key)) { // find where the key is
            nodeWithKey = nodeWithKey.next;
        }

        if (nodeWithKey == null) { // if the key is not found, add to the end of the list
            addLast(item);
        }

        else { // add item before first occurrence of key
            Node newNode = new Node();
            newNode.item = item;
            newNode.previous = nodeWithKey; // set newNode 'previous' to the nodeWithKey
            newNode.next = nodeWithKey.next; // set newNode 'next' to node after nodeWithKey
            newNode.next.previous = newNode; // set 'previous' pointer in node after newNode to newNode
            newNode.previous.next = newNode;  // set 'next' in node before nodeWithKey to newNode
        }
    }

    public void remove(I item) { // remove first occurrence with key
        Node nodeWithKey = first;

        while (nodeWithKey != null && !nodeWithKey.item.equals(item)) {
            nodeWithKey = nodeWithKey.next;
        }


        if (nodeWithKey != null) { // make sure that the item exists in the list. NodeWithKey will be null if it doesn't
            if (nodeWithKey.equals(first)) {
                removeFirst();
            } else if (nodeWithKey.equals(last)) {
                removeLast();
            } else if (nodeWithKey.next != null) {
                nodeWithKey.previous.next = nodeWithKey.next;
                nodeWithKey.next.previous = nodeWithKey.previous;
            }
        }
    }

    public void moveToFront(I item) { // move first occurrence of key to front
        Node nodeWithKey = first;

        while (nodeWithKey != null && !nodeWithKey.item.equals(item)) {
            nodeWithKey = nodeWithKey.next;
        }

        if (nodeWithKey != null) { // if the item exists in the list
            remove(item);
            addFirst(item);
        }
    }

    public void moveToBack(I item) { // move first occurrence of key to front
        Node nodeWithKey = first;

        while (nodeWithKey != null && !nodeWithKey.item.equals(item)) {
            nodeWithKey = nodeWithKey.next;
        }

        if (nodeWithKey != null) { // if the item exists in the list
            remove(item);
            addLast(item);
        }
    }

    public I get(int index) {
        if (first != null) {
            Node n = first;
            for (int i = 0; i < index; i++) {
                n = first.next;
            }
            return n.item;
        }
        return null;
    }

    public int size(){
        return n;
    }
}
