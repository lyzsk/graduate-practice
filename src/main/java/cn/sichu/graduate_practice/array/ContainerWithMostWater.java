package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/container-with-most-water/">11. 盛最多水的容器</a>
 * @see <a href = "https://leetcode.com/problems/container-with-most-water/">11. Container With Most Water</a>
 * 
 * @author sichu
 * @date 2022/03/16
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height != null) {
            int left = 0;
            int right = height.length - 1;
            int area;
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
        } else {
            throw new IllegalArgumentException("height array can't be null");
        }
    }
}
