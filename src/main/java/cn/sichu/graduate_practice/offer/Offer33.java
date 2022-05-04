package cn.sichu.graduate_practice.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * 
 * @author sichu
 * @date 2022/05/04
 */
public class Offer33 {
    /**
     * 后序： 左右中
     * <p>
     * 二叉搜索树: 左 < 根 < 右
     * 
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peekLast() > postorder[i]) {
                root = stack.removeLast();
            }
            stack.addLast(postorder[i]);
        }
        return true;
    }

    /**
     * O(n<sup>2</sup>)，但是跑起来更快
     * 
     * @param postorder
     * @return
     */
    public boolean verifyPostorderSolution2(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    private static boolean dfs(int[] postorder, int i, int j) {
        // i >= j, 说明 子树节点数量 < 1
        if (i >= j) {
            return true;
        }
        // [i, idx - 1] 内所有节点都 < postorder[j]，即根节点
        // [idx, j - 1] 内所有节点都 > postorder[j]
        int p = i;
        while (postorder[p] < postorder[j]) {
            ++p;
        }
        int idx = p;
        while (postorder[p] > postorder[j]) {
            ++p;
        }
        return p == j && dfs(postorder, i, idx - 1) && dfs(postorder, idx, j - 1);
    }
}
