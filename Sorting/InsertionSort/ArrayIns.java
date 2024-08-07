package Sorting.InsertionSort;

public class ArrayIns {

    private final long[] a;
    private int nElems;

    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void insertionSort() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;

            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    //    Project 3.2
    public double median() {
        insertionSort();

        if (nElems % 2 == 1) {
            return a[nElems / 2];
        } else {
            int middle1 = nElems / 2;
            int middle2 = middle1 - 1;
            return (a[middle1] + a[middle2]) / 2.0;
        }
    }
    //    Project 3.2

    //    Project 3.3
    public void noDups() {
        insertionSort();

        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex < nElems) {
            a[writeIndex++] = a[readIndex++];

            while (readIndex < nElems && a[readIndex] == a[readIndex - 1]) {
                readIndex++;
            }
        }

        nElems = writeIndex;
    }
    //    Project 3.3

}
