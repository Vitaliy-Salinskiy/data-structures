package LinkedLists.DoublyLinked;

public class Link {
    private long dData;
    private Link next;
    private Link previous;

    public Link(long d) {
        dData = d;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link newNext) {
        next = newNext;
    }

    public Link getPrevious() {
        return previous;
    }

    public void setPrevious(Link newPrev) {
        previous = newPrev;
    }

    public long getData() {
        return dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
