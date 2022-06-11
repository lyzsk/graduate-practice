package cn.sichu.graduate.practice.leetcode.tencent50;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent07 {
    public int maxArea(int[] height) {
        int res = 0;
        int area = 0;
        int left = 0;
        int right = height.length - 1;
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
