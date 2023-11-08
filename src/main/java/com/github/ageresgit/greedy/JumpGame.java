package com.github.ageresgit.greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int last = 0;
        for (int index = 0; index <= last; index++) {
            last = Integer.max(last, index + nums[index]);
            if (last >= nums.length - 1) return true;
        }
        return false;
    }
    public boolean canJumpDp(int[] nums) {
        int distance = 0;
        for (int index = nums.length - 1; index >= 0; index--) {
            if (nums[index] >= distance) distance = 1;
            else distance++;
        }
        return (distance <= 1);
    }
}
