import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {

    // This inner class is our node structure for the doubly linked list
    private class MyNode {
        E data;
        MyNode next, prev;

        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode head, tail; // Pointers to the first and last nodes
    private int size; // Keeps track of how many elements are in the list

    @Override
    public void add(E element) {
        // We're adding to the end of the list by default
        MyNode newNode = new MyNode(element);
        if (head == null) {
            // List is empty, so new node becomes both head and tail
            head = tail = newNode;
        } else {
            // List isn't empty, so link the new node at the end
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // This method is a placeholder right now, no logic yet
    @Override
    public void set(int index, E item) { }

    @Override
    public void add(int index, E item) { }

    @Override
    public void addFirst(E item) { }

    @Override
    public void addLast(E item) { }

    @Override
    public E get(int index) {
        // Returns the data at the specified position
        return getNode(index).data;
    }

    @Override
    public E getFirst() {
        // Not implemented yet
        return null;
    }

    @Override
    public E getLast() {
        // Not implemented yet
        return null;
    }

    @Override
    public E remove(int index) {
        // Find the node to be removed
        MyNode node = getNode(index);

        // Rewire the previous node's next pointer
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next; // If no prev, we're at the head

        // Rewire the next node's prev pointer
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev; // If no next, we're at the tail

        size--; // Shrink the list size
        return node.data; // Return the removed data
    }

    @Override
    public void removeFirst() { }

    @Override
    public void removeLast() { }

    @Override
    public void sort() { }

    @Override
    public int indexOf(Object object) {
        return 0; // Placeholder
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0; // Placeholder
    }

    @Override
    public boolean exists(Object object) {
        return false; // Placeholder
    }

    @Override
    public Object[] toArray() {
        return new Object[0]; // Empty array for now
    }

    // Handy private method to find a node at a specific index
    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = tail = null; // Just drop the references
        size = 0; // And reset the size
    }

    @Override
    public boolean contains(E element) {
        MyNode current = head;
        while (current != null) {
            if (current.data.equals(element)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
