package com.github.ageresgit.math.arithmetics;

import java.util.Arrays;
import java.util.Stack;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] buf = new char[Math.max(num1.length(), num2.length()) + 1];
        int pos = buf.length;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int residue = 0;
        while (l1 >= 0 || l2 >= 0 || residue > 0) {
            residue += ((l1 >= 0) ? (num1.charAt(l1) - '0') : 0) + ((l2 >= 0) ? (num2.charAt(l2) - '0') : 0);
            buf[--pos] = ((char)('0' + residue%10));
            residue = (residue > 9) ? 1 : 0;
            l1--;
            l2--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < buf.length; i++) sb.append(buf[i]);
        return sb.toString();
    }
}
