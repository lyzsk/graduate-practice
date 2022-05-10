package cn.sichu.graduate_practice.codetop;

/**
 * 频率49
 * <p>
 * https://leetcode.cn/problems/next-permutation/
 * 
 * @author sichu
 * @date 2022/05/10
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int fast = nums.length - 1; fast >= 0; fast--) {
            for (int slow = nums.length - 1; slow > fast; slow--) {
                if (nums[fast] < nums[slow]) {
                    swap(nums, fast, slow);
                    reverse(nums, fast + 1);
                    return;
                }
            }
        }
        reverse(nums, 0);
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private void reverse(int[] nums, int startIndex) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
