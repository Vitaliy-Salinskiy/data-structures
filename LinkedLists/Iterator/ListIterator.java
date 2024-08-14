package LinkedLists.Iterator;

public class ListIterator {
    private Link current;
    private Link previous;
    private final LinkList list;

    public ListIterator(LinkList list) {
        this.list = list;
        reset();
    }

    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return current.getNext() == null;
    }

    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(long dd) {
        Link newLink = new Link(dd);

        if (list.isEmpty()) {
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            nextLink();
        }
    }

    public void insertBefore(long dd) {
        Link newLink = new Link(dd);

        if (previous == null) {
            newLink.setNext(list.getFirst());
            list.setFirst(newLink);
            reset();
        } else {
            newLink.setNext(previous.getNext());
            previous.setNext(newLink);
            current = newLink;
        }
    }

    public long deleteCurrent() {
        long value = current.getData();

        if (previous == null) {
            list.setFirst(current.getNext());
            reset();
        } else {
            previous.setNext(current.getNext());
            if (atEnd()) {
                reset();
            } else {
                current = current.getNext();
            }
        }
        return value;
    }
}
