package DataStructuresAndAlgorithms;
import java.util.*;

public class DoublyHashedLinkedList<Key1, Key2, I> {
    private LinkedList<I> list = new LinkedList<>();
    private Hashtable<Key1, I> table1 = new Hashtable<>(10);
    private Hashtable<Key2, I> table2 = new Hashtable<>(10);

    public DoublyHashedLinkedList() {
    }

    public void add(Key1 key1, Key2 key2, I item) throws Exception {
        // keys are unique, so if key1 and key2 are found in the tables, update the item at that index
        // also replace corresponding item in tables
        if (table1.get(key1) != null & table2.get(key2) != null) {
            I oldItem = table1.get(key1);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(oldItem)) {
                    list.remove(i);
                    list.add(i, item);
                    break;
                }
            }
            table1.replace(key1, item);
            table2.replace(key2, item);
        }
        else if (table1.get(key1) == null && table2.get(key2) == null) {
            list.add(item);
            table1.put(key1, item);
            table2.put(key2, item);
        }
        else {
            Exception mismatch = new Exception("Only one key found or two separate records found");
            throw mismatch;
        }
    }
    public void remove(Key1 key1, Key2 key2, I item) {
        if (list.contains(item) && table1.contains(item) && table2.contains(item)) {
            list.remove(item);
            table1.remove(key1, item);
            table2.remove(key2, item);
        }
    }
    public I getByKey1(Key1 key1) {
        if (table1.get(key1) != null) {
            return table1.get(key1);
        }
        return null;
    }
    public I getByKey2(Key1 key2) {
        if (table2.get(key2) != null) {
            return table2.get(key2);
        }
        return null;
    }
    // get by name and print implemented in client
    public LinkedList<I> getList() {
        return list;
    }
}

