package cn.sichu.graduate_practice.codetop.yuanfudao;

import cn.sichu.graduate_practice.offer.Node;

/**
 * backend 频率3
 * <p>
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 
 * @author sichu
 * @date 2022/05/04
 */
public class Offer36 {
    Node pre = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;

        dfs(root.right);
    }
}
