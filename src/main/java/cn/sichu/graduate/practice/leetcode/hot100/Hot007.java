package cn.sichu.graduate.practice.leetcode.hot100;

/**
 * 
 * @author sichu
 * @date 2022/06/09
 */
public class Hot007 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int res = 0;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return res;
    }
}
