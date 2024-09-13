package HashTable.HashChain;

public class Link {
    private final int iData;
    public Link next;

    public Link(int it) {
        iData = it;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.print(iData + " ");
    }
}
