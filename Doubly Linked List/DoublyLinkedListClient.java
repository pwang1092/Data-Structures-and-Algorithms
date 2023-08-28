package DataStructuresAndAlgorithms;

import java.util.*;

public class DoublyLinkedListClient {
    public static void main(String[] args) {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        list.addLast('C');
        list.addLast('O');
        list.addLast('M');
        list.addLast('P');
        list.addLast('U');
        list.addLast('T');
        list.addLast('E');
        list.print();

        System.out.println("Add 'M' to the beginning");
        list.addFirst('M');
        list.print();

        System.out.println("Add 'R' to the end");
        list.addLast('R');
        list.print();

        System.out.println("Remove first character");
        list.removeFirst();
        list.print();

        System.out.println("Remove last character");
        list.removeLast();
        list.print();

        System.out.println("Add 'M' before 'P'");
        list.addBefore('P', 'M');
        list.print();

        System.out.println("Add 'H' before 'M'");
        list.addBefore('M', 'H');
        list.print();

        System.out.println("Add 'B' before 'A'");
        list.addBefore('A', 'B');
        list.print();

        System.out.println("Add 'C' after 'P'");
        list.addAfter('P', 'C');
        list.print();

        System.out.println("Add 'L' after 'M'");
        list.addAfter('M', 'L');
        list.print();

        System.out.println("Remove 'M'");
        list.remove('M');
        list.print();

        System.out.println("Remove 'G'");
        list.remove('G');
        list.print();

        System.out.println("Move 'P' to front");
        list.moveToFront('P');
        list.print();

        System.out.println("Move' L' to back");
        list.moveToBack('L');
        list.print();
    }
}
