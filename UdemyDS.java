public class UdemyDS {

    public static void main(String[] args) {
        // RECURSION
        // -----------
        recursion("fibonacci");

    }

    public static void recursion(String s) {
        switch (s) {
            case "factorial":
                System.out.println(factorial(5));
            case "fibonacci":
                System.out.println(fibonacci(4));
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return (n*factorial(n-1));
    }

    public static int fibonacci(int n) {
        if (n < 1) {
            return 0;
        } else if ( n == 1 || n == 2) {
            return n-1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

}
