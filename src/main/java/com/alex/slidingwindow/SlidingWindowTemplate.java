package com.alex.slidingwindow;

public class SlidingWindowTemplate {
    public int slidingWindow(int[] nums, int k) {
        int left = 0, right = 0;
        int sum = 0;
        int result = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (right - left + 1 > k) {
                sum -= nums[left];
                left++;
            }

            if (right - left + 1 == k) {
                result = Math.max(result, sum);
            }

            right++;
        }

        return result;
    }
}
