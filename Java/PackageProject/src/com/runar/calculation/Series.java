package com.runar.calculation;

/**
 * Created by rsverrisson on 09-07-2018.
 */
public class Series {
    public static int sumUpTo(int n) {
        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n) {
        int mult = 1;
        for (int i=2; i<=n; i++) {
            mult *= i;
        }
        return mult;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
