package Sorting.BubbleSort;

public class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub arr = new ArrayBub(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        // Project 3.1
//        arr.bubbleSortBidirect();
        // Project 3.1

        arr.oddEvenSort();
        //        arr.bubbleSort();

        arr.display();
    }
}
