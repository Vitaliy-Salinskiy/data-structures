package Stack;

import Deque.CustomDeque;

public class StackApp {
    public static void main(String[] args) {
        CustomStack<Long> theStack = new CustomStack<>(10);
        theStack.push(20L);
        theStack.push(40L);
        theStack.push(60L);
        theStack.push(80L);

        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value + " ");
        }
        System.out.println();


        CustomDeque<Long> deque = new CustomDeque<>(10);

        deque.insertRight(20L);
        deque.insertRight(40L);
        deque.insertRight(60L);
        deque.insertRight(80L);

        while (!deque.isEmpty()) {
            long value = deque.removeRight();
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
