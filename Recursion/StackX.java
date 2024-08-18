package Recursion;

public class StackX<T> {
    private int maxSize;
    private T[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = (T[]) new Object[maxSize];
        top = -1;
    }

    public void push(T p) {
        stackArray[++top] = p;
    }

    public T pop() {
        return stackArray[top--];
    }

    public T peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
