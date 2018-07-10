package com.runar.usejar;

import static com.runar.calculation.Series.factorial;
import static com.runar.calculation.Series.fibonacci;
import static com.runar.calculation.Series.sumUpTo;

public class Main {

    public static void main(String[] args) {
        int n = 11;
        System.out.println(sumUpTo(n));
        System.out.println(factorial(n));
        System.out.println(fibonacci(n));

    }
}
