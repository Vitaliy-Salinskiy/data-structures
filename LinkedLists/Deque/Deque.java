package LinkedLists.Deque;

import LinkedLists.DoublyLinked.DoublyLinkedList;
import LinkedLists.DoublyLinked.Link;

public class Deque {
    DoublyLinkedList list = new DoublyLinkedList();

    public void insertLeft(long key) {
        list.insertFirst(key);
    }

    public void insertRight(long key) {
        list.insertLast(key);
    }

    public Link deleteLeft() {
        return list.deleteFirst();
    }

    public Link deleteRight() {
        return list.deleteLast();
    }

    public void peekLeft() {
        list.getFirst().displayLink();
        System.out.println();
    }

    public void peelRight() {
        list.getLast().displayLink();
        System.out.println();
    }

    public void display() {
        list.displayForward();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        Deque deque = new Deque();

        System.out.println(deque.isEmpty());

        deque.insertLeft(23);
        deque.insertLeft(44);

        deque.display();

        deque.insertRight(31);
        deque.insertRight(11);

        deque.display();

        deque.peekLeft();
        deque.peelRight();

        deque.deleteLeft();
        deque.deleteRight();

        deque.display();
    }
}
