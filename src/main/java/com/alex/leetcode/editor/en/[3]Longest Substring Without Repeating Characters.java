//Given a string s, find the length of the longest substring without duplicate 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 41501 👎 2005

package com.alex.leetcode.editor.en;

import java.util.HashMap;

class longestSubstringWithoutRepeatingCharacters{
    //2025-03-20 20:09:08
    //Longest Substring Without Repeating Characters
    //QuestionID：[3]
    
    public static void main(String[] args) {
        Solution solution = new longestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
