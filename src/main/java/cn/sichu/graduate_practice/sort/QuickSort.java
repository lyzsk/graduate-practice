package cn.sichu.graduate_practice.sort;

import java.util.Arrays;

/**
 * 快速排序，平均O(nlogn)，最坏情况O(n<sup>2</sup>)
 * <p>
 * 快速排序，越无序越快，不需要额外空间，不稳定排序
 * <p>
 * Arrays.sort(),大于47或小于286进入快排，
 * <p>
 * 小于47，用的插入排序
 * <p>
 * 大于286后会先看一下是否nearly sorted，是的话进入归并排序，否则继续快排
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class QuickSort {
    /**
     * 快速排序也采用了分治的思想：把原始的数组筛选成较小和较大的两个子数组，然后递归地排序两个子数组。
     * 
     * @param nums
     * @param left
     * @param right
     */
    private static void quickSort(int[] nums, int left, int right) {
        // if (left >= right) {
        // return;
        // }
        // int i = left - 1;
        // int j = right + 1;
        // int x = nums[left];
        // while (i < j) {
        // while (nums[++i] < x);
        // while (nums[--j] > x);
        // if (i < j) {
        // int tmp = nums[i];
        // nums[i] = nums[j];
        // nums[j] = tmp;
        // }
        // }
        // quickSort(nums, left, j);
        // quickSort(nums, j + 1, right);
        if (left >= right) {
            return;
        }
        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] >= base && i < j) {
                --j;
            }
            while (nums[i] <= base && i < j) {
                ++i;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[left] = nums[i];
        nums[i] = base;
        quickSort(nums, left, i - 1);
        quickSort(nums, j + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
