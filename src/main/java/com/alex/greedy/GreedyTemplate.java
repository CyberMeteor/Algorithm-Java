package com.alex.greedy;

import java.util.Arrays;

public class GreedyTemplate {
    public boolean canJump(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLen) return false;
            maxLen = Math.max(maxLen, i + nums[i]);
        }
        return true;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int p = 0;
        int q = 0;
        while (p < g.length && q < s.length) {
            if (g[p] > s[q]) {
                p++;
            }
            q++;
        }
        return p;
    }
}
