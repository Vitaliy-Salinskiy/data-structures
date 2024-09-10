package Trees.TTFTree;

public class Node {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childrenArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER - 1];

    public void connectChild(int childNum, Node child) {
        childrenArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node tempNode = childrenArray[childNum];
        childrenArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum) {
        return childrenArray[childNum];
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childrenArray[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItem getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    public int findItem(long key) {
        for (int i = 0; i < ORDER - 1; i++) {
            if (itemArray[i] == null) {
                break;
            } else if (itemArray[i].dData == key) {
                return i;
            }
        }
        return -1;
    }

    public int insertItem(DataItem newItem) {
        numItems++;
        long newKey = newItem.dData;

        for (int i = ORDER - 2; i >= 0; i--) {
            if (itemArray[i] == null) {
                continue;
            } else {
                long itsKey = itemArray[i].dData;
                if (newKey < itsKey) {
                    itemArray[i + 1] = itemArray[i];
                } else {
                    itemArray[i + 1] = newItem;
                    return i + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            itemArray[i].displayItem();
        }
        System.out.println("/");
    }

}
