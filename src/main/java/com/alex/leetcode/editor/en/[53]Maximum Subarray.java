//Given an integer array nums, find the subarray with the largest sum, and 
//return its sum. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
//
// Related Topics Array Divide and Conquer Dynamic Programming 👍 35390 👎 1500

package com.alex.leetcode.editor.en;
class maximumSubarray{
    //2025-03-25 21:18:24
    //Maximum Subarray
    //QuestionID：[53]
    
    public static void main(String[] args) {
        Solution solution = new maximumSubarray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for (int x : nums) {
            preSum += x;
            ans = Math.max(ans, preSum -  minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
