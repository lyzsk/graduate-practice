package cn.sichu.graduate_practice.codetop;

/**
 * 频率29
 * <p>
 * https://leetcode.cn/problems/trapping-rain-water/
 * 
 * @author sichu
 * @date 2022/05/08
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                res += leftMax - height[left];
                ++left;
            } else {
                res += rightMax - height[right];
                --right;
            }
        }
        return res;
    }
}
