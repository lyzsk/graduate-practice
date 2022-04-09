package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 
 * @author sichu
 * @date 2022/04/08
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;

        for (int i = 0; i < nums.length; i++) {
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
