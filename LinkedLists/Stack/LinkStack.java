package LinkedLists.Stack;

import LinkedLists.Link;
import LinkedLists.LinkList;

public class LinkStack {
    private LinkList list;

    public LinkStack() {
        list = new LinkList();
    }

    public void push(int id, double dd) {
        list.insertFirst(id, dd);
    }

    public Link pop() {
        return list.deleteFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        list.displayList();
    }

    public static void main(String[] args) {
        LinkStack stack = new LinkStack();

        stack.push(20, 2.22);
        stack.push(40, 4.44);

        stack.displayStack();

        stack.push(60, 6.66);
        stack.push(88, 8.88);

        stack.displayStack();

        stack.pop();
        stack.pop();

        stack.displayStack();
    }
}
