public class MyMinHeap<T extends Comparable<T>> {
    // Internally storing the heap as a dynamic array
    private MyList<T> list = new MyArrayList<>();

    // Adds an item to the heap
    public void add(T item) {
        list.addLast(item);  // Add it at the end
        heapifyUp(list.size() - 1); // Fix the heap property by "bubbling up"
    }

    // Removes and returns the smallest item (at the top of the heap)
    public T removeMin() {
        if (list.size() == 0) throw new RuntimeException("Heap is empty");

        T min = list.get(0);   // Smallest item is always at index 0
        T last = list.get(list.size() - 1);  // Get the last item
        list.set(0, last);  // Move it to the top
        list.removeLast();   // Remove the last spot (now duplicated)
        heapifyDown(0);   // Restore heap by "pushing down"

        return min;
    }

    // Just peek at the smallest item without removing it
    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Heap is empty");
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Fix the heap upwards – used after inserting a new element
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;  // Get parent index
            T current = list.get(index);
            T parentVal = list.get(parent);

            if (current.compareTo(parentVal) < 0) {
                // Swap current with parent if smaller
                list.set(index, parentVal);
                list.set(parent, current);
                index = parent;
            } else {
                break;  // If no more violations, done
            }
        }
    }

    // Fix the heap downwards – used after removing the root
    private void heapifyDown(int index) {
        int size = list.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            // Find smallest among current and children
            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            // If a child is smaller, swap and keep going
            if (smallest != index) {
                T temp = list.get(index);
                list.set(index, list.get(smallest));
                list.set(smallest, temp);
                index = smallest;
            } else {
                break; // Heap is valid
            }
        }
    }
}
