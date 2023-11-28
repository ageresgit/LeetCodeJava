package com.github.ageresgit.math;

public class LargeIntegerPlusOne {
    public int[] plusOne(int[] digits) {
        int pos = digits.length - 1;
        while (pos >= 0 && digits[pos] == 9) --pos;
        if (pos >= 0) {
            digits[pos] += 1;
            for (int i = pos + 1; i < digits.length; i++) digits[i] = 0;
            return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
