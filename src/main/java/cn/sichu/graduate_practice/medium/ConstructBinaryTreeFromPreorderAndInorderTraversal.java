package cn.sichu.graduate_practice.medium;

import java.util.HashMap;
import java.util.Map;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * offer link: {@link cn.sichu.graduate_practice.offer.Offer07}
 * <p>
 * similar: {@link cn.sichu.graduate_practice.medium.ConstructBinaryTreeFromInorderAndPostorderTraversal}
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pre = preorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int inLeft, int inRight, int preLeft, int preRight) {
        if (inRight < inLeft || preRight < preLeft) {
            return null;
        }
        int root = pre[preLeft];
        int rootIdx = map.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(inLeft, rootIdx - 1, preLeft + 1, preLeft + rootIdx - inLeft);
        node.right = buildTree(rootIdx + 1, inRight, preLeft + rootIdx - inLeft + 1, preRight);
        return node;
    }
}
