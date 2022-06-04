package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/06/03
 */
public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int res = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < s.length()) {
            sum += diff[right];
            while (sum > maxCost) {
                sum -= diff[left];
                ++left;
            }
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }
}
