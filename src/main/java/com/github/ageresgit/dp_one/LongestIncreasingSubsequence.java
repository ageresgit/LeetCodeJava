package com.github.ageresgit.dp_one;

public class LongestIncreasingSubsequence {
    int countIncreasing(int[] nums, int[] dp, int startPosition) {
        int best = 0;
        for (int idx = startPosition + 1; idx < nums.length; idx++) {
            if (nums[startPosition] < nums[idx]) {
                if (nums[startPosition] + 1 == nums[idx]) return (1 + dp[idx]);
                best = Integer.max(best, dp[idx] + 1);
            }
            else if (nums[startPosition] == nums[idx]) return dp[idx];
        }
        return best;
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int length = nums.length;
        if (length < 2) return length;
        int max = nums[length - 1], min = nums[length - 1], record = 0;
        int dp[] = new int[length];
        dp[length - 1] = 0;
        for (int index = length - 2; index >= 0; index--) {
            if (nums[index] >= max) {
                max = nums[index];
                dp[index] = 0;
            }
            else if (nums[index] < min) {
                min = nums[index];
                dp[index] = (record + 1);
            }
            else dp[index] = countIncreasing(nums, dp, index);
            record = Integer.max(record, dp[index]);
        }
        return (record + 1);
    }
}
