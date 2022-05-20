package cn.sichu.graduate_practice;

import java.util.HashMap;
import java.util.Map;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * 频率54
 * <p>
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // pre: 中左右
        // in: 左中右
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.pre = preorder;
        return buildTree(0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int inLeft, int inRight, int preLeft, int preRight) {
        if (inRight < inLeft || preRight < preLeft) {
            return null;
        }
        int root = pre[preLeft];
        int rootIdx = map.get(root);

        TreeNode res = new TreeNode(root);
        res.left = buildTree(inLeft, rootIdx - 1, preLeft + 1, preLeft + rootIdx - inLeft);
        res.right = buildTree(rootIdx + 1, inRight, preLeft + rootIdx - inLeft + 1, preRight);
        return res;
    }
}
