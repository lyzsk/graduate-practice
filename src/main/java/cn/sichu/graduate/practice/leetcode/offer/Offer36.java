package cn.sichu.graduate.practice.leetcode.offer;

import cn.sichu.graduate.practice.leetcode.utils.Node2;

/**
 * 
 * @author sichu
 * @date 2022/06/04
 */
public class Offer36 {
    private Node2 head;
    private Node2 tail;

    public Node2 treeToDoublyList(Node2 root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void dfs(Node2 root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (tail != null) {
            tail.right = root;
        } else {
            head = root;
        }
        root.left = tail;
        tail = root;
        dfs(root.right);
    }
}
