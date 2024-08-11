package Queue;

public class CustomQueue<T> {
    private int maxSize;
    private T[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public CustomQueue(int s) {
        maxSize = s;
        queArray = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(T j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public T remove() {
        T temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public T peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue contents: ");
            for (int i = 0; i < nItems; i++) {
                int index = (front + i) % maxSize;
                System.out.print(queArray[index] + " ");
            }
        }
        System.out.println();
    }

}
