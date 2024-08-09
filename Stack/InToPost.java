package Stack;

public class InToPost {
    private CustomStack<Character> stack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        int stackSize = input.length();
        stack = new CustomStack<>(stackSize);
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-': {
                    gotOper(ch, 1);
                    break;
                }
                case '*':
                case '/': {
                    gotOper(ch, 2);
                    break;
                }
                case '(': {
                    stack.push(ch);
                    break;
                }
                case ')': {
                    gotParen(ch);
                    break;
                }
                default: {
                    output += ch;
                    break;
                }
            }
        }

        while (!stack.isEmpty()) {
            stack.displayStack("While ");
            output += stack.pop();
        }
        stack.displayStack("End ");
        return output;
    }

    public void gotOper(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    output += opTop;
                }
            }
        }
        stack.push(opThis);
    }

    public void gotParen(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output += chx;
            }
        }
    }

}
