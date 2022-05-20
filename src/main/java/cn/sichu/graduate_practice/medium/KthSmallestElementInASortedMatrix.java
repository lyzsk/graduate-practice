package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = 0;
        int j = n - 1;
        int res = 0;
        while (i < n && j >= 0) {
            if (matrix[i][j] <= mid) {
                res += j + 1;
                ++i;
            } else {
                --j;
            }
        }
        return res >= k;
    }
}
