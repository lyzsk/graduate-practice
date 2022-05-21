package cn.sichu.graduate.practice.codetop.backend;

public class CodeTop0026 {
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
