package LinkedLists.PriorityQueue;

import LinkedLists.SimplifiedLink;
import LinkedLists.SortedList.SortedList;

public class PriorityQueue {
    private SortedList list;

    public PriorityQueue() {
        list = new SortedList();
    }

    public void enqueue(long key) {
        list.insert(key);
    }

    public SimplifiedLink dequeue() {
        return list.remove();
    }

    public SimplifiedLink peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        list.displayList();
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.enqueue(12);
        priorityQueue.enqueue(32);
        priorityQueue.enqueue(22);
        priorityQueue.enqueue(55);

        priorityQueue.display();

        priorityQueue.dequeue();
        priorityQueue.dequeue();

        priorityQueue.display();

        SimplifiedLink link = priorityQueue.peek();
        link.displayLink();
    }
}
