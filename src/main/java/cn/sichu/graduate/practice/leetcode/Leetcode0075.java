package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/06/25
 */
public class Leetcode0075 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                ++p1;
            } else if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if (p0 < p1) {
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                ++p0;
                ++p1;
            }
        }
    }
}
