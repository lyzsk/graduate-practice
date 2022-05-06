package cn.sichu.graduate_practice.codetop;

/**
 * 频率20
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * @author sichu
 * @date 2022/05/06
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int cur = m + n - 1;

        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[cur] = nums2[j];
                --cur;
                --j;
            } else if (j == -1) {
                nums1[cur] = nums1[i];
                --cur;
                --i;
            } else if (nums1[i] > nums2[j]) {
                nums1[cur] = nums1[i];
                --cur;
                --i;
            } else {
                nums1[cur] = nums2[j];
                --cur;
                --j;
            }
        }
    }
}
