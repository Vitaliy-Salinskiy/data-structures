package Sorting.BubbleSort;

public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
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

    public void bubbleSort() {
        int out, in;

        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }


    // Project 3.1
    public void bubbleSortBidirect() {
        int start = 0;
        int end = nElems - 1;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end; i++) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }

            end--;

            if (!swapped) break;

            swapped = false;

            for (int i = end; i > start; i--) {
                if (a[i] < a[i - 1]) {
                    swap(i, i - 1);
                    swapped = true;
                }
            }

            start++;
        }
    }
    // /Project 3.1

    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
