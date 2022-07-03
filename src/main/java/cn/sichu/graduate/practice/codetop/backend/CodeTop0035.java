package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class CodeTop0035 {
    // public void nextPermutation(int[] nums) {
    // for (int fast = nums.length - 1; fast >= 0; fast--) {
    // for (int slow = nums.length - 1; slow > fast; slow--) {
    // if (nums[fast] < nums[slow]) {
    // swap(nums, fast, slow);
    // reverse(nums, fast + 1);
    // return;
    // }
    // }
    // }
    // reverse(nums, 0);
    // }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private static void reverse(int[] nums, int startIdx) {
        int left = startIdx;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
