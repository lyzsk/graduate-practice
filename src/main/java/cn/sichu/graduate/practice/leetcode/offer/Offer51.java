package cn.sichu.graduate.practice.leetcode.offer;

/**
 * @author sichu
 * @date 2022/06/20
 */
public class Offer51 {
    private int[] nums;
    private int[] tmp;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        this.tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) >> 1;
        int res = mergeSort(left, mid) + mergeSort(mid + 1, right);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            tmp[k] = nums[k];
        }
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = tmp[j];
                ++j;
            } else if (j == right + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                ++i;
            } else {
                nums[k] = tmp[j];
                ++j;
                res += mid - i + 1;
            }
        }
        return res;
    }
}
