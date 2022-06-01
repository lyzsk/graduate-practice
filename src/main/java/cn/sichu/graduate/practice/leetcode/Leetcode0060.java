package cn.sichu.graduate.practice.leetcode;

/**
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * 
 * @author sichu
 * @date 2022/05/31
 */
public class Leetcode0060 {
    /**
     * 核心思路是 回溯全排列， 使用count计数到第k个全排列返回
     * <p>
     * 即 count = factorial[n - 1 - depth]; 判断当 count < k 时， k -= count, continue， 这其实就是一个剪枝的过程，代替了backtrack后剪枝:
     * <ul>
     * <li>意思是： 如果 kk 大于这一个分支将要产生的叶子结点数，直接跳过这个分支</li>
     * <li>如果 k 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解。</li>
     * </ul>
     * <p>
     * 但是要注意的是，进入循环体后，backtrack后，不可以回头， 因为时直接到达了第 k 个全排列，即叶子节点，不需要回头，直接return不去尝试遍历后面的数
     * <p>
     * 计算阶乘 factorial 的时候， 0! = 1; 表示没有数可选的时候，即到达叶子节点了，排列数只剩下1个
     * <p>
     * 因为题目 n的范围是[1,9], 所以可以直接把 factorial 计算好，放在数组里，根据索引取得阶乘的值
     * 
     * @param n
     * @param k
     * @return path.toString()
     */
    public String getPermutation(int n, int k) {
        int[] factorial = calculateFactorial(n);
        boolean[] used = new boolean[n + 1];
        StringBuilder path = new StringBuilder();
        backtrack(path, factorial, used, n, k, 0);
        return path.toString();
    }

    private static void backtrack(StringBuilder path, int[] factorial, boolean[] used, int n, int k, int depth) {
        if (depth == n) {
            return;
        }
        int count = factorial[n - 1 - depth];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (count < k) {
                k -= count;
                continue;
            }
            used[i] = true;
            path.append(i);
            backtrack(path, factorial, used, n, k, depth + 1);
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
