package Recursion;

public class Tasks6 {
    public static void main(String[] args) {
        System.out.println(mult(4, 4));
        System.out.println(power(4, 4));
    }

    public static int mult(int x, int y) {
        if (y == 0) {
            return 0;
        } else {
            return x + mult(x, y - 1);
        }
    }

    public static int power(int x, int y) {
        if (y == 0) {
            return 1;
        } else {
            return x * power(x, y - 1);
        }
    }

}
