package LinkedLists.DoublyLinked;

public class DoublyLinkedList {
    private Link first;
    private Link last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        Link newLink = new Link(dd);

        if (isEmpty()) {
            last = newLink;
        } else {
            first.setPrevious(newLink);
        }
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(long dd) {
        Link newLink = new Link(dd);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrevious(null);
        }
        first = first.getNext();
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrevious().setNext(null);
        }
        last = last.getPrevious();
        return temp;
    }

    public boolean insertAfter(long key, long dd) {
        Link current = first;
        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                return false;
            }
        }
        Link newLink = new Link(dd);

        if (current == last) {
            newLink.setNext(null);
            last = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
        }
        newLink.setPrevious(current);
        current.setNext(newLink);
        return true;
    }

    public Link deleteKey(long key) {
        Link current = first;
        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.getNext();
        } else {
            current.getPrevious().setNext(current.getNext());
        }

        if (current == last) {
            last = current.getPrevious();
        } else {
            current.getNext().setPrevious(current.getPrevious());
        }
        return current;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.getPrevious();
        }
        System.out.println();
    }

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);

        list.displayForward();
        list.displayBackward();

        list.deleteFirst();
        list.deleteLast();
        list.deleteKey(11);

        list.displayForward();

        list.insertAfter(22, 77);
        list.insertAfter(33, 88);

        list.displayForward();
    }
}
