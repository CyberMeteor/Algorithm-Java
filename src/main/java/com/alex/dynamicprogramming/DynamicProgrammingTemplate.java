package com.alex.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;

public class DynamicProgrammingTemplate {

    // DFS
    private int dfs(int x, int y, List<List<Integer>> triangle, int[][] saves) {
        if (x == triangle.size() - 1) {
            return triangle.get(x).get(y);
        }
        if (saves[x][y] != 0) {
            return saves[x][y];
        }
        int minLeft = dfs(x + 1, y, triangle, saves);
        int minRight = dfs(x + 1, y + 1, triangle, saves);

        saves[x][y] = Math.min(minLeft, minRight) + triangle.get(x).get(y);
        return saves[x][y];
    }

    // DP - Bottom to Top
    public int minimumTotal(LinkedList<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[triangle.size() - 1][i] = triangle.getLast().get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    // DP - Top to Bottom
    public int minimumTotal1(LinkedList<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int minValue = dp[triangle.size() - 1][0];
        for (int i = 0; i <= triangle.size(); i++) {
            minValue = Math.min(minValue, dp[triangle.size() - 1][i]);
        }
        return minValue;
    }

    // DP - Space Optimized
    public int minimumTotal2(LinkedList<List<Integer>> triangle) {
        int[] dp =  new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.getLast().get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}
