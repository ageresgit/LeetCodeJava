package com.github.ageresgit.heap;

public class KthLargestQuickSelect {
    //leetcode # 215 Element in an Array
    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length;
        while (left < right - 1) {
            int pivot = nums[left];
            int divide = left;
            for (int i = left + 1; i < right; i++) {
                if (nums[i] > pivot) {
                    divide++;
                    swap(nums, i, divide);
                }
            }
            swap(nums, divide, left);
            if (divide == k - 1) return nums[divide];
            if (divide < k - 1) left = divide + 1;
            else right = divide;
        }
        return nums[left];
    }
}
