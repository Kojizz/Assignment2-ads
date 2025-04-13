public class MyQueue<T> {
    // Internally using a linked list to manage the queue elements
    private MyList<T> list = new MyLinkedList<>();

    // Add an item to the back of the queue
    public void enqueue(T item) {
        list.addLast(item);
    }

    // Remove and return the item at the front of the queue
    public T dequeue() {
        if (list.size() == 0) throw new RuntimeException("Queue is empty");
        T item = list.getFirst();  // Grab the first item
        list.removeFirst();        // Then remove it
        return item;
    }

    // Just look at the front item without removing it
    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Queue is empty");
        return list.getFirst();
    }

    // Check if the queue has no elements
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Return how many elements are in the queue
    public int size() {
        return list.size();
    }
}
