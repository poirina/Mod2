import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashSet {

    private static final int SIZE = 100;

    private ArrayList<LinkedList<Integer>> table;

    public MyHashSet() {
        table = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void insert(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = table.get(index);

        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    // Удалить элемент из HashSet
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = table.get(index);

        // Удаляем элемент, если он существует
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = table.get(index);
        return bucket.contains(key);
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();

        hashSet.insert(10);
        hashSet.insert(20);

        System.out.println(hashSet.contains(10));  // true
        System.out.println(hashSet.contains(30));  // false

        hashSet.remove(10);
        System.out.println(hashSet.contains(10));  // false
    }
}