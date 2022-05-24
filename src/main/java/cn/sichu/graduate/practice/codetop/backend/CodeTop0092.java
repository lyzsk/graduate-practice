package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0092 {
    private int maxIndex;
    private int size;

    public boolean isCompleteTree(TreeNode root) {
        dfs(root, 1);
        return maxIndex == size;
    }

    private void dfs(TreeNode root, int startIndex) {
        if (root == null) {
            return;
        }
        if (startIndex > maxIndex) {
            maxIndex = startIndex;
        }
        ++size;
        dfs(root.left, 2 * startIndex);
        dfs(root.right, 2 * startIndex + 1);
    }
}
