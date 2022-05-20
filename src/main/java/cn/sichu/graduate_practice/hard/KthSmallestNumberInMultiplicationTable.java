package cn.sichu.graduate_practice.hard;

/**
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class KthSmallestNumberInMultiplicationTable {
    /**
     * 意思是，小于等于 mid 的数字有 count(m, n, mid) 个
     * <p>
     * 当不符合要求时，即 count(m, n, mid) < k， left 右移，结束循环
     * <p>
     * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/solution/by-fuxuemingzhu-8eq4/
     * 
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (count(m, n, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 统计乘法表中有多少个小于等于 k 的数目
     * 
     * @param m
     * @param n
     * @param k
     * @return
     */
    private static int count(int m, int n, int k) {
        int res = 0;
        // 每行小于等于 k 的数目
        for (int i = 1; i <= m; i++) {
            res += Math.min(k / i, n);
        }
        return res;
    }
}
