package LinkedLists.CircularLinkedList;

import LinkedLists.Iterator.Link;

public class Stack {
    private CircularLinkedList list;

    public Stack() {
        list = new CircularLinkedList();
    }

    public void push(long key) {
        list.insert(key);
    }

    public Link pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.remove();
    }

    public long peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.getCurrent().getData();
    }

    public boolean isEmpty() {
        return list.getCurrent() == null;
    }

    public void displayStack() {
        list.display();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(3);
        stack.push(55);

        stack.displayStack();

        stack.pop();

        System.out.println(stack.peek());
        stack.displayStack();
    }
}
