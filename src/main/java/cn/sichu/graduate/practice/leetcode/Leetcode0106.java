package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/30
 */
public class Leetcode0106 {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int root = post[postRight];
        int rootIdx = map.get(root);
        TreeNode node = new TreeNode(root);
        node.left = buildTree(inLeft, rootIdx - 1, postLeft, postLeft + rootIdx - inLeft - 1);
        node.right = buildTree(rootIdx + 1, inRight, postLeft + rootIdx - inLeft, postRight - 1);
        return node;
    }
}
