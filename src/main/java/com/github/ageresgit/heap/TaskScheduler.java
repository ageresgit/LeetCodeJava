package com.github.ageresgit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        n++;
        int[] countingSort = new int[26];
        for (char ch : tasks) countingSort[ch - 'A'] += 1;
        PriorityQueue<Integer> scheduler = new PriorityQueue<>((x,y)->y.compareTo(x));
        for(int value : countingSort) {if (value > 0) scheduler.offer(value);}
        int[] batch = new int[n];
        int tickCount = 0;
        while (!scheduler.isEmpty()) {
            int count = Integer.min(scheduler.size(), n);
            for (int i = 0; i < count; i++) {
                batch[i] = scheduler.poll();
            }
            for (int i = 0; i < count; i++) {
                if (batch[i] == 1) break;
                scheduler.offer(batch[i] - 1);
            }
            tickCount += (scheduler.isEmpty())? count: n;
        }
        return tickCount;
    }
}
