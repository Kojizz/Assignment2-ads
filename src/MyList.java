// This is a custom interface like Java's List<T>, but we're building it ourselves.
// All classes like MyArrayList and MyLinkedList will implement this.
public interface MyList<T> extends Iterable<T> {

    // Add an item to the end of the list
    void add(T item);

    // Replace the item at a specific index
    void set(int index, T item);

    // Add an item at a specific index
    void add(int index, T item);

    // Add item to the beginning of the list
    void addFirst(T item);

    // Add item to the end (same as add)
    void addLast(T item);

    // Get item at a specific index
    T get(int index);

    // Get the first item
    T getFirst();

    // Get the last item
    T getLast();

    // Remove and return item at a specific index
    T remove(int index);

    // Remove the first item (void return if not using return value)
    void removeFirst();

    // Remove the last item (same here)
    void removeLast();

    // Sort the list (natural ordering, T must be Comparable)
    void sort();

    // Find the index of the first occurrence of an object
    int indexOf(Object object);

    // Find the index of the last occurrence of an object
    int lastIndexOf(Object object);

    // Check if an object exists in the list
    boolean exists(Object object);

    // Convert the list to an array
    Object[] toArray();

    // Clear the list (remove all elements)
    void clear();

    // Get the number of elements in the list
    int size();

    // Check if the list is empty
    boolean isEmpty();

    // Returns true if this list contains the specified element
    boolean contains(T element);
}
