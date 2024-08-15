package LinkedLists.SortedList;

import LinkedLists.SimplifiedLink;

public class SortedList {
    private SimplifiedLink first;

    public SortedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long key) {
        SimplifiedLink newLink = new SimplifiedLink(key);
        SimplifiedLink previous = null;
        SimplifiedLink current = first;

        while (current != null && key > current.getData()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            first = newLink;
        } else {
            previous.setNext(newLink);
        }
        newLink.setNext(current);
    }

    public SimplifiedLink remove() {
        SimplifiedLink temp = first;
        first = first.getNext();
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        SimplifiedLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public SimplifiedLink getFirst() {
        return first;
    }

    public static void main(String[] args) {
        SortedList sortedList = new SortedList();

        sortedList.insert(20);
        sortedList.insert(40);

        sortedList.displayList();

        sortedList.insert(10);
        sortedList.insert(30);
        sortedList.insert(50);

        sortedList.displayList();

        sortedList.remove();

        sortedList.displayList();
    }
}
