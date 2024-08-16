package Recursion;

public class BinarySearch {
    private long[] a;
    private int nElems;

    public BinarySearch(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        return recFind(searchKey, 0, nElems - 1);
    }

    public int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn = (lowerBound + upperBound) / 2;

        if (a[curIn] == searchKey) {
            return curIn;
        } else if (lowerBound > upperBound) {
            return nElems;
        } else {
            if (a[curIn] < searchKey) {
                return recFind(searchKey, curIn + 1, upperBound);
            } else {
                return recFind(searchKey, lowerBound, curIn - 1);
            }
        }
    }

    public void insert(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (lowerBound <= upperBound) {
            curIn = (lowerBound + upperBound) / 2;

            if (a[curIn] < value) {
                lowerBound = curIn + 1;
            } else {
                upperBound = curIn - 1;
            }
        }

        curIn = lowerBound;

        for (int k = nElems; k > curIn; k--) {
            a[k] = a[k - 1];
        }

        a[curIn] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearch arr = new BinarySearch(100);

        arr.insert(72);
        arr.insert(90);
        arr.insert(45);
        arr.insert(126);
        arr.insert(54);
        arr.insert(99);
        arr.insert(144);
        arr.insert(27);
        arr.insert(135);
        arr.insert(81);
        arr.insert(18);
        arr.insert(108);
        arr.insert(9);
        arr.insert(117);
        arr.insert(63);
        arr.insert(36);

        arr.display();

        int searchKey = 27;
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }
    }
}
