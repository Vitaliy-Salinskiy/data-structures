package LinkedLists;

public class SimplifiedLink {
    private long dData;
    private SimplifiedLink next;

    public SimplifiedLink(long d) {
        dData = d;
    }

    public long getData() {
        return dData;
    }

    public SimplifiedLink getNext() {
        return next;
    }

    public void setNext(SimplifiedLink newLink) {
        next = newLink;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
