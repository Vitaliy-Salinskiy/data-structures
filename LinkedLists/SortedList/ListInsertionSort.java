package LinkedLists.SortedList;

import LinkedLists.SimplifiedLink;

public class ListInsertionSort {
    private SimplifiedLink first;

    public ListInsertionSort() {
    }

    public ListInsertionSort(SimplifiedLink[] linkArr) {
        for (SimplifiedLink simplifiedLink : linkArr) {
            insert(simplifiedLink);
        }
    }

    public void insert(SimplifiedLink k) {
        SimplifiedLink previous = null;
        SimplifiedLink current = first;

        while (current != null && k.getData() > current.getData()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            first = k;
        } else {
            previous.setNext(k);
        }
        k.setNext(current);
    }

    public SimplifiedLink remove() {
        SimplifiedLink temp = first;
        first = first.getNext();
        return temp;
    }

    public static void main(String[] args) {
        int size = 10;

        SimplifiedLink[] linkArray = new SimplifiedLink[size];

        for (int i = 0; i < size; i++) {
            long n = (long) (Math.random() * 99);
            SimplifiedLink newLink = new SimplifiedLink(n);
            linkArray[i] = newLink;
        }

        System.out.print("Unsorted Array ");
        for (int i = 0; i < size; i++) {
            System.out.print(linkArray[i].getData() + " ");
        }
        System.out.println();

        ListInsertionSort sortedList = new ListInsertionSort(linkArray);

        for (int i = 0; i < size; i++) {
            linkArray[i] = sortedList.remove();
        }

        System.out.print("Sorted Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(linkArray[i].getData() + " ");
        }
        System.out.println();
    }
}
