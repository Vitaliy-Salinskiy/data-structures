package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleArithmeticParserApp {
    public static void main(String[] args) throws IOException {
        String input, output;

        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();
            if (input.isEmpty()) {
                break;
            }

            InToPost trans = new InToPost(input);
            output = trans.doTrans();
            System.out.println("Postfix is " + output + "\n");
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
