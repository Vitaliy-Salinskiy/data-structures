package Arrays.ord;

public class OrderedArray {

    private long[] a;
    private int nElems;

    public OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;

            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
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

    public boolean delete(long value) {
        int j = find(value);
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

    public static OrderedArray merge(OrderedArray arr1, OrderedArray arr2) {
        OrderedArray mergedArr = new OrderedArray(arr1.size() + arr2.size());
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.a[i] < arr2.a[j]) {
                mergedArr.a[k++] = arr1.a[i++];
            } else {
                mergedArr.a[k++] = arr2.a[j++];
            }
        }

        while (i < arr1.size()) {
            mergedArr.a[k++] = arr1.a[i++];
        }

        while (j < arr2.size()) {
            mergedArr.a[k++] = arr1.a[j++];
        }

        mergedArr.nElems = k;
        return mergedArr;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

}
