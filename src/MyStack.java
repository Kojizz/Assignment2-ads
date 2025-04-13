public class MyStack<T> {
    // This is our internal list that holds the stack elements.
    // We're using a custom list (MyArrayList) instead of Java's built-in ones.
    private MyList<T> list = new MyArrayList<>();

    // Push = add something to the top of the stack
    public void push(T item) {
        list.addLast(item); // Just toss it to the end of the list
    }

    // Pop = remove and return the top item
    public T pop() {
        // If it's empty, we freak out
        if (list.size() == 0) throw new RuntimeException("Stack is empty");

        // Grab the last item
        T item = list.getLast();

        // Remove it from the list
        list.removeLast();

        // Give it back to whoever called pop()
        return item;
    }

    // Peek = look at the top item without removing it
    public T peek() {
        if (list.size() == 0) throw new RuntimeException("Stack is empty");
        return list.getLast(); // Just return the last item
    }

    // Check if the stack has anything in it
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Find out how many items are currently in the stack
    public int size() {
        return list.size();
    }
}
