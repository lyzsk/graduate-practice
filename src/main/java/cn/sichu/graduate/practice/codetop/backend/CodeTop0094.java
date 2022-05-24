package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0094 {
    private int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k] = nums[i];
                ++i;
                ++k;
            } else {
                tmp[k] = nums[j];
                ++j;
                ++k;
            }
        }
        while (i <= mid) {
            tmp[k] = nums[i];
            ++i;
            ++k;
        }
        while (j <= right) {
            tmp[k] = nums[j];
            ++j;
            ++k;
        }
        for (i = left, j = 0; i <= right; i++, j++) {
            nums[i] = tmp[j];
        }
    }
}
