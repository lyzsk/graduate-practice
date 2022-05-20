package cn.sichu.graduate_practice.medium;

import java.util.Random;

/**
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int mid = quickSelect(nums, 0, nums.length - 1, nums.length >> 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - mid);
        }
        return res;
    }

    private static int quickSelect(int[] nums, int left, int right, int index) {
        if (left >= right) {
            return nums[index];
        }
        int pos = randomPartition(nums, left, right);
        if (pos == index) {
            return nums[pos];
        } else {
            return pos < index ? quickSelect(nums, pos + 1, right, index) : quickSelect(nums, left, pos - 1, index);
        }
    }

    private static int randomPartition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return parition(nums, left, right);
    }

    private static int parition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++i;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
