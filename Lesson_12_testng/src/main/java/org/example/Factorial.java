package org.example;

public class Factorial {
    public static long factorial(int j) {
        long factorial = 1;
        for (int i = 2; i <= j; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
