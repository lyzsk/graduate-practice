package cn.sichu.graduate.practice.leetcode.offer;

/**
 * @author sichu
 * @date 2022/06/20
 */
public class Offer51 {
    private int count;

    public int reversePairs(int[] nums) {
        this.count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int p = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[p] = nums[i];
                ++p;
                ++i;
            } else {
                count += mid - i + 1;
                tmp[p] = nums[j];
                ++p;
                ++j;
            }
        }
        while (i <= mid) {
            tmp[p] = nums[i];
            ++p;
            ++i;
        }
        while (j <= right) {
            tmp[p] = nums[j];
            ++p;
            ++j;
        }
        for (int k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }
}
