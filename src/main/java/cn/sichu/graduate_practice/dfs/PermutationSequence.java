package cn.sichu.graduate_practice.dfs;

/**
 * https://leetcode.cn/problems/permutation-sequence/
 * 
 * @author sichu
 * @date 2022/05/16
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorial = calculateFactorial(n);
        boolean[] used = new boolean[n + 1];
        StringBuilder path = new StringBuilder();
        backtrack(path, factorial, used, n, k, 0);
        return path.toString();
    }

    private static void backtrack(StringBuilder path, int[] factorial, boolean[] used, int n, int k, int startIndex) {
        if (startIndex == n) {
            return;
        }
        // 全排列的个数
        int count = factorial[n - 1 - startIndex];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (count < k) {
                k -= count;
                continue;
            }
            path.append(i);
            used[i] = true;
            backtrack(path, factorial, used, n, k, startIndex + 1);
            // 不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    private static int[] calculateFactorial(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i - 1] * i;
        }
        return res;
    }
}
