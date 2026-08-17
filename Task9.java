import java.util.*;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class Task9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String operator = sc.next();
        int b = sc.nextInt();

        Calculator calculator = new Calculator();

        try {
            int result;

            if (operator.equals("+")) {
                result = calculator.add(a, b);

                // Unit test for addition
                assert result == a + b;

            } else if (operator.equals("/")) {
                result = calculator.divide(a, b);

                // Unit test for division
                assert result == a / b;

            } else {
                throw new IllegalArgumentException("Invalid operator");
            }

            System.out.println("Test Passed");

        } catch (Exception e) {
            System.out.println("Test Failed");
        }

        sc.close();
    }
}