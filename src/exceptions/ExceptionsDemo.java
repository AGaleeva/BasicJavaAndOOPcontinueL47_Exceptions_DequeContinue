package exceptions;

public class ExceptionsDemo {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            System.out.println(div(a, b));
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println("The program is terminated");
        }


    }

    public static int div(int a, int b) {
        if (b == 0) {
            throw new RuntimeException();
        }
        int res = a / b;
        return res;
    }
}
