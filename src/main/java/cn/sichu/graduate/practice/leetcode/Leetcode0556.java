package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/07/02
 */
public class Leetcode0556 {
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }

        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        long ans = Long.parseLong(new String(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }

    private static void swap(char[] nums, int left, int right) {
        char tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private static void reverse(char[] nums, int startIndex) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
