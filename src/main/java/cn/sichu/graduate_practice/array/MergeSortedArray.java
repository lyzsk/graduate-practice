package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/merge-sorted-array/">88. 合并两个有序数组</a>
 * @see <a href = "https://leetcode.com/problems/merge-sorted-array/">88. Merge Sorted Array</a>
 * @author sichu
 * @date 2022/03/18
 */
public class MergeSortedArray {
    /**
     * 逆向双指针 Time Complexity: O(m+n),指针单调递减，最多移动m+n次
     * <p>
     * Space Complexity: O(1，)仅对nums1原地修改， 不需要额外空间储存新数组。
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeSolution1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                --k;
                --i;
            } else {
                nums1[k] = nums2[j];
                --k;
                --j;
            }
        }
    }

    public void mergeSolution2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[k] = nums2[j];
                --k;
                --j;
            } else if (j == -1) {
                nums1[k] = nums1[i];
                --k;
                --i;
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                --k;
                --i;
            } else {
                nums1[k] = nums2[j];
                --k;
                --j;
            }
        }
    }
}
