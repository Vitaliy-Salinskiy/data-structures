package LinkedLists.Iterator;

public class Link {
    private long dData;
    private Link next;

    public Link(long d) {
        dData = d;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link newNext) {
        next = newNext;
    }

    public long getData() {
        return dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
