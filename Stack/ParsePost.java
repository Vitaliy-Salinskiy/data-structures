package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParsePost {
    private CustomStack<Integer> stack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public int doParse() {
        stack = new CustomStack<>(20);
        char ch;
        int j;
        int num1, num2, interAns;

        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            stack.displayStack(ch + " ");
            if (ch >= '0' && ch <= '9') {
                stack.push((int) ch - '0');
            } else {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ch) {
                    case '+': {
                        interAns = num1 + num2;
                        break;
                    }
                    case '-': {
                        interAns = num1 - num2;
                        break;
                    }
                    case '*': {
                        interAns = num1 * num2;
                        break;
                    }
                    case '/': {
                        interAns = num1 / num2;
                        break;
                    }
                    default: {
                        interAns = 0;
                    }
                }
                stack.push(interAns);
            }
        }
        interAns = stack.pop();
        return interAns;
    }

    public static void main(String[] args) throws IOException {
        String input;
        int output;

        while (true) {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString();

            if (input.isEmpty()) {
                break;
            }

            ParsePost parsePost = new ParsePost(input);
            output = parsePost.doParse();
            System.out.println("Evaluates to " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
