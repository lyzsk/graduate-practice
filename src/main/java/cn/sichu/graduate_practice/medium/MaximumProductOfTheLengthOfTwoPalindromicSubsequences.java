package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences {
    /**
     * O(m<sup>2</sup>)枚举
     * 
     * @param s
     * @return
     */
    public int maxProduct(String s) {
        int n = s.length();
        // m 代表状态数
        int m = 1 << n;
        List<int[]> list = new ArrayList<int[]>();
        char[] arr = s.toCharArray();

        // 记录所有合法状态的信息
        for (int i = 1; i < m; i++) {
            if (check(arr, i)) {
                list.add(new int[] {i, Integer.bitCount(i)});
            }
        }

        int[][] array = list.toArray(new int[0][0]);
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            int x = array[i][0];
            int xLen = array[i][1];
            for (int j = i + 1; j < array.length; j++) {
                int y = array[j][0];
                int yLen = array[j][1];
                // 状态之间没有字符相交，满足题意
                if ((x & y) == 0) {
                    res = Math.max(res, xLen * yLen);
                }
            }
        }
        return res;
    }

    private static boolean check(char[] arr, int state) {
        int left = 0;
        int right = arr.length - 1;
        // 检查state对应的子序列是否为回文串
        while (left < right) {
            while (left < right && (state >> left & 1) == 0) {
                ++left;
            }
            while (left < right && (state >> right & 1) == 0) {
                --right;
            }
            if (arr[left] != arr[right]) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
