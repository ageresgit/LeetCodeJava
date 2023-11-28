package com.github.ageresgit.math;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
    public int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int r = n%10;
            next += r*r;
            n /= 10;
        }
        return next;
    }

    public boolean isHappy(int n) {
        int turtle = n;
        int hare = n;
        while(true) {
            if (turtle == 1 || hare == 1) return true;
            turtle = getNext(turtle);
            hare = getNext(getNext(hare));
            if (turtle == hare) return false;
        }
    }

    public List<Integer> happyNumber(int n, int count) {
        List<Integer> result = new ArrayList<>();
        result.add(n);
        for (int i = 0; i < count; i++) {
            n = getNext(n);
            result.add(n);
        }
        return result;
    }
}
