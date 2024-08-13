package LinkedLists.Queue;

import LinkedLists.DoubleEndedLists.FirstLastList;

public class LinkQueue {

    private FirstLastList list;

    public LinkQueue() {
        list = new FirstLastList();
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }

    private void insert(int id, double dd) {
        list.insertLast(id, dd);
    }

    public double remove() {
        return list.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        list.displayList();
    }

    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        queue.insert(20, 2.22);
        queue.insert(40, 4.44);

        queue.displayQueue();

        queue.insert(60, 6.66);
        queue.insert(88, 8.88);

        queue.displayQueue();

        queue.remove();
        queue.remove();

        queue.displayQueue();
    }
}
