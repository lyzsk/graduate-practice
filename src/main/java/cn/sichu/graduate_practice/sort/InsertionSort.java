package cn.sichu.graduate_practice.sort;

import java.util.Arrays;

/**
 * 插入排序，O(n<sup>2</sup>), O(1)
 * <p>
 * 分情况讨论
 * <p>
 * 1. 给定数组已经排序好: 只需要进行 n - 1 次比较，两两交换次数为0，时间复杂度为O(n), 这是最好情况
 * <p>
 * 2. 给定数组逆序排列： 需要 n*(n-1)/2 次比较，时间复杂度为O(n<sup>2</sup>)，这是最坏情况
 * <p>
 * 3. 杂乱无章，平均时间复杂度O(n<sup>2</sup>)
 * <p>
 * 与冒泡排序对比：
 * <p>
 * 在冒泡排序中，经过每一轮的排序处理后，数组后端的数是排好序的。
 * <p>
 * 在插入排序中，经过每一轮的排序处理后，数组前端的数是排好序的。
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class InsertionSort {
    /**
     * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
     * <p>
     * 初始已排序区间只有一个元素，就是数组的第一个元素。
     * <p>
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * <p>
     * 重复这个过程，直到未排序区间中元素为空，算法结束。
     * 
     * @param nums
     */
    private static void insertionSort(int[] nums) {
        for (int i = 1, j; i < nums.length; i++) {
            int num = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > num; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
