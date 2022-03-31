package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class MergeSortedArray {
    /**
     * O(m + n)
     * <p>
     * O(1)
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
