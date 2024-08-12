package LinkedLists.DoubleEndedLists;

import LinkedLists.Link;

public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);

        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int id, double dd) {
        Link newLink = new Link(id, dd);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public double deleteFirst() {
        double temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FirstLastList list = new FirstLastList();

        list.insertFirst(22, 2.88);
        list.insertFirst(44, 4.99);
        list.insertFirst(66, 6.99);

        list.insertLast(11, 8.99);
        list.insertLast(33, 8.99);
        list.insertLast(55, 8.99);

        list.displayList();

        list.deleteFirst();
        list.deleteFirst();

        list.displayList();
    }
}
