import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    // Array to hold the actual elements
    private Object[] data;

    // Keeps track of how many elements are currently in the list
    private int size;

    // Initial size of the array before it needs resizing
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor – starts off with the default size
    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // If the array is full, double its size
    private void ensureCapacity() {
        if (size >= data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    // Add an item to the end of the list
    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    // Replace item at a specific index
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        data[index] = item;
    }

    // Add an item at a specific index, shifting everything after it to the right
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
    }

    // Add to the beginning
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Add to the end
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Get item at a specific index
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    // Remove item at index (but always returns null – maybe you meant to return the removed item?)
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        data[size] = null;
        return null; // <- should probably return the removed element!
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    // Sort using bubble sort – works if T is Comparable
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) data[j];
                T b = (T) data[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Convert the array list into a plain array
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    // Clears the whole list
    @Override
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    // Always returns false?? Needs fixing
    @Override
    public boolean isEmpty() {
        return size == 0; // <- should be this instead of false
    }

    // Always returns false?? Needs fixing
    @Override
    public boolean contains(T element) {
        return exists(element); // <- reusing your own method
    }

    // Enables for-each loop support
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return (T) data[cursor++];
            }
        };
    }
}
