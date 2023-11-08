package com.github.ageresgit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (x, y) -> y.compareTo(x));
        for (int x : stones) queue.offer(x);
        while (queue.size() > 1) {
            int h = queue.poll();
            int l = queue.poll();
            if (h != l) queue.offer(Math.abs(h - l));
        }
        Integer last = queue.poll();
        return (last == null)? 0 : last;
    }
}
