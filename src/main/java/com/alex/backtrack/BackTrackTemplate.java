package com.alex.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTrackTemplate {
    // Subset
    private void backtrack(int[] nums, int start, LinkedList<Integer> currentSubset, List<List<Integer>> result){
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backtrack(nums, i + 1, currentSubset, result);
            currentSubset.removeLast();
        }
    }

    // Permutations
    private void backtrack(int[] nums, boolean[] used, LinkedList<Integer> currentPermutation, List<List<Integer>> result){
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            currentPermutation.add(nums[i]);

            backtrack(nums, used, currentPermutation, result);

            currentPermutation.removeLast();
            used[i] = false;
        }
    }

    // Combination
    private void backtrack(int n, int target, int start, LinkedList<Integer> currentCombination, List<List<Integer>> result){
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < n; i++) {
            if (currentCombination.get(i) > target) break;

            currentCombination.add(i);
            backtrack(n, target, i + 1, currentCombination, result);
            currentCombination.removeLast();
        }
    }
}
