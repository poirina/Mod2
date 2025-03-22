import java.util.Arrays;

public class MyArrayList {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    public void add(Object element) {
        ensureCapacity();
        array[size++] = element;
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--size] = null;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void addAll(MyArrayList otherList) {
        for (int i = 0; i < otherList.size; i++) {
            add(otherList.get(i));
        }
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public int size() {
        return size;
    }


    public void testAdd() {
        add(10);
        add(20);
        add(30);
        assert size() == 3 : "Test failed: size should be 3 after adding 3 elements.";
    }

    public void testGet() {
        add(40);
        add(50);
        assert get(0).equals(40) : "Test failed: get(0) should return 40.";
        assert get(1).equals(50) : "Test failed: get(1) should return 50.";
    }

    public void testRemove() {
        add(60);
        add(70);
        remove(0);
        assert size() == 1 : "Test failed: size should be 1 after removing 1 element.";
        assert get(0).equals(70) : "Test failed: get(0) should return 70 after removal.";
    }

    public void testAddAll() {
        MyArrayList anotherList = new MyArrayList();
        anotherList.add(80);
        anotherList.add(90);
        addAll(anotherList);
        assert size() == 3 : "Test failed: size should be 3 after adding all elements from another list.";
        assert get(2).equals(90) : "Test failed: last element should be 90.";
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        list.testAdd();
        list.testGet();
        list.testRemove();
        list.testAddAll();

        System.out.println("All tests passed successfully!");
    }
}