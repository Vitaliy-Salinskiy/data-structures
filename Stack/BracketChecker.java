package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketChecker {
    private final String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        CustomStack<Character> stack = new CustomStack<>(stackSize);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(': {
                    stack.push(ch);
                    break;
                }
                case '}':
                case ']':
                case ')': {
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if (ch == '}' && chx != '{' || ch == ']' && chx != '[' || ch == ')' && chx != '(') {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: missing the right delimiter");
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();

            if (input.isEmpty()) {
                break;
            }

            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();

        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
