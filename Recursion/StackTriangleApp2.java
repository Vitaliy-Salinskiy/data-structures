package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackTriangleApp2 {
    static int theNumber;
    static int theAnswer;
    static StackX<Integer> theStack;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        stackTriangle();
        System.out.println("Triangle=" + theAnswer);
    }

    public static void stackTriangle() {
        theStack = new StackX<>(10000);
        theAnswer = 0;

        while (theNumber > 0) {
            theStack.push(theNumber--);
        }

        while (!theStack.isEmpty()) {
            int newN = theStack.pop();
            theAnswer += newN;
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }
}
