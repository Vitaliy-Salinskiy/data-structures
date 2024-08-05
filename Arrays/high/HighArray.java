package Arrays.high;

public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;

        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }

        return j != nElems;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;

        for (j = 0; j < nElems; j++) {
            if (value == a[j]) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public long getMax() {
        if (nElems == 0) {
            return 1;
        } else {
            long max = a[0];
            for (int i = 0; i < nElems; i++) {
                if (max < a[i]) {
                    max = a[i];
                }
            }

            return max;
        }
    }

    public int size() {
        return nElems;
    }

    public long removeMax() {
        long maxItem = getMax();
        delete(maxItem);
        return maxItem;
    }

    public void noDups() {
        for (int j = 0; j < nElems; j++) {
            for (int i = j + 1; i < nElems; i++) {
                if (a[j] == a[i]) {
                    for (int k = j; k < nElems - 1; k++) {
                        a[k] = a[k + 1];
                    }
                    nElems--;
                    i--;
                }
            }
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

}
