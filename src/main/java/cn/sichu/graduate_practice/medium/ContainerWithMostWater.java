package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 
 * @author sichu
 * @date 2022/04/27
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int res = 0;

        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(area, res);

            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return res;
    }

}
