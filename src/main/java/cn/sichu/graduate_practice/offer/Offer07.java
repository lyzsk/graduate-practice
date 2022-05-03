package cn.sichu.graduate_practice.offer;

import java.util.HashMap;
import java.util.Map;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * <p>
 * same: {@link cn.sichu.graduate_practice.medium.ConstructBinaryTreeFromPreorderAndInorderTraversal}
 * 
 * @author sichu
 * @date 2022/04/17
 */
public class Offer07 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }

        int root = pre[preLeft];
        int rootIdx = map.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(inLeft, rootIdx - 1, preLeft + 1, preLeft + rootIdx - inLeft);
        node.right = buildTree(rootIdx + 1, inRight, preLeft + rootIdx - inLeft + 1, preRight);
        return node;
    }

    // Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    // int[] preorder;
    //
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    // this.preorder = preorder;
    // for (int i = 0; i < preorder.length; i++) {
    // inorderMap.put(inorder[i], i);
    // }
    // return recursive(0, 0, inorder.length - 1);
    // }
    //
    // private TreeNode recursive(int root, int left, int right) {
    // if (left > right) {
    // return null;
    // }
    // TreeNode node = new TreeNode(preorder[root]);
    // int i = inorderMap.get(preorder[root]);
    // node.left = recursive(root + 1, left, i - 1);
    // node.right = recursive(root + (i - left) + 1, i + 1, right);
    // return node;
    // }

}
