package DataStructuresAndAlgorithms;

import java.util.*;

public class NaturalMergeSort<I>  {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.add('M');
        list.add('E');
        list.add('R');
        list.add('G');
        list.add('E');
        list.add('S');
        list.add('O');
        list.add('R');
        list.add('T');
        list.add('E');
        list.add('X');
        list.add('A');
        list.add('M');
        list.add('P');
        list.add('L');
        list.add('E');

        sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    public static void sort(LinkedList<Character> list) {
        int numSublists = list.size();
        while (numSublists >= 3) {
            numSublists = 1;
            int sublist1Start = 0;
            int sublist2Start = 0;
            int end;

            //find two sub-lists and merge them
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) > list.get(i+1)) {
                    numSublists++;
                    if (numSublists % 2 == 0) {
                        sublist2Start = i+1;
                    }
                    else {
                        end = i;
                        merge(list, sublist1Start, sublist2Start, end);
                        sublist1Start = i+1;
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        //merge the last character into the list
        merge(list, 0,list.size()-1, list.size()-1);
    }
    public static void merge(LinkedList<Character> list, int sublist1Start, int sublist2Start, int end) {
        //merge two adjacent sorted sub-lists without using auxiliary array
        //the end of the first sublist is the start of the 2nd sublist
        Character temp;

        int pointer1 = sublist1Start;
        int pointer2 = sublist2Start;

        while (pointer1 < pointer2 && pointer2 <= end) {
            if (list.get(pointer1) > list.get(pointer2)) {
                // remove from sublist two and place in sublist one
                temp = list.remove(pointer2);
                list.add(pointer1, temp);
                pointer2++;
            }
            pointer1++;
        }

        // sort remaining characters
        while (pointer1 < end) {
            if (list.get(pointer1) > list.get(end)) {
                temp = list.remove(end);
                list.add(pointer1, temp);
            }
            pointer1++;
        }
    }
}

