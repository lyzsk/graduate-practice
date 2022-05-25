package cn.sichu.graduate.practice.leetcode;

/**
 * 4 -> 5 -> 2 -> 6 -> 3 -> 1 找到的符合条件的一对「较小数」与「较大数」, 满足「较小数」尽量靠右，而「较大数」尽可能小。
 * <p>
 * 4 -> 5 -> 3 -> 6 -> 2 -> 1 => 4 -> 5 -> 3 -> 1 -> 2 -> 6 swap + reverse 重排「较小数」右边的序列
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0031 {
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

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private static void reverse(int[] nums, int startIndex) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
