package Graphs.WeightedGraphs;

public class PriorityQ {
    private final int SIZE = 20;
    private Edge[] queArray;
    private int size;

    public PriorityQ() {
        queArray = new Edge[SIZE];
        size = 0;
    }

    public void insert(Edge item) {
        int j;

        for (j = 0; j < size; j++) {
            if (item.distance >= queArray[j].distance) {
                break;
            }
        }

        for (int i = size - 1; i >= j; i--) {
            queArray[i + 1] = queArray[i];
        }

        queArray[j] = item;
        size++;
    }

    public Edge removeMin() {
        return queArray[--size];
    }

    public void removeN(int n) {
        for (int i = n; i < size - 1; i++) {
            queArray[i] = queArray[i + 1];
        }
        size--;
    }

    public Edge peekMin() {
        return queArray[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Edge peekN(int n) {
        return queArray[n];
    }

    public int find(int findDex) {
        for (int i = 0; i < size; i++) {
            if (queArray[i].destVert == findDex) {
                return i;
            }
        }
        return -1;
    }

}
