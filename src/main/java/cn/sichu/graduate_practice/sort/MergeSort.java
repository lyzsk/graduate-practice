package cn.sichu.graduate_practice.sort;

import java.util.Arrays;

/**
 * 归并排序 O(nlogn)
 * <p>
 * 
 * @author sichu
 * @date 2022/05/01
 */
public class MergeSort {
    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        int[] tmp = new int[nums.length];
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            // if (nums[i] <= nums[j]) {
            // tmp[k++] = nums[i++];
            // } else {
            // tmp[k++] = nums[j++];
            // }
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (i = left, j = 0; i <= right; i++, j++) {
            nums[i] = tmp[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
