//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics Two Pointers String Dynamic Programming 👍 30507 👎 1880

package com.alex.leetcode.editor.en;

import java.util.Arrays;

class longestPalindromicSubstring{
    //2025-03-27 15:35:21
    //Longest Palindromic Substring
    //QuestionID：[5]
    
    public static void main(String[] args) {
        Solution solution = new longestPalindromicSubstring().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] t = new char[n * 2 + 3];
        Arrays.fill(t, '#');
        t[0] = '^';
        for (int i = 0; i < n; i++) {
            t[i * 2 + 2] =  s.charAt(i);
        }
        t[n * 2 + 2] = '$';

        int[] halfLen = new int[t.length - 2];
        halfLen[1] = 1;

        int maxI = 0;
        int boxM = 0;
        int boxR = 0;
        for (int i = 2; i < halfLen.length; i++) {
            int hl = 1;
            if (i < boxR) {
                hl = Math.min(halfLen[boxM * 2 - i], boxR - i);
            }

            while (t[i -  hl] == t[i + hl]) {
                hl++;
                boxM = i;
                boxR = i + hl;
            }

            halfLen[i] = hl;
            if (hl > halfLen[maxI]) {
                maxI = i;
            }
        }

        int hl = halfLen[maxI];
        return s.substring((maxI - hl) / 2, (maxI + hl) / 2 - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
