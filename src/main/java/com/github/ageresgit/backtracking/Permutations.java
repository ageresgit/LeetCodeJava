package com.github.ageresgit.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private void permutations(List<List<Integer>> list, int[] nums, int[] perm, boolean[] taken, int level) {
        if (level == perm.length) {
            var next = new ArrayList<Integer>();
            for (int i = 0; i < perm.length; i++) {
                next.add(nums[perm[i]]);
            }
            list.add(next);
        }
        for (int i = 0; i < taken.length; i++) {
            if (!taken[i]) {
                taken[i] = true;
                perm[level] = i;
                permutations(list, nums, perm, taken, level + 1);
                taken[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        var list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return list;
        int[] perm = new int[nums.length];
        boolean[] taken = new boolean[nums.length];
        permutations(list, nums, perm, taken, 0);
        return list;
    }
}
