package com.github.ageresgit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class KthLargest {
    private static class Heap {
        private int capacity;
        private int size;
        private int[] heap;
        void heapify() {
            for (int i = (size >>> 1) - 1; i >= 0; i--) sift_down(i);
        }
        Heap (int capacity, int[] a) {
            this.capacity = capacity;
            heap = new int[capacity];
            this.size = Integer.min(capacity, a.length);
            for (int j = 0; j < size; j++) heap[j] = a[j];
            heapify();
            for (int j = size; j < a.length; j++) offer(a[j]);
        }
        Heap (int capacity) {
            this.capacity = capacity;
            this.size = 0;
            heap = new int[capacity];
        }
        private void swap(int i, int j) {
            int t = heap[i];
            heap[i] = heap[j];
            heap[j] = t;
        }
        private void sift_up(int index) {
            while (index > 0) {
                int parent = (index - 1)/2;
                if (heap[parent] < heap[index]) break;
                swap(parent, index);
                index = parent;
            }
        }
        private void sift_down(int index) {
            int child = 2*index + 1;
            while (child < size) {
                if (child + 1 < size && heap[child + 1] < heap[child]) child += 1;
                if (heap[index] < heap[child]) break;
                swap(index, child);
                index = child;
                child = 2*index + 1;
            }
        }
        public void offer(int value) {
            if (size < capacity) {
                heap[size] = value;
                sift_up(size);
                size++;
            }
            else if (heap[0] < value) {
                heap[0] = value;
                sift_down(0);
            }
        }
        public int peek() {
            return heap[0];
        }
    }
    Heap heap;
    public KthLargest(int k, int[] nums) {
       heap = new Heap(k, nums);
    }
    public int add(int val) {
        heap.offer(val);
        return heap.peek();
    }
}
