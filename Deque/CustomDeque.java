package Deque;

public class CustomDeque<T> {
    private int maxSize;
    private T[] dequeArray;
    private int rear;
    private int front;
    private int nElems;

    public CustomDeque(int size) {
        maxSize = size;
        dequeArray = (T[]) new Object[maxSize];
        nElems = 0;
        front = 0;
        rear = -1;
    }

    public void insertLeft(T value) {
        if (isFull()) {
            throw new RuntimeException("Deque is full, cannot insert.");
        }

        front = (front - 1 + maxSize) % maxSize;
        dequeArray[front] = value;
        nElems++;
    }

    public void insertRight(T value) {
        if (isFull()) {
            throw new RuntimeException("Deque is full, cannot insert.");
        }

        rear = (rear + 1) % maxSize;
        dequeArray[rear] = value;
        nElems++;
    }

    public T removeLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty, cannot remove.");
        }

        T temp = dequeArray[front];
        front = (front + 1) % maxSize;
        nElems--;
        return temp;
    }

    public T removeRight() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty, cannot remove.");
        }

        T temp = dequeArray[rear];
        rear = (rear - 1 + maxSize) % maxSize;
        nElems--;
        return temp;
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty, cannot peek.");
        }
        return dequeArray[front];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty, cannot peek.");
        }
        return dequeArray[rear];
    }

    public boolean isEmpty() {
        return nElems == 0;
    }

    public boolean isFull() {
        return nElems == maxSize;
    }

    public void displayDeque() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue contents: ");
            for (int i = 0; i < nElems; i++) {
                int index = (front + i) % maxSize;
                System.out.print(dequeArray[index] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomDeque<Integer> deque = new CustomDeque<>(5);

        deque.insertRight(10);
        deque.insertRight(20);
        deque.insertLeft(5);
        deque.insertLeft(2);

        System.out.println("Left Peek: " + deque.peekLeft());
        System.out.println("Right Peek: " + deque.peekRight());

        System.out.println("Remove Left: " + deque.removeLeft());
        System.out.println("Remove Right: " + deque.removeRight());

        deque.displayDeque();
    }

}
