package com.github.ageresgit.math.arithmetics;

import java.util.List;
import java.util.stream.Collectors;

public class MultiplyStrings {
    public List<Integer> nullSort(List<Integer> source) {
        return source.stream().sorted((o1, o2) -> {
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.compareTo(o2);
        }).collect(Collectors.toList());
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] product = new int[num1.length() + num2.length()];
        int order = product.length - 1;
        for (int jj = num2.length() - 1; jj >= 0; jj--) {
            int residue = 0;
            int digit = num2.charAt(jj) - '0';
            int savePosition = order;
            int ii = num1.length() - 1;
            while(ii >= 0 || residue > 0) {
                if (ii >= 0) {
                    residue += digit * (num1.charAt(ii) - '0');
                    ii--;
                }
                residue += product[savePosition];
                product[savePosition] = residue % 10;
                residue /= 10;
                savePosition--;
            }
            order--;
        }
        int pos = 0;
        while (product[pos] == 0) pos++;
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < product.length; i++) {
            sb.append(product[i]);
        }

        return sb.toString();
    }
}
