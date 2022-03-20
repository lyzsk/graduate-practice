package cn.sichu.graduate_practice.array;

import java.util.Arrays;

/**
 * @see <a href = "https://leetcode-cn.com/problems/next-permutation/">31. 下一个排列</a>
 * @see <a href = "https://leetcode.com/problems/next-permutation/">31. Next Permutation</a>
 * @author sichu
 * @date 2022/03/19
 */
public class NextPermutation {
    /**
     * 1. 从后往前，找到第一对，前小(nums[i])后大(nums[j])的数， swap 这两个数
     * <p>
     * 2. 因为nums[i] < nums[j]， 所以交换后，原先i位置后的元素都大于nums[j]，所以新的nums[i+1]到nums[j]是降序的，需要重新按照升序排序
     * 
     * @param nums
     */
    public void nextPermutationSolution1(int[] nums) {
        for (int fast = nums.length - 1; fast >= 0; fast--) {
            for (int slow = nums.length - 1; slow > fast; slow--) {
                if (nums[fast] < nums[slow]) {
                    swap(nums, fast, slow);
                    Arrays.sort(nums, fast + 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    /**
     * 优化: 不用Arrays.sort,因为需要 O(nlogn) 来排序
     * <p>
     * 改用： reverse()函数，因为 fast 位置后， 即找到的第一个 较小数 后，必然是降序，用双指针遍历一遍交换位置即可，最终节省时间至 O(n)
     * 
     * @param nums
     */
    public void nextPermutationSolution2(int[] nums) {
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
