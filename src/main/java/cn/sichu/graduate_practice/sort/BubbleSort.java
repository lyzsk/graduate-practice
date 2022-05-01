package cn.sichu.graduate_practice.sort;

import java.util.Arrays;

/**
 * 冒泡排序，O(n<sup>2</sup>), O(1)
 * <p>
 * 分情况讨论
 * <p>
 * 1. 给定数组已经排序好: 只需要进行 n - 1 次比较，两两交换次数为0，时间复杂度为O(n), 这是最好情况
 * <p>
 * 2. 给定数组逆序排列： 需要 n*(n-1)/2 次比较，时间复杂度为O(n<sup>2</sup>)，这是最坏情况
 * <p>
 * 3. 杂乱无章，平均时间复杂度O(n<sup>2</sup>)
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class BubbleSort {
    /**
     * 定义一个布尔变量 hasChange，用来标记每轮是否进行了交换。在每轮遍历开始时，将 hasChange 设置为 false。
     * <p>
     * 若当轮没有发生交换，说明此时数组已经按照升序排列，hashChange 依然是为 false。此时外层循环直接退出，排序结束。
     * 
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
        boolean hasChange = true;
        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    hasChange = true;
                }
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
