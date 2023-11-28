package com.github.ageresgit.math;

public class NumberToIntPower {
    public double myPow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                x *= x;
                n /= 2;
            }
            x = 1/x;
            n = -n;
        }
        double out = 1.0;
        for (int i = 0, k = 1; i < 31 && k <= n; i++, k <<= 1) {
            if ((n&k) != 0) out *= x;
            x *= x;
        }
        return out;
    }
    /*
    private double pow(double x, int n) {
        if (n == 1) return x;
        if ( n % 2 == 0) return pow(x*x, n/2);
        return x * pow(x, n - 1);
    }
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (x == 1.0) return 1.0;
        if (n == Integer.MIN_VALUE) {n /= 2; x = x*x;}
        if (n < 0) x = 1/x;
        return pow(x, Math.abs(n));
    }
     */
}
