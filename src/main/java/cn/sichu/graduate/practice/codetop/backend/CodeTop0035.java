package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class CodeTop0035 {
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

    private void reverse(int[] nums, int startIdx) {
        int left = startIdx;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
