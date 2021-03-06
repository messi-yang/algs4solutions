package fundamentals.bagsqueuesstacks;

import java.util.NoSuchElementException;

public class QueueWithTwoStacks<Item> {

    private Stack<Item> stack1;
    private Stack<Item> stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    private void moveStack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) {
            moveStack1ToStack2();
        }

        return stack2.peek();
    }

    public void enqueue(Item item) {
        stack1.push(item);
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (stack2.isEmpty()) {
            moveStack1ToStack2();
        }

        return stack2.pop();
    }
}
