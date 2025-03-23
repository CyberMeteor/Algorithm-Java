//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// Can you solve it without sorting? 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// 
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
//Quickselect 👍 17740 👎 930

package com.alex.leetcode.editor.en;
class kthLargestElementInAnArray{
    //2025-03-22 21:29:41
    //Kth Largest Element in an Array
    //QuestionID：[215]
    
    public static void main(String[] args) {
        Solution solution = new kthLargestElementInAnArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int target = nums.length - k;
        while (low <= high) {
            int pivot = partition(nums, low, high);
            if (pivot == target) {
                return nums[pivot];
            } else if (pivot < target) {
                low = pivot + 1;
            }  else {
                high = pivot - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int left = low + 1;
        int right = high;
        while (left <= right) {
            if (nums[left] > pivot && nums[right] < pivot) swap(nums, left, right);
            if (nums[left] <= pivot) left++;
            if (nums[right] >= pivot) right--;
        }
        swap(nums, low, right);
        return right;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
