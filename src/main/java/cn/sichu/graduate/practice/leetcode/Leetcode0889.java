package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/30
 */
public class Leetcode0889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] postorder, int postLeft,
        int postRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight) {
            return node;
        }
        int index = 0;
        for (int i = postLeft; i <= postRight; i++) {
            if (postorder[i] == preorder[preLeft + 1]) {
                index = i;
                break;
            }
        }
        node.left = buildTree(preorder, preLeft + 1, preLeft + 1 + index - postLeft, postorder, postLeft, index);
        node.right =
            buildTree(preorder, preLeft + 1 + index - postLeft + 1, preRight, postorder, index + 1, postRight - 1);
        return node;
    }
}
