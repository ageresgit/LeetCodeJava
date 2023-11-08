package com.github.ageresgit.dp_one;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int max = nums[0];
        int prevMin = max, prevMax = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = prevMin;
                prevMin = prevMax;
                prevMax = t;
            }
            prevMin = Integer.min(nums[i], prevMin * nums[i]);
            prevMax = Integer.max(nums[i], prevMax * nums[i]);
            max = Integer.max(prevMax, max);
        }

        return max;
    }
}
