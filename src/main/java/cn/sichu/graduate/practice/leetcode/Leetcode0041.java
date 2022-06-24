package cn.sichu.graduate.practice.leetcode;

/**
 * 因为有用例 [1,1]， 所以一定要写成 nums[nums[i] - 1] != nums[i]
 * <p>
 * 而不能写成 i != nums[i] - 1
 * 
 * @author sichu
 * @date 2022/06/24
 */
public class Leetcode0041 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
