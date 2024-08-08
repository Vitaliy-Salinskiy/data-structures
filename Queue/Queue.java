package Queue;

public class Queue<T> {
    private int maxSize;
    private T[] queArray;
    private int front;
    private int rear;

    public Queue(int s) {
        maxSize = s + 1;
        queArray = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
    }

    public void inset(T j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public T remove() {
        T temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    public T peek() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return rear + 1 == front || (front + maxSize - 1 == rear);
    }

    public boolean isFull() {
        return rear + 2 == front || (front + maxSize - 2 == rear);
    }

    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (maxSize - front) + (rear + 1);
        }
    }
}
