package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverser {
    final private String input;
    private String output;

    public Reverser(String in) {
        input = in;
    }

    public String doDev() {
        int stackSize = input.length();
        CustomStack<Character> stack = new CustomStack<>(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            stack.push(ch);
        }

        output = "";

        while (!stack.isEmpty()) {
            char ch = stack.pop();
            output += ch;
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }

            Reverser theReverser = new Reverser(input);
            output = theReverser.doDev();
            System.out.println("Reversed: " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
