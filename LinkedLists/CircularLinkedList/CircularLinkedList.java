package LinkedLists.CircularLinkedList;

import LinkedLists.Iterator.Link;

public class CircularLinkedList {
    private Link current;

    public CircularLinkedList() {
    }

    public void insert(long key) {
        Link newLink = new Link(key);

        if (current == null) {
            current = newLink;
            current.setNext(current);
        } else {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            current = newLink;
        }
    }

    public Link search(long key) {
        if (current == null) return null;

        Link toFind = current;
        do {
            if (toFind.getData() == key) {
                return toFind;
            }

            toFind = toFind.getNext();
        } while (toFind != current);

        return null;
    }

    public Link remove() {
        if (current == null) return null;

        Link toRemove = current;

        if (current.getNext() == current) {
            current = null;
        } else {
            Link prev = current;
            while (prev.getNext() != current) {
                prev = prev.getNext();
            }
            prev.setNext(current.getNext());
            current = current.getNext();
        }

        return toRemove;
    }

    public Link getCurrent() {
        return current;
    }

    public void display() {
        if (current == null) {
            System.out.println("List is empty");
            return;
        }

        Link start = current.getNext();
        System.out.print("List: ");
        do {
            start.displayLink();
            start = start.getNext();
        } while (start != current.getNext());
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insert(3);
        list.insert(55);

        list.display();

        list.remove();

        System.out.println(list.search(3).getData());
        list.display();
    }
}
