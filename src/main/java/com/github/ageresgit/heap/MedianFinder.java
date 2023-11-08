package com.github.ageresgit.heap;

import java.util.PriorityQueue;
import java.util.Queue;

// The solution of leetcode.com #295 Find Median from Data Stream (Hard)
public class MedianFinder {
    Queue<Integer> lower;
    Queue<Integer> upper;
    public MedianFinder() {
        lower = new PriorityQueue<>((l,r) -> r.compareTo(l));
        upper = new PriorityQueue<>((l,r) -> l.compareTo(r));
    }
    private void balance() {
        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        }
        else if (upper.size() > lower.size() + 1) {
            lower.offer(upper.poll());
        }
    }

    public void addNum(int num) {
        if (lower.peek() != null && num <= lower.peek()) lower.offer(num);
        else if (upper.peek() != null && num >= upper.peek()) upper.offer(num);
        else if (lower.size() < upper.size()) lower.offer(num);
        else upper.offer(num);
        balance();
    }

    public double findMedian() {
        if (lower.peek() == null && upper.peek() == null) return 0.0;
        if (lower.size() == upper.size()) return (lower.peek() + upper.peek())*0.5;
        if (lower.size() > upper.size()) return lower.peek();
        return upper.peek();
    }
}
