package org.example;

public class FactorialJunit {
    public static long factorial(int j) {
        long factorial = 1;
        if (j < 0) {
            throw new IllegalArgumentException("Факториал не определён для отрицательных чисел");
        }
        for (int i = 1; i <= j; i++) {
            factorial *= i;
        }

        return factorial;
    }
}


