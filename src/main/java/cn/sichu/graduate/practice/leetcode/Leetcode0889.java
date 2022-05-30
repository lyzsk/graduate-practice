package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/30
 */
public class Leetcode0889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return dfs(preorder, postorder);
    }

    private static TreeNode dfs(int[] preorder, int[] postorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode node = new TreeNode(preorder[0]);
        for (int i = 0; i < postorder.length; i++) {
            if (preorder[1] == postorder[i]) {
                int leftCount = i + 1;
                int[] preLeft = Arrays.copyOfRange(preorder, 1, leftCount + 1);
                int[] preRight = Arrays.copyOfRange(preorder, leftCount + 1, preorder.length);
                int[] postLeft = Arrays.copyOfRange(postorder, 0, leftCount);
                int[] postRight = Arrays.copyOfRange(postorder, leftCount, preorder.length - 1);
                node.left = dfs(preLeft, postLeft);
                node.right = dfs(preRight, postRight);
                break;
            }
        }
        return node;
    }
}
