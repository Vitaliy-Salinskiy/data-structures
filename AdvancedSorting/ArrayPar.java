package AdvancedSorting;

public class ArrayPar {
    private final long[] theArray;
    private int nElems;

    public ArrayPar(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems++] = value;
    }

    public int size() {
        return nElems;
    }

    public void display() {
        System.out.print("A= ");
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && theArray[++leftPtr] < pivot) ;

            while (rightPtr > left && theArray[--rightPtr] > pivot) ;

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    public static void main(String[] args) {
        int maxSize = 16;
        ArrayPar arr = new ArrayPar(maxSize);

        for (int i = 0; i < maxSize; i++) {
            long n = (int) (Math.random() * 199);
            arr.insert(n);
        }
        arr.display();

        long pivot = 99;
        System.out.print("Pivot is " + pivot);
        int size = arr.size();

        int partDex = arr.partitionIt(0, size - 1, pivot);

        System.out.println(", Partition is at index " + partDex);
        arr.display();
    }

}
