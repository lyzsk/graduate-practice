package cn.sichu.graduate_practice.codetop.yuanfudao.backend;

import java.util.Random;

/**
 * backend 频率1
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 
 * @author sichu
 * @date 2022/05/04
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // 第 k 大， sort从小到大， 下标 nums.length - k
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
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
        return partition(nums, left, right);
    }

    private static int partition(int[] nums, int left, int right) {
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
