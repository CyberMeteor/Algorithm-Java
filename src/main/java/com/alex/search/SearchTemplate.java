package com.alex.search;

public class SearchTemplate {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (right -left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid;
                continue;
            }
            right = mid;
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}
