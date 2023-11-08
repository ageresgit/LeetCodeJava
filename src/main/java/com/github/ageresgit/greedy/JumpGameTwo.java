package com.github.ageresgit.greedy;

public class JumpGameTwo {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int jumps = 1, cur = 0, next = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            next = Integer.max(next, idx + nums[idx]);
            if (next >= nums.length - 1) return jumps;
            if (idx == cur) {
                if (next <= cur) return -1;
                cur = next;
                jumps++;
            }
        }
        return jumps;
    }
}
