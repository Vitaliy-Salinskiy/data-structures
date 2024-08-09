package PriorityQueue;

public class PriorityQueue {
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQueue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        int j;

        if (nItems == 0) {
            queArray[nItems++] = item;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j + 1] = item;
            nItems++;
        }
    }

    public long remove() {
        return queArray[--nItems];
    }

    public long peekMin() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);

        while (!priorityQueue.isEmpty()) {
            long item = priorityQueue.remove();
            System.out.print(item + " ");
        }
        System.out.println();

    }
}
