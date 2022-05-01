package cn.sichu.graduate_practice.sort;

import java.util.Arrays;

/**
 * 选择排序，O(n<sup>2</sup>), O(1)
 * <p>
 * 选择排序是一种不稳定的排序算法。选择排序每次都要找剩余未排序元素中的最小值，并和前面的元素交换位置，这样破坏了稳定性。
 * <p>
 * 比如 5，8，5，2，9 这样一组数据，使用选择排序算法来排序的话，第一次找到最小元素 2，与第一个 5 交换位置，那第一个 5 和中间的 5 顺序就变了，所以就不稳定了。正是因此，相对于冒泡排序和插入排序，选择排序就稍微逊色了。
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class SelectionSort {
    /**
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
     * <p>
     * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     * 
     * @param nums
     */
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
